package it.team4tech.familybalance.workers;

import java.util.List;

import it.team4tech.familybalance.domain.Family;
import it.team4tech.familybalance.endpoints.FamilyResource;
import it.team4tech.familybalance.models.FamilyEntity;

/**
 * Worker of {@link FamilyResource}, extending {@link AbstractResourceWorker}
 * @author Daniele Pancottini
 *
 */
public class FamilyWorker extends AbstractResourceWorker{

	public FamilyWorker() {
		super();
	}
	
	public Family persistFamily(Family param) {
		FamilyEntity result = super.persistObject(super.objectMapper.fromDomainToModel(param, FamilyEntity.class), super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(result, Family.class);
	}
	
	public Family getFamilyById(Integer id) {
		FamilyEntity entityFound = super.getObjectById(id, FamilyEntity.class, super.sessionFactory.openSession()).get(0);
		return super.objectMapper.fromModelToDomain(entityFound, Family.class);
	}
	
	public List<Family> getFamilies() {
		List<FamilyEntity> entitiesFound = super.getObjectsList(FamilyEntity.class, super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomainList(entitiesFound, Family.class);
	}
	
	public Family updateFamily(Family param) {
		FamilyEntity result = super.updateObject(super.objectMapper.fromDomainToModel(param, FamilyEntity.class), super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(result, Family.class);
	}
	
	public void deleteFamily(Integer id) {
		super.deleteObjectById(id, FamilyEntity.class, super.sessionFactory.openSession());
	}
	
}
