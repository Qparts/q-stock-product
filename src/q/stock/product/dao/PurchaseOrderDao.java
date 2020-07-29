package q.stock.product.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.Query;

import q.stock.product.model.entity.PurchaseOrder;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class PurchaseOrderDao extends BaseDao<PurchaseOrder> {

	public List<PurchaseOrder> findPurchaseForsupplier(int id) {
		Query query = em.createQuery(
				"SELECT e FROM PurchaseOrder" + " e where e.supplierId" + "=" + id + " order by e.id desc")
				.setMaxResults(10);
		return query.getResultList();
	}

}
