package it.team4tech.familybalance.exceptions;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Inject
	Gson gson;
	
	@Override
	public Response toResponse(Throwable exception) {
		
		Response resultResponse = this.checkCustomException(exception);
		
		if(resultResponse != null) {
			return resultResponse;
		}
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(exception)).build();
	}
	
	private Response checkCustomException(Throwable ex) {
		if(ex instanceof ServiceException)
			return Response.status(((ServiceException)ex).getExceptionStatus()).entity(gson.toJson(ex)).build();
		else
			return null;
	}
	
}
