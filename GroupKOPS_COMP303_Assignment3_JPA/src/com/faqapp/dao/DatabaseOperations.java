package com.faqapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseOperations {
	// PERSISTENCE_UNIT_NAME is the name recorded in the persistence.xml file
	private static final String PERSISTENCE_UNIT_NAME = "GroupKOPS_COMP303_Assignment3_JPA";
	private static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction et = em.getTransaction();
}
