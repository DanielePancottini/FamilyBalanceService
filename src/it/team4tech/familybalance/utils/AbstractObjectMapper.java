package it.team4tech.familybalance.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

/**
 * This class uses {@link ModelMapper} to convert model to domain and vice versa.
 * Extends and override as needed
 * 
 * @author Daniele Pancottini
 *
 */
public abstract class AbstractObjectMapper {

	ModelMapper modelMapper;
	
	public AbstractObjectMapper() {
		this.modelMapper = new ModelMapper();
	}
	
	public <T, U> T fromDomainToModel(U domain, Class<T> modelClass) {
		return modelMapper.map(domain, modelClass);
	}
	
	public <T, U> T fromModelToDomain(U model, Class<T> domainClass) {
		return modelMapper.map(model, domainClass);
	}
	
	public <T, U> List<T> fromModelToDomainList(List<U> model, Class<T> domainClass){
		List<T> result = new ArrayList<T>();
		for(U x : model){
			result.add(modelMapper.map(x, domainClass));
		}
		return result;
	}
	
}
