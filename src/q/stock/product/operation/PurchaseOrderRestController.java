package q.stock.product.operation;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import q.stock.product.dao.PurchaseOrderDao;
import q.stock.product.model.entity.PurchaseOrder;
import q.stock.product.model.entity.SalesOrder;

@Path("/api/v2/purchaseOrder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseOrderRestController extends GenericRestController<PurchaseOrder> {

	@Inject
	PurchaseOrderDao purchaseOrderService;

	public PurchaseOrderRestController() {
		super(PurchaseOrder.class);
	}
	
	
	@GET
	@Path("/findPurchaes/{id}")
	public Response findPurchaesOrderForupplier(@PathParam("id") int id) {
		List<PurchaseOrder> orders = purchaseOrderService.findPurchaseForsupplier(id);
		return Response.ok().entity(orders).build();
	}
}
