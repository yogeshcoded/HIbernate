package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SavrOrUpdateMethodTest {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("com/nt/cfg/hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session sec=factory.openSession();
	Transaction tx=null;
try(factory;sec){
	//begin transaction
	tx=sec.beginTransaction();
	//create entity obj
	Product p=new Product();
	//set values to update
	p.setPid(5);
	p.setPname("mouse");
	p.setPrice(25000);
	p.setQty(50);
	//use update method
	sec.saveOrUpdate(p);
	//commit transaction
	tx.commit();
	System.out.println("product save or update");
}//try
	catch(HibernateException he) {
		if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
			System.out.println("product not save or updated");
			tx.rollback();
		}//if
		System.out.println("product not save or updated");
	
	}//catch
	
	
	
	}//main
}//class
