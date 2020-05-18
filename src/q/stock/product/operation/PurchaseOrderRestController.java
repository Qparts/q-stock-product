package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.dao.PurchaseOrderDao;
import q.stock.product.model.entity.PurchaseOrder;

@Path("/api/v2/purchaseOrder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseOrderRestController extends GenericRestController<PurchaseOrder> {

	@Inject
	PurchaseOrderDao purchaseOrderService;

	public PurchaseOrderRestController() {
		super(PurchaseOrder.class);
	}
}
