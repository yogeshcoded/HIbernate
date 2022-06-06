package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class SavrOrUpdateMethodTest {

	public static void main(String[] args) {
	SessionFactory factory=HBUtil.getSessionFactory();
	Session sec=HBUtil.getSession();
	Transaction tx=null;
try(factory;sec){
	//begin transaction
	tx=sec.beginTransaction();
	//create entity obj
	Product p=new Product();
	//set values to update
	p.setPid(55);
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
