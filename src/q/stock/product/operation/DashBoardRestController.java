package q.stock.product.operation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import q.stock.product.dao.DashboardDao;

@Path("/api/v2/dashboard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DashBoardRestController {

	@Inject
	private DashboardDao dashboardDao;

	@GET
	public Response getDashboardInfo() {
		try {
			return Response.ok().entity(dashboardDao.getDashboard()).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

}
