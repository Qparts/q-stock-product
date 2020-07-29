package q.stock.product.operation;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import q.stock.product.dao.SalesOrderDao;
import q.stock.product.model.entity.Customer;
import q.stock.product.model.entity.SalesOrder;

@Path("/api/v2/salesOrder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SalesOrderRestController extends GenericRestController<SalesOrder> {

	@Inject
	SalesOrderDao salesOrderDao;

	public SalesOrderRestController() {
		super(SalesOrder.class);
	}

	@POST()
	@Path("/createSalesOrder")
	public Response createSalesOrder(SalesOrder salesOrder) {
		SalesOrder salesOrderEntity = salesOrderDao.createSalesOrder(salesOrder);
		return Response.ok().entity(salesOrderEntity).build();

	}

	@GET
	@Path("/findSales/{id}")
	public Response findSalesOrderForCutomer(@PathParam("id") int id) {
		List<SalesOrder> orders = salesOrderDao.findSalesForCustomer(id);
		return Response.ok().entity(orders).build();
	}
}
