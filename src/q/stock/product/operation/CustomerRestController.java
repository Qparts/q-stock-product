package q.stock.product.operation;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.model.entity.Customer;

@Path("/api/v2/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRestController extends GenericRestController<Customer> {

	public CustomerRestController() {
		super(Customer.class);
	}

}
