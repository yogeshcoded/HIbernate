package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class HQLSelectTest3 {

	public static void main(String[] args) {

		// builds session factory object having info in xml file
		SessionFactory factory = HBUtil.getSessionFactory();
		// create session object
		Session sec = HBUtil.getSession();

		try (sec; factory) {
			/*Query query = sec.createQuery("from Product where pid>=?11 and pid<=?10");                       //ordinal parameter
			query.setParameter(11, 8014)			;
			query.setParameter(10, 8050);
			List<Product> list = query.list();
			list.forEach(prod -> {
				System.out.println(prod);
			});*/
			/*	Query query = sec.createQuery("from Product where pid>=:p1 and pid<=:p2");           //named parameter
				query.setParameter("p1", 8014);
				query.setParameter("p2", 8050);
			
				List<Product> list = query.list();
				list.forEach(prod -> {
					System.out.println(prod);
				});*/
			
			Query query = sec.createQuery("from Product where price=(select max(price) from Product)");          
					List<Product> list = query.getResultList();
			list.forEach(prod -> {
				System.out.println(prod);
			});
			
			/*Query query = sec.createQuery("from Product where pname in(:prod1,:prod2,:prod3)order by pname asc");
			query.setParameter("prod1", "temple");
			query.setParameter("prod2", "keyboard");
			query.setParameter("prod3", "mouse");
			List<Product> list = query.list();
			list.forEach(prod -> {
				System.out.println(prod);
			});*/
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();

		} // catch

	}// main
}// class
