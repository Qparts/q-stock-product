package q.stock.product.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;

import q.stock.product.model.entity.SalesOrderProduct;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class SalesOrderProductDao extends BaseDao<SalesOrderProduct> {

}
