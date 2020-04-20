package q.stock.product.operation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import q.stock.product.model.entity.ProductPrice;

@Path("/api/v2/productPrice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductPriceRestController extends GenericRestController<ProductPrice>{
	
	public ProductPriceRestController() {
		super(ProductPrice.class);
	}


	@GET
	@Path("/{productId}")
	public Response findAllForProduct(@PathParam("productId") int productId) {
		try {
			return Response.ok().entity(super.getAll("productId" ,String.valueOf(productId))).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

}
