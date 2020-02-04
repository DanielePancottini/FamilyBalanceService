package it.team4tech.familybalance.workers;

import it.team4tech.familybalance.domain.Earning;
import it.team4tech.familybalance.models.EarningEntity;

/**
 * Worker of {@link EarningResource}, extending {@link AbstractResourceWorker}
 * @author Daniele Pancottini
 *
 */
public class EarningWorker extends AbstractResourceWorker{

	public EarningWorker() {
		super();
	}
	
	public Earning persistEarning(Earning param) {
		EarningEntity result = super.persistObject(super.objectMapper.fromDomainToModel(param, EarningEntity.class), super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(result, Earning.class);
	}
	
	public Earning getEarningById(Integer id) {
		return super.objectMapper.fromModelToDomain(super.getObjectById(id, entityToSearch, session), Earning.class);
	}
	
	public List<Earning> getEarnings(){
		List<Earning> resultSet = super.getObjectsList(EarningEntity.class, super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomainList(resultSet, Earning.class);
	}
	
	public Earning updateEarning(Earning param){
		EarningEntity result = super.updateObject(super.objectMapper.fromDomainToModel(param, EarningEntity.class), super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(result, Entity.class);
	}
	
	public void deleteEntity(Integer id){
		super.deleteObjectById(id, EarningEntity.class, super.sessionFactory.openSession());
	}
	
}
