package com.nt.test;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class HQLSelectTest1 {

	public static void main(String[] args) {

		// builds session factory object having info in xml file
		SessionFactory factory = HBUtil.getSessionFactory();
		// create session object
		Session sec = HBUtil.getSession();

		try  {
			Query query = sec.createQuery("from Product");
			Iterator it = query.iterate();
		     while(it.hasNext()) {
		    	 Product prod=(Product) it.next();
		    	System.out.println(prod);
		     }
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();

		} // catch

	}// main
}// class
