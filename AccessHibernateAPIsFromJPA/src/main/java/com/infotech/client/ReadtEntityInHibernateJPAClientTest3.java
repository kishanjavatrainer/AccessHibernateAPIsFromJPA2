package com.infotech.client;

import javax.persistence.EntityManager;

import org.hibernate.engine.spi.SessionImplementor;

import com.infotech.entities.Person;
import com.infotech.util.JPAUtil;

public class ReadtEntityInHibernateJPAClientTest3 {

	public static void main(String[] args) {
		SessionImplementor sessionImplementor = null;
		try {
			EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			sessionImplementor = entityManager.unwrap(SessionImplementor.class);
			
			Person person = sessionImplementor.get(Person.class, 2L);
			
			System.out.println(person.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sessionImplementor != null)
				sessionImplementor.close();
		}
	}
}
