package com.nt.test;

import org.hibernate.Transaction;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {

	public static void main(String[] args) {

		// bootstrap//activate hibernate
		Configuration cfg = new Configuration();
		// specify the name && location of cgf file
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		// builds session factory object having info in xml file
		SessionFactory factory = cfg.buildSessionFactory();
		// create session object
		Session sec = factory.openSession();
		Transaction tx = null;
		try {
			for(int i=1;i<=20;i++) {
			// being transaction
			tx = sec.beginTransaction();
			// prepare entity object
			Product pr = new Product();

			// set values
			// pr.setPid(1523);
			pr.setPname("temple");
			pr.setPrice(1500);
		 pr.setQty(5);

			// save object
			Integer IdVal = (Integer) sec.save(pr);
			tx.commit();
			System.out.println("id is::" + IdVal);
			System.out.println("object is saved");
			}//if
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("object is not saved");
		} // catch
			// close session obj
		sec.close();
		// close sessionfacotey obj
		factory.close();

	}// main
}// class
