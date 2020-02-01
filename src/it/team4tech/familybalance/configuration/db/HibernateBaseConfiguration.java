package it.team4tech.familybalance.configuration.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.team4tech.familybalance.models.CostEntity;
import it.team4tech.familybalance.models.EarningEntity;
import it.team4tech.familybalance.models.FamilyEntity;

public class HibernateBaseConfiguration {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	  private static SessionFactory buildSessionFactory() {
	    try {
	      // Create the SessionFactory from hibernate.cfg.xml
	      //return new Configuration().configure().buildSessionFactory();
	      return new Configuration().configure("/it/team4tech/familybalance/configuration/db/hibernate-development.cfg.xml")
						    		.addAnnotatedClass(CostEntity.class)
						    		.addAnnotatedClass(EarningEntity.class)
						    		.addAnnotatedClass(FamilyEntity.class)
	    		  					.buildSessionFactory();
	    } catch (Throwable ex) {
	      // Make sure you log the exception, as it might be swallowed
	      System.err.println("Initial SessionFactory creation failed." + ex);
	      throw new ExceptionInInitializerError(ex);
	    }
	  }
	 
	  public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	  }
	 
	  public static void shutdown() {
	    // Close caches and connection pools
	    getSessionFactory().close();
	  }
	
}
