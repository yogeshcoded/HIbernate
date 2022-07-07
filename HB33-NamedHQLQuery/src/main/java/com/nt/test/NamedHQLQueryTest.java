package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class NamedHQLQueryTest {

	public static void main(String[] args) {

		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
		Query query1 = sec.getNamedQuery("GET_PRODUCT_DETAILS");
			query1.setParameter("min", 700);
			query1.setParameter("max", 3500);
			List<Product> list = query1.list();
			list.forEach(prod -> {
				System.out.println(prod);
			});
			System.out.println("==============================================");
			// being transaction
			tx = sec.beginTransaction();
			Query query = sec.getNamedQuery("UPDATE_PRODUCT_DETAILS");
			query.setParameter("newValue", 1200);
			query.setParameter("range", 1000);
			int count = query.executeUpdate();
			System.out.println(count);
			System.out.println("update");
			tx.commit();
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("not update");
		} // catch

	}// main
}// class
