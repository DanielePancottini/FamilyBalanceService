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
		result super.objectMapper.fromModelToDomain(super.getObjectById(id, entityToSearch, session), domainClass)
	}
	
}
