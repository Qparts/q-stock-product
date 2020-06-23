package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import q.stock.product.dao.QuotationOrderProductDao;
import q.stock.product.model.entity.QuotationOrderProduct;

@Path("/api/v2/quotationOrderProduct")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuotationOrderProductRestController extends GenericRestController<QuotationOrderProduct>{

	@Inject
	QuotationOrderProductDao quotationOrderProductDao;

	public QuotationOrderProductRestController() {
		super(QuotationOrderProduct.class);
	}

}
