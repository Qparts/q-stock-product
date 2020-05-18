package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.dao.PurchaseOrderProductsDao;
import q.stock.product.model.entity.PurchaseOrderProducts;

@Path("/api/v2/purchaseOrderProducts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseOrderProductsRestController extends GenericRestController<PurchaseOrderProducts> {

	@Inject
	PurchaseOrderProductsDao PurchaseOrderProductsService;

	public PurchaseOrderProductsRestController() {
		super(PurchaseOrderProducts.class);
	}
}
