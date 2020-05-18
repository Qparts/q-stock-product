package q.stock.product.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;

import q.stock.product.model.entity.PurchaseOrder;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class PurchaseOrderDao extends BaseDao<PurchaseOrder> {

}
