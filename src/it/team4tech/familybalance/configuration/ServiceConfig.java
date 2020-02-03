package it.team4tech.familybalance.configuration;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.google.gson.Gson;

import it.team4tech.familybalance.utils.CustomGsonFactory;

@ApplicationPath("api")
public class ServiceConfig extends ResourceConfig {

	public ServiceConfig() {
		packages("it.team4tech.familybalance");
		
		register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				bindFactory(CustomGsonFactory.class).to(Gson.class);
			}
		});
	}
	
	
	
}
