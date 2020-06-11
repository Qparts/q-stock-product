package q.stock.product.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.Query;

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

}
