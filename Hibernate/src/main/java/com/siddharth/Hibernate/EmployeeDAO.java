package com.siddharth.Hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDAO {
	
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		
		EmployeeDTO emp=new EmployeeDTO();
		emp.setId(2);
		emp.setName("siddharth");
		emp.setSalary(400000);
		emp.setMobile(350337389);
		
		manager.persist(emp);
		transaction.commit();
		
		factory.close();
		manager.close();
	}

}
