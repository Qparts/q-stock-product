package q.stock.product.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.Query;

import q.stock.product.dto.ProductDetialDto;
import q.stock.product.dto.SearchDto;
import q.stock.product.filter.Utils;
import q.stock.product.model.entity.Product;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ProdutDao extends BaseDao<Product> {
	@Inject
	private LiveStockDao liveStockDao;

	@SuppressWarnings("unchecked")
	public List<Product> filter(List<SearchDto> filters) {
		String filterValue = Utils.getCriteria(filters);
		String sql;
		if (filterValue.contains("j.id"))
			sql = "SELECT e FROM " + Product.class.getName() + " e left join  e.categories j " + " where " + filterValue
					+ " group by e.id";
		else
			sql = "SELECT e FROM " + Product.class.getName() + " e where " + filterValue;

		Query query = em.createQuery(sql);

		List<Product> products = query.getResultList();

		addPriceAndQuantity(products);

		return products;
	}

	public List<Product> addPriceAndQuantity(List<Product> products) {

		products = setPrice(products);

		Map<Integer, Integer> liveStockProductQuantity = getLiveStokQuantity();

		setProductQunatity(products, liveStockProductQuantity);

		return products;
	}

	private void setProductQunatity(List<Product> products, Map<Integer, Integer> liveStockProductQuantity) {
		products.stream().map(product -> {
			int quantity = liveStockProductQuantity.containsKey(product.getId())? liveStockProductQuantity.get(product.getId()):0;
			product.setQuantity(quantity);
			return product;
		}).collect(Collectors.toList());

	}

	private Map<Integer, Integer> getLiveStokQuantity() {
		Map<Integer, Integer> liveStockProductQuantity = new HashMap<>();
		Query q = em.createNativeQuery("select product_id ,sum(quantity) as quantity from inv_live_stock "
				+ "where quantity>0" + " group by product_id");
		List<Object[]> liveStockQuantity = q.getResultList();
		for (Object[] a : liveStockQuantity) {
			liveStockProductQuantity.put((int) a[0],((BigInteger)a[1]).intValue());
		}
		return liveStockProductQuantity;
	}

	public List<Product> setPrice(List<Product> products) {
		return products.stream().map(product -> {
			double price = product.getProductPrices() == null || product.getProductPrices().size() == 0 ? 0
					: product.getProductPrices().stream().filter(pr -> pr.getPriceType() == 'S')
							.collect(Collectors.toList()).get(0).getPrice();
			product.setPrice(price);
			return product;
		}).collect(Collectors.toList());
	}

	public ProductDetialDto getProductDetials(int id) {
		
		ProductDetialDto productDetials = new ProductDetialDto();
		
		Query q = em.createNativeQuery("select  div(sum(purchase_price),count(*)) from inv_purchase_order_products where product_id ="+id);
		BigDecimal averagePrice = (BigDecimal) q.getResultList().get(0);
		productDetials.setAveragePrice(averagePrice==null?0 :averagePrice.doubleValue());
		
		Query numberOfPreviousYearSalesOrder = em.createNativeQuery("select count(*)  from inv_sales_order s\r\n" + 
				"join inv_sales_order_product p on s.id = p.sales_id\r\n" + 
				"where created > (select  (NOW() - interval '1 year')) and p.product_id ="+id);
		BigInteger previousYearSalesOrders =  (BigInteger) numberOfPreviousYearSalesOrder.getResultList().get(0);
		productDetials.setPreviousYearSalesOrders(previousYearSalesOrders==null?0:previousYearSalesOrders.intValue());
		
		
		Query numberOfPreviousYearPurchaseOrder = em.createNativeQuery("select count(*)  from inv_purchase_order o\r\n" + 
				"join inv_purchase_order_products p on o.id = p.purchase_id\r\n" + 
				"where created > (select  (NOW() - interval '1 year')) and p.product_id ="+id);
		BigInteger previousYearPurchaseOrders = (BigInteger) numberOfPreviousYearPurchaseOrder.getResultList().get(0);
		
		productDetials.setPreviousYearPurchaseOrder(previousYearPurchaseOrders==null?0:previousYearPurchaseOrders.intValue());
		
		Query lastThreePurchaseOrder = em.createQuery("SELECT p.purchaseOrder from PurchaseOrderProducts p where p.productId="+
		id+" order by p.purchaseOrder.id desc").setMaxResults(3);
		
		productDetials.setLastThreePurchaseOrders(lastThreePurchaseOrder.getResultList());
		
		
		Query lastThreeSalesOrder = em.createQuery("SELECT p.salesOrder from SalesOrderProduct p where p.productId="+
				id+" order by  p.salesOrder.id desc").setMaxResults(3);
		productDetials.setLastThreeSalesOrders(lastThreeSalesOrder.getResultList());
		
		return productDetials;
	}

}
