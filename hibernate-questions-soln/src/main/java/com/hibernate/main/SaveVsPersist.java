package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class SaveVsPersist {
	public static void main(String[] args) {
		Employee emp = new Employee();
		// emp.setId(1);
		emp.setName("Steve");
		emp.setAge(40);

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(emp);
			session.evict(emp);
			// session.persist(emp);
			session.save(emp);
			session.getTransaction().commit();
			session.close();
			
			// System.out.println(session.load(Employee.class, 1L));
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}
}
