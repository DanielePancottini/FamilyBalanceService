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

import it.team4tech.familybalance.domain.Cost;
import it.team4tech.familybalance.workers.CostWorker;

/**
 * Resource that handles cost endpoint, all CRUD operations implemented
 * 
 * @author Daniele Pancottini
 *
 */

@Path("costs")
public class CostResource {

	CostWorker costWorker;
	
	@Inject
	Gson gson;
	
	public CostResource() {
		this.costWorker = new CostWorker();
	}
	
	@GET
	@Path("{id}")
	public Response getCostById(@PathParam("id") Integer id) {
		return Response.ok(gson.toJson(costWorker.getCostById(id))).build();
	}
	
	@GET
	public Response getCost() {
		return Response.ok(gson.toJson(costWorker.getCosts())).build();
	}
	
	@POST
	public Response postCost(String body) {
		Cost cost = this.gson.fromJson(body, Cost.class);
		return Response.ok(this.gson.toJson(this.costWorker.persistCost(cost))).status(Status.CREATED).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateCost(@PathParam("id") Integer id, String body) {
		Cost cost = gson.fromJson(body, Cost.class);
		return Response.ok(gson.toJson(this.costWorker.updateCost(cost))).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCost(@PathParam("id") Integer id) {
		this.costWorker.deleteCost(id);
		return Response.status(Status.NO_CONTENT).build();
	}
	
}
