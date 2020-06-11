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

import q.stock.product.dao.ProdutDao;
import q.stock.product.dto.SearchDto;
import q.stock.product.model.entity.Product;

@Path("/api/v2/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRestController extends GenericRestController<Product> {

	@Inject
	ProdutDao productService;

	public ProductRestController() {
		super(Product.class);
	}

	@POST
	@Path("/search")
	public Response filterWithCondition(List<SearchDto> filters) {
		try {
			return Response.ok().entity(productService.filter(filters)).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/{parameter}/{value}")
	public Response findAll(@PathParam("parameter") String parameter, @PathParam("value") String value) {
		try {
			return Response.ok().entity(productService.addPriceAndQuantity(super.getAll(parameter, value))).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

}
