package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.dao.SalesOrderProductDao;
import q.stock.product.model.entity.SalesOrderProduct;

@Path("/api/v2/salesOrderProduct")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SalesOrderProductRestController extends GenericRestController<SalesOrderProduct> {

	@Inject
	SalesOrderProductDao salesOrderProductDao;

	public SalesOrderProductRestController() {
		super(SalesOrderProduct.class);
	}
}
