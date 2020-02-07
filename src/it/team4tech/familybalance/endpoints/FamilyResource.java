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

import it.team4tech.familybalance.domain.Family;
import it.team4tech.familybalance.workers.FamilyWorker;

/**
 * Resource that handles family endpoint, all CRUD operations implemented
 * 
 * @author Daniele Pancottini
 *
 */

@Path("families")
public class FamilyResource {

	@Inject
	Gson gson;
	FamilyWorker worker;
	
	public FamilyResource() {
		this.worker = new FamilyWorker();
	}
	
	@GET
	@Path("{id}")
	public Response getFamilyById(@PathParam("id") Integer id) {
		return Response.ok(gson.toJson(this.worker.getFamilyById(id))).build();
	}
	
	@GET
	public Response getFamilies() {
		return Response.ok(gson.toJson(this.worker.getFamilies())).build();
	}
	
	@POST
	public Response postFamily(String body) {
		Family result = worker.persistFamily(gson.fromJson(body, Family.class));
		return Response.ok(gson.toJson(result)).status(Status.CREATED).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateFamily(@PathParam("id") Integer id, String body) {
		Family result = worker.updateFamily(gson.fromJson(body, Family.class));
		return Response.ok(gson.toJson(result)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteFamily(@PathParam("id") Integer id) {
		worker.deleteFamily(id);
		return Response.ok(Status.NO_CONTENT).build();
	}
	
}
