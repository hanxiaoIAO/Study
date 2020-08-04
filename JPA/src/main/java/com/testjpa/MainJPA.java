package com.testjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainJPA {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_details");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		StudentEntity uk = new StudentEntity();
		uk.setId(0);
		uk.setName("uk");
		uk.setAge(25);

		StudentEntity xx = new StudentEntity();
		xx.setId(1);
		xx.setName("xx");
		xx.setAge(26);

		entityManager.persist(uk);
		entityManager.persist(xx);

		entityManager.getTransaction().commit();
		
//		entityManager.getTransaction().begin();
		
//		StudentEntity finduk = entityManager.find(StudentEntity.class, 0);
//		System.out.println(finduk.getName());
//		finduk.setAge(25);
//		entityManager.remove(finduk);
//		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
