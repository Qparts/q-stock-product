package q.stock.product.operation;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.model.entity.Category;

@Path("/api/v2/category")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryRestController extends GenericRestController<Category>{

	public CategoryRestController() {
		super(Category.class);
	}
}
