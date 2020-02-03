package it.team4tech.familybalance.workers;

import java.util.List;

import it.team4tech.familybalance.domain.Cost;
import it.team4tech.familybalance.endpoints.CostResource;
import it.team4tech.familybalance.models.CostEntity;

/**
 * Worker of {@link CostResource}, extending {@link AbstractResourceWorker}
 * @author Daniele Pancottini
 *
 */
public class CostWorker extends AbstractResourceWorker {
	
	public CostWorker() {
		super();
	}
	
	public Cost persistCost(Cost cost) {
		CostEntity modelParam = super.objectMapper.fromDomainToModel(cost, CostEntity.class);
		CostEntity modelResult = super.persistObject(modelParam, super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(modelResult, Cost.class);
	}
	
	public Cost getCostById(Integer id) {
		CostEntity result = super.getObjectById(id, CostEntity.class, super.sessionFactory.openSession()).get(0);
		return super.objectMapper.fromModelToDomain(result, Cost.class);
	}
	
	public List<Cost> getCosts(){
		List<CostEntity> list = super.getObjectsList(CostEntity.class, super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomainList(list, Cost.class);
	}
	
	public Cost updateCost(Cost cost) {
		CostEntity result = super.updateObject(super.objectMapper.fromDomainToModel(cost, CostEntity.class), super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(result, Cost.class);
	}
	
	public void deleteCost(Integer id) {
		super.deleteObjectById(id, CostEntity.class, super.sessionFactory.openSession());
	}
	
}
