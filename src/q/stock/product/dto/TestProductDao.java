package q.stock.product.dto;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;

import q.stock.product.model.entity.Product;

public class TestProductDao {
	@PersistenceContext(unitName = "QStockProductPU")
	protected EntityManager em;

	@Test
	public void test() {
		String sql = "SELECT e FROM " + Product.class.getName() + " e INNER JOIN e.categories j ";
		System.out.println(sql);
		Query query = em.createQuery(sql);
		List<Product> products = query.getResultList();
		assertNotNull(sql);
	}
}
