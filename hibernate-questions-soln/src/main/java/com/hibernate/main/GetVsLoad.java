package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class GetVsLoad {
	public static void main(String[] args) {
		Employee emp = new Employee();
		// emp.setId(1);
		emp.setName("Steve");
		emp.setAge(40);

		try {
			Session session1 = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session1.beginTransaction();
			session1.save(emp);
			transaction.commit();
			session1.close();
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			Employee emp1 = session2.get(Employee.class, 4L);
			// System.out.println(emp1);
			System.out.println(emp1);
			session2.close();
			// Works for get but not for load
			//System.out.println(emp1);
			
		} catch (Exception e) {
			System.err.println(e.fillInStackTrace());
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
