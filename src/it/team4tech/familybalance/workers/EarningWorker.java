package it.team4tech.familybalance.workers;

import java.util.List;

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
		return super.objectMapper.fromModelToDomain(super.getObjectById(id, EarningEntity.class, super.sessionFactory.openSession()), Earning.class);
	}
	
	public List<Earning> getEarnings(){
		return super.objectMapper.fromModelToDomainList(super.getObjectsList(EarningEntity.class, super.sessionFactory.openSession()), Earning.class);
	}
	
	public Earning updateEarning(Earning param) {
		EarningEntity entity = super.updateObject(super.objectMapper.fromDomainToModel(param, EarningEntity.class), super.sessionFactory.openSession());
		return super.objectMapper.fromModelToDomain(entity, Earning.class);
	}
	
	public void deleteEarning(Integer id) {
		super.deleteObjectById(id, EarningEntity.class, super.sessionFactory.openSession());
	}
	
}
