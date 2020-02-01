package it.team4tech.familybalance.configuration;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class ServiceConfig extends ResourceConfig {

	public ServiceConfig() {
		packages("it.team4tech.familybalance");
	}
	
}
