package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HBUtil;

public class HQLSelectTest3 {

	public static void main(String[] args) {

		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
			tx = sec.beginTransaction();
			Query query = sec.createQuery("update Product set price=price-:discount where price>=:value1 and price<=:value2");
			query.setParameter("discount", 500);
			query.setParameter("value1", 1200);
			query.setParameter("value2", 3000);
			int count = query.executeUpdate();
			System.out.println(count);
			System.out.println("update");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("not update");
		} // catch

	}// main
}// class
