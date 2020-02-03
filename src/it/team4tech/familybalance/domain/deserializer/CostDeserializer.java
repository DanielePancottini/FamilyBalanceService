package it.team4tech.familybalance.domain.deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import it.team4tech.familybalance.domain.Cost;
import it.team4tech.familybalance.workers.FamilyWorker;

public class CostDeserializer implements JsonDeserializer<Cost> {

	@Override
	public Cost deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		Cost result = new Cost();
		FamilyWorker worker = new FamilyWorker();
		JsonObject inputObject = arg0.getAsJsonObject();
		
		//result.setCostId(!inputObject.get("costId").isJsonNull() ? inputObject.get("costId").getAsInt() : null);
		result.setCostName(!inputObject.get("costName").isJsonNull() ? inputObject.get("costName").getAsString() : null);
		result.setCostDescription(!inputObject.get("costDescription").isJsonNull() ? inputObject.get("costDescription").getAsString() : null);
		result.setCostType(!inputObject.get("costType").isJsonNull() ? it.team4tech.familybalance.utils.Type.valueOf(inputObject.get("costType").getAsString().toUpperCase()) : null);
		result.setCostValue(!inputObject.get("costValue").isJsonNull() ? inputObject.get("costValue").getAsDouble() : null);
		result.setCostFamily(!inputObject.get("costFamily").isJsonNull() ? worker.getFamilyById(inputObject.get("costFamily").getAsInt()) : null);
		
		return result;
	}

}
