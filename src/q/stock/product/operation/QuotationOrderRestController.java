package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.dao.QuotationOrderDao;
import q.stock.product.model.entity.QuotationOrder;

@Path("/api/v2/quotationOrder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuotationOrderRestController extends GenericRestController<QuotationOrder> {

	@Inject
	QuotationOrderDao quotationOrderDao;

	public QuotationOrderRestController() {
		super(QuotationOrder.class);
	}

}
