package q.stock.product.operation;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.model.entity.Product;

@Path("/api/v2/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestController extends GenericRestController<Product> {

	public ProductRestController() {
		super(Product.class);
	}

}
