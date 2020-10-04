package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.PhoneBrand;
import com.hibernate.model.Phones;
import com.hibernate.util.HibernateUtil;

public class TestCRUDOperations {
	public static void main(String[] args) {

		List<Phones> phones = new ArrayList<>();

		Phones phones1 = new Phones();
		phones1.setId(1);
		phones1.setName("Redmi-8");
		phones1.setColour("Green");

		Phones phones2 = new Phones();
		phones2.setId(2);
		phones2.setName("Redmi-9");
		phones2.setColour("Red");

		phones.add(phones1);
		phones.add(phones2);

		PhoneBrand brand1 = new PhoneBrand();
		brand1.setId(1);
		brand1.setName("XIAOMI");
		brand1.setPhones(phones);
		
		// set brandName explicitly bcoz its not a bidirectional
		phones1.setPhoneBrand(brand1);
		phones2.setPhoneBrand(brand1);

		Phones phones3 = new Phones();
		phones3.setId(3);
		phones3.setName("Samsung-A70");
		phones3.setColour("Blue");

		Phones phones4 = new Phones();
		phones4.setId(4);
		phones4.setName("Samsung-M31");
		phones4.setColour("Green");

		phones = new ArrayList<>();
		phones.add(phones3);
		phones.add(phones4);
		
		PhoneBrand brand2 = new PhoneBrand();
		brand2.setId(2);
		brand2.setName("SAMSUNG");
		brand2.setPhones(phones);
		
		phones3.setPhoneBrand(brand2);
		phones4.setPhoneBrand(brand2);

		Phones phones5 = new Phones();
		phones5.setId(5);
		phones5.setName("Apple-10");
		phones5.setColour("White");

		Phones phones6 = new Phones();
		phones6.setId(6);
		phones6.setName("Apple-12");
		phones6.setColour("Black");

		phones = new ArrayList<>();
		phones.add(phones5);
		phones.add(phones6);

		PhoneBrand brand3 = new PhoneBrand();
		brand3.setId(3);
		brand3.setName("APPLE");
		brand3.setPhones(phones);
		
		phones5.setPhoneBrand(brand3);
		phones6.setPhoneBrand(brand3);

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			// session.save(brand1);
			// session.save(phones1);
			// session.save(phones2);
			// System.out.println(res);
			
			session.persist(brand1);
			session.persist(brand2);
			session.persist(brand3);
			
			// if we try to save brand1 before saving phones1/phones2, it will throw
			// transient object exception because there are
			// still some transient object

			// session.save(phones3);
			// session.save(phones4);
			// session.save(phones5);
			// session.save(phones6);

			// data are not going to get saved unless we commit the transaction. Default
			// commit value is false
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}
}
