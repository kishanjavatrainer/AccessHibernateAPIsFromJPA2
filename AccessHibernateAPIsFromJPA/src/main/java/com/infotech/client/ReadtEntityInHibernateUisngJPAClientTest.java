package com.infotech.client;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;

import com.infotech.entities.Person;
import com.infotech.util.JPAUtil;

public class ReadtEntityInHibernateUisngJPAClientTest {

	public static void main(String[] args) {
		Session session = null;
		try {
			EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
			session = sessionFactory.openSession();
			
			Person person = session.get(Person.class, 2L);
			
			System.out.println(person.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
	}
}
