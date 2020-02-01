package it.team4tech.familybalance.endpoints;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import it.team4tech.familybalance.domain.Cost;
import it.team4tech.familybalance.workers.CostWorker;

/**
 * Resource that handles cost endpoint, all CRUD operations implemented
 * 
 * @author Daniele Pancottini
 *
 */

@Path("/cost")
public class CostResource {

	CostWorker costWorker;
	Gson gson;
	
	public CostResource() {
		this.costWorker = new CostWorker();
		this.gson = new Gson();
	}
	
	@GET
	@Path("{id}")
	public Response getCostById(@PathParam("id") Integer id) {
		Cost result = costWorker.getCostById(id);
		
		if(result == null)
			return Response.serverError().build();
		else
			return Response.ok(gson.toJson(result)).build();
	}
	
	@GET
	public Response getCost() {
		List<Cost> result = costWorker.getCosts();
		
		if(result == null)
			return Response.serverError().build();
		else
			return Response.ok(gson.toJson(result)).build();
	}
	
	@POST
	public Response postCost(String body) {
		Cost cost = this.gson.fromJson(body, Cost.class);
		Cost result = this.costWorker.persistCost(cost);
		
		if(result == null)
			return Response.serverError().build();
		else
			return Response.ok(this.gson.toJson(result)).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateCost(@PathParam("id") Integer id, String body) {
		Cost cost = gson.fromJson(body, Cost.class);
		Cost result = this.costWorker.updateCost(cost);
		
		if(result == null)
			return Response.serverError().build();
		else
			return Response.ok(gson.toJson(result)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCost(@PathParam("id") Integer id) {
		this.costWorker.deleteCost(id);
		return Response.ok().build();
	}
	
}
