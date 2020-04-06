package q.stock.product.operation;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.model.entity.Brand;

@Path("/api/v2/brand")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BrandRestController extends GenericRestController<Brand> {

	public BrandRestController() {
		super(Brand.class);
	}

}
