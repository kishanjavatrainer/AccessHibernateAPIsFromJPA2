package com.infotech.client;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.infotech.entities.Book;
import com.infotech.entities.Person;
import com.infotech.util.JPAUtil;

public class PersistEntityHibernateClientTest2 {

	public static void main(String[] args) {
		EntityManager entityManager = null;
		try {
			Person author1 = new Person();
			author1.setName("Gavin King2");
			
			Book book1 = new Book();
			book1.setIsbn("978-9730228237");
			book1.setTitle("Hibernate High-Performance Java Persistence");
			book1.setAuthor(author1);
			
			Book book2 = new Book();
			book2.setIsbn("900-973022852");
			book2.setTitle("Hibernate Persistence Contexts2");
			book2.setAuthor(author1);
			
			author1.getBooks().add(book1);
			author1.getBooks().add(book2);
			
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			Session session = entityManager.unwrap(Session.class);
			
			session.getTransaction().begin();
			
			session.persist(author1);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(entityManager != null)
				entityManager.close();
		}
	}
}
