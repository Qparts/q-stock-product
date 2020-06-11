package q.stock.product.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.Query;

import q.stock.product.dto.ProductLiveStockQuantity;
import q.stock.product.model.entity.LiveStock;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class LiveStockDao extends BaseDao<LiveStock> {

	@SuppressWarnings("unchecked")
	public List<Integer> findAllProductsInLiveStock() {
		Query q = em.createNativeQuery("select distinct(product_id) from inv_live_stock where quantity>0");
		List<Integer> products = q.getResultList();
		return products;
	}
	
}
