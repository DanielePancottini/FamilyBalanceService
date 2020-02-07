package it.team4tech.familybalance.endpoints;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import it.team4tech.familybalance.domain.Earning;
import it.team4tech.familybalance.workers.EarningWorker;

/**
 * Resource that handles earning endpoint, all CRUD operations implemented
 * 
 * @author Daniele Pancottini
 *
 */

@Path("earnings")
public class EarningResource {

	@Inject
	Gson gson;
	EarningWorker worker;
	
	public EarningResource() {
		this.worker = new EarningWorker();
	}
	
	@GET
	public Response getEarnings() {
		return Response.ok(gson.toJson(worker.getEarnings())).build();
	}
	
	@GET
	@Path("{id}")
	public Response getEarningById(@PathParam("id") Integer id) {
		return Response.ok(gson.toJson(worker.getEarningById(id))).build();
	}
	
	@POST
	public Response postEarning(String body) {
		Earning result = worker.persistEarning(gson.fromJson(body, Earning.class));
		return Response.ok(gson.toJson(result)).status(Status.CREATED).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateEarning(@PathParam("id") Integer id, String body) {
		Earning result = worker.updateEarning(gson.fromJson(body, Earning.class));
		return Response.ok(gson.toJson(result)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteEarning(@PathParam("id") Integer id) {
		worker.deleteEarning(id);
		return Response.ok(Status.NO_CONTENT).build();
	}
	
}
