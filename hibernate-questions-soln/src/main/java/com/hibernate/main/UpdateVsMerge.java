package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class UpdateVsMerge {
	public static void main(String[] args) {

		Employee emp1 = new Employee();
		emp1.setId(5);
		emp1.setAge(33);
		emp1.setName("Alex");
		
		try {

			Session session1 = HibernateUtil.getSessionFactory().openSession();
			session1.beginTransaction();
			session1.save(emp1);
			// session1.evict(emp1);
			// emp1.setName("Alex-2");
			//session1.update(emp1);
			session1.getTransaction().commit();
			session1.close();
			emp1.setId(4);
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			session2.beginTransaction();
			session2.merge(emp1);
			session2.getTransaction().commit();
			session2.close();
			
		} catch (Exception e) {
			System.err.println(e.fillInStackTrace());
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
