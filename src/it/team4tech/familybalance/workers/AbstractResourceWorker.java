package it.team4tech.familybalance.workers;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import javax.ws.rs.core.Response.Status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.team4tech.familybalance.configuration.db.HibernateBaseConfiguration;
import it.team4tech.familybalance.exceptions.ServiceException;
import it.team4tech.familybalance.utils.ImplicitObjectMapper;
import it.team4tech.familybalance.utils.TriFunction;

/**
 * This class contains the base methods to interact with persistance layer
 * extend and override methods as needed
 * 
 * @author Daniele Pancottini
 *
 */
public abstract class AbstractResourceWorker {
	
	SessionFactory sessionFactory;
	ImplicitObjectMapper objectMapper;
	
	public AbstractResourceWorker() {
		this.sessionFactory = HibernateBaseConfiguration.getSessionFactory();
		this.objectMapper = new ImplicitObjectMapper();
	}
	

	/**
	 * Method to perform a certain action under single transaction
	 * 
	 * @param <T>
	 * @param session - {@link Session} instance
	 * @param inputParam - object param for the action
	 * @param action - {@link BiConsumer} that describes the action
	 * @return T - object state after action just performed
	 * 
	 * @author Daniele Pancottini
	 */
	
	public <T> T executeInTransaction(Session session, T inputParam, BiConsumer<Session, T> action) {
		try {
			session.beginTransaction();
			action.accept(session, inputParam);
			session.getTransaction().commit();
			return inputParam;
		}
		catch(Exception e) {
			session.getTransaction().rollback();
			throw new ServiceException(e.getClass().getName(), Status.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		finally {
			if(session.getTransaction().isActive()) 
				session.getTransaction().rollback();
			else
				session.close();
		}
	}
	
	/**
	 * Method to use only in case of find entity/s
	 * 
	 * @param <T>
	 * @param id - record id (to be used only to retreive a limited rows)
	 * @param entityToSearch - class of entity to search
	 * @param session - session instance 
	 * @param action - {@link TriFunction} 
	 * @return List<T> - list of record founded
	 * 
	 * @author Daniele Pancottini
	 */
	
	public <T> List<T> findEntity(Integer id, Class<T> entityToSearch, Session session, TriFunction<Integer, Class<T>, Session, List<T>> action) {
		try {
			session.beginTransaction();
			List<T> result = (List<T>) action.apply(id, entityToSearch, session);
			session.getTransaction().commit();
			return result;
		}
		catch(Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
		finally {
			if(session.getTransaction().isActive())
				session.getTransaction().rollback();
			else
				session.close();
		}
	}
	
	/*
	 * Get Methods
	 */
	
	public <T> List<T> getObjectById(Integer id, Class<T> entityToSearch, Session session) {
		List<T> result = findEntity(id, entityToSearch, session, this::getObjectByIdFunction);
		if(result == null)
			throw new ServiceException("Resource Not Found", Status.NOT_FOUND, "Resource with id: " + id + "; not found");
		else
			return result;
	}
	
	public <T> List<T> getObjectByIdFunction(Integer id, Class<T> entityToSearch, Session session) {
		return Arrays.asList(session.find(entityToSearch, id));
	}
	
	public <T> List<T> getObjectsList(Class<T> entityToSearch, Session session) {
		List<T> result = findEntity(null, entityToSearch, session, this::getObjectsListFunction);
		if(result == null)
			throw new ServiceException("Rescources not found", Status.NOT_FOUND, "No rows found for entity: " + entityToSearch.getSimpleName());
		else
			return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getObjectsListFunction(Integer id, Class<T> entityToSearch, Session session) {
		return session.createQuery("from " + entityToSearch.getSimpleName()).list();
	}
	
	/*
	 * Persist methods
	 */
	
	public <T> T persistObject(T object, Session session) {
		return this.executeInTransaction(session, object, this::persistObject);
	}
	
	public <U> void persistObject(Session session, U inputObject) {
		session.persist(inputObject);
	}
	
	/*
	 * Update Methods
	 */
	
	public <T> T updateObject(T object, Session session) {
		return executeInTransaction(session, object, this::updateObjectConsumer);
	}
	
	public <T> void updateObjectConsumer(Session session, T object) {
		if(!session.contains(object))
			session.merge(object);
	}
	
	/*
	 * Delete Methods
	 */
	
	public <T> void deleteObjectById(Integer id, Class<T> entityClass, Session session) {
		findEntity(id, entityClass, session, this::deleteObjectByIdFunction);
	}
	
	public <T> List<T> deleteObjectByIdFunction(Integer id, Class<T> entityClass, Session session){
		T object = session.find(entityClass, id);
		session.delete(object);
		return null;
	}
	
}
