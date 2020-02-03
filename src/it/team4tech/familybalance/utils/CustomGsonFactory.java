package it.team4tech.familybalance.utils;

import org.glassfish.hk2.api.Factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.team4tech.familybalance.domain.Cost;
import it.team4tech.familybalance.domain.deserializer.CostDeserializer;


public class CustomGsonFactory implements Factory<Gson> {

	@Override
	public Gson provide() {
		return new GsonBuilder()
				.registerTypeAdapter(Cost.class, new CostDeserializer())
				.create();
	}

	@Override
	public void dispose(Gson instance) {
		/*
		 * nothing
		 */
	}
	
	
}
