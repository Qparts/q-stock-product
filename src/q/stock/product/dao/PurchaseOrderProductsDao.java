package q.stock.product.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;

import q.stock.product.model.entity.PurchaseOrderProducts;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class PurchaseOrderProductsDao extends BaseDao<PurchaseOrderProducts> {

}
