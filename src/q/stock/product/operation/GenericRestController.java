package q.stock.product.operation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import q.stock.product.dao.BaseDao;
import q.stock.product.dto.SearchDto;

public class GenericRestController<T extends Serializable> extends BaseDao<T> {

	private Class<T> type;

	public GenericRestController() {
	}

	public GenericRestController(Class<T> type) {
		super(type);
	}

	@GET
	public Response findAll() {
		try {
			return Response.ok().entity(super.getAll()).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/{parameter}/{value}")
	public Response findAll(@PathParam("parameter") String parameter, @PathParam("value") String value) {
		try {
			return Response.ok().entity(super.getAll(parameter, value)).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/{id}")
	public Response findItem(@PathParam("id") int id) {
		try {
			return Response.ok().entity(super.find(id)).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@POST
	public Response creatItem(T entity) {
		try {
			return Response.ok().entity(super.create(entity)).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@PUT
	public Response updateItem(T entity) {
		try {
			super.update(entity);
			return Response.status(200).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response deleteItem(@PathParam("id") int id) {
		try {
			super.delete(id);
			return Response.status(201).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@POST
	@Path("/search")
	public Response filterWithCondition(List<SearchDto> filters) {
		try {
			return Response.ok().entity(super.filter(filters)).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

	@POST
	@Path("/saveAll")
	public Response saveAll(List<T> entities) {
		try {
			super.SaveAll(entities);
			return Response.status(200).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}

}
