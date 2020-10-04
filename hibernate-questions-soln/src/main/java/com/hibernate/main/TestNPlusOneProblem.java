package com.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.PhoneBrand;
import com.hibernate.model.Phones;
import com.hibernate.util.HibernateUtil;

public class TestNPlusOneProblem {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Phones> phones = (List<Phones>) session.createQuery("Select p from Phones p LEFT JOIN FETCH p.phoneBrand").getResultList();
		transaction.commit();
		session.close();
		phones.forEach(brands -> {
			System.out.println(brands.getName());
			System.out.println(brands.getPhoneBrand().getName());
		});
		HibernateUtil.shutdown();
	}
}
