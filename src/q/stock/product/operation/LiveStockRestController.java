package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import q.stock.product.dao.LiveStockDao;
import q.stock.product.model.entity.LiveStock;

@Path("/api/v2/liveStock")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LiveStockRestController extends GenericRestController<LiveStock> {

	@Inject
	LiveStockDao liveStockDao;

	public LiveStockRestController() {
		super(LiveStock.class);
	}

	@GET
	@Path("/liveStockProducts")
	public Response findAllProductsInLiveStok() {
		try {
			return Response.ok().entity(liveStockDao.findAllProductsInLiveStock()).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

}
