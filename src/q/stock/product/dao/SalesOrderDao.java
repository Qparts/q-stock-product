package q.stock.product.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;

import q.stock.product.dto.LiveStockPurchaseProductDto;
import q.stock.product.exception.NoEnoughQuantityException;
import q.stock.product.model.entity.Customer;
import q.stock.product.model.entity.SalesOrder;
import q.stock.product.model.entity.SalesOrderProduct;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class SalesOrderDao extends BaseDao<SalesOrder> {

	public List<SalesOrder> findSalesForCustomer(int id) {
		Query query = em
				.createQuery("SELECT e FROM SalesOrder" + " e where e.customerId" + "=" + id + " order by e.id desc")
				.setMaxResults(10);
		return query.getResultList();
	}

	@Transactional
	public synchronized SalesOrder createSalesOrder(SalesOrder salesOrder) {

		Set<SalesOrderProduct> salesOrderProducts = new HashSet();
//			getUserTransaction().begin();
		for (SalesOrderProduct salesProduct : salesOrder.getSalesOrderProducts()) {
			int productQuantity = salesProduct.getQuantity();
			List<LiveStockPurchaseProductDto> liveStockProducts = getLiveStockPurchaseProducts(
					salesProduct.getProductId());
			int index = 0;
			while (productQuantity > 0) {
				SalesOrderProduct currentSalesOrderProduct = new SalesOrderProduct(salesProduct.getId(),
						salesProduct.getProductId(), salesProduct.getPurchaseProductId(), salesProduct.getPrice(),
						salesProduct.getQuantity(), salesProduct.getSalesOrder());
				int liveStockQuantityTemp;
				if (productQuantity > liveStockProducts.get(index).getLiveStockQuantity()) {
					liveStockQuantityTemp = 0;
					currentSalesOrderProduct.setQuantity(liveStockProducts.get(index).getLiveStockQuantity());
				} else {
					liveStockQuantityTemp = liveStockProducts.get(index).getLiveStockQuantity() - productQuantity;
					currentSalesOrderProduct.setQuantity(productQuantity);
				}

				currentSalesOrderProduct.setPurchaseProductId(liveStockProducts.get(index).getPurchaseProductId());
				productQuantity -= liveStockProducts.get(index).getLiveStockQuantity();
				salesOrderProducts.add(currentSalesOrderProduct);
				liveStockProducts.get(index).setLiveStockQuantity(liveStockQuantityTemp);
				updateLiveStock(liveStockProducts.get(index));
				index++;
			}

		}
		salesOrder.setSalesOrderProducts(salesOrderProducts);
		em.persist(salesOrder);
//			getUserTransaction().commit();

		return salesOrder;
	}

	private void updateLiveStock(LiveStockPurchaseProductDto liveStockPurchaseProductDto) {
		if (liveStockPurchaseProductDto.getLiveStockQuantity() > 0) {
			em.createNativeQuery(
					"UPDATE inv_live_stock SET quantity =" + liveStockPurchaseProductDto.getLiveStockQuantity()
							+ " where id=" + liveStockPurchaseProductDto.getLiveStockId())
					.executeUpdate();
		} else {
			em.createNativeQuery("delete from inv_live_stock where id=" + liveStockPurchaseProductDto.getLiveStockId())
					.executeUpdate();
		}

	}

	private List<LiveStockPurchaseProductDto> getLiveStockPurchaseProducts(int productId) {
		List<LiveStockPurchaseProductDto> liveStockProducts = new ArrayList<>();
		Query q = em.createNativeQuery(
				"select  ls.id as liveStockId , ls.quantity as liveStockQuantity , pop.id as purchaseProductId, "
						+ "pop.quantity as purchaseProductQuantity,ls.purchase_id as purchaseProductPurchaseId"
						+ " from inv_live_stock ls join inv_purchase_order_products pop\r\n"
						+ "on ls.purchase_id = pop.purchase_id and ls.product_id = pop.product_id\r\n"
						+ "where ls.product_id =" + productId + " and ls.quantity>0 order by ls.id");
		List<Object[]> products = q.getResultList();
		for (Object[] a : products) {
			LiveStockPurchaseProductDto liveProduct = new LiveStockPurchaseProductDto((int) a[0], (int) a[1],
					(int) a[2], (int) a[3], (int) a[0]);
			liveStockProducts.add(liveProduct);
		}
		return liveStockProducts;
	}

	private boolean checkQuantity(SalesOrderProduct salesProduct) {
		Query q = em.createNativeQuery(
				"select sum(quantity) from inv_live_stock where product_id =" + salesProduct.getProductId());
		BigInteger totalQuantity = (BigInteger) q.getResultList().get(0);
		return salesProduct.getQuantity() <= totalQuantity.intValue();
	}

	private String productName(int prodID) {
		return (String) em.createNativeQuery("select name from prd_product where id =" + prodID).getResultList().get(0);
	}

}
