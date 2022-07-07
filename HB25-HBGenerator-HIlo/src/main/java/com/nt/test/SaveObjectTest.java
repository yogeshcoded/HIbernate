package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class SaveObjectTest {

	public static void main(String[] args) {

		// builds session factory object having info in xml file
		SessionFactory factory = HBUtil.getSessionFactory();
		// create session object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
			// being transaction
			tx = sec.beginTransaction();
			// prepare entity object
			Product pr = new Product();
			// set values
			// pr.setPid(102);
			pr.setPname("doorsg45");
			pr.setPrice(1800);
			pr.setQty(15);

			// save object
			Integer IdVal = (Integer) sec.save(pr);
			tx.commit();
			System.out.println("id is::" + IdVal);
			System.out.println("object is saved");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("object is not saved");
		} // catch

	}// main
}// class
