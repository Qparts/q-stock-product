package q.stock.product.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.Query;

import q.stock.product.dto.SearchDto;
import q.stock.product.filter.Utils;
import q.stock.product.model.entity.Product;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ProdutDao extends BaseDao<Product> {


	@SuppressWarnings("unchecked")
	public List<Product> filter(List<SearchDto> filters) {
		String filterValue = Utils.getCriteria(filters);
		String sql;
		if (filterValue.contains("j.id"))
			sql = "SELECT e FROM " + Product.class.getName() + " e left join  e.categories j " + " where "
					+ filterValue +" group by e.id";
		else
			sql = "SELECT e FROM " + Product.class.getName() + " e where " + filterValue;
		System.out.println(sql);
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

}
