package q.stock.product.operation;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.model.entity.Supplier;

@Path("/api/v2/supplier")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SupplierRestController extends GenericRestController<Supplier> {
	
	public SupplierRestController() {
		super(Supplier.class);
	}

}
