package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class DeleteObjectTest {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("com/nt/cfg/hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session sec=factory.openSession();
	Transaction tx=null;
try(factory;sec){
	//load object
	Product p=sec.get(Product.class,1);
	if (p==null) {
		System.out.println("record not found");
		return;
	}
	else {
		//begin transaction
	tx=sec.beginTransaction();
		sec.delete(p);
	//commit transaction
	tx.commit();
	System.out.println("product delete");
	}//else
}//try
	catch(HibernateException he) {
		if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
			System.out.println("product not delete");
			tx.rollback();
		}//if
		System.out.println("product not updated");
	
	}//catch
	
	
	
	}//main
}//class
