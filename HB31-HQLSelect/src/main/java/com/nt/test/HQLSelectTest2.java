package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class HQLSelectTest2 {

	public static void main(String[] args) {

		// builds session factory object having info in xml file
		SessionFactory factory = HBUtil.getSessionFactory();
		// create session object
		Session sec = HBUtil.getSession();

		try (sec; factory) {
			Query query = sec.createQuery("from Product");
			List<Product> list = query.list();
			list.forEach(prod -> {
				System.out.println(prod);
			});
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();

		} // catch

	}// main
}// class
