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
		
		Scanner sc = new Scanner(System.in);
		// bootstrap//activate hibernate
		Configuration cfg = new Configuration();
		// specify the name && location of cgf file
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		Transaction tx = null;
		try (

		// builds session factory object having info in xml file
		SessionFactory factory = cfg.buildSessionFactory();
		// create session object
		Session sec = factory.openSession();){
		
		
		
			// being transaction
			tx = sec.beginTransaction();
			// prepare entity object
			Product pr = new Product();
						
			//calculate bill
			
			// set values
			//pr.setPid(1523);
			pr.setPname("palang");
			pr.setPrice(1500);
			pr.setQty(5);
		   // pr.setBill(bill);

			// save object
		sec.persist(pr);
			tx.commit();
			
			System.out.println("object is saved");
	

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
			tx.rollback();
			System.out.println("object is not saved");
			}//if
		} // catch
			

	}// main
}// class
