package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class ReloadTest {

	public static void main(String[] args) throws InterruptedException {
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
		System.out.println(p);
		System.out.println("object is sleep state");
		Thread.sleep(30000);
		sec.refresh(p);
		System.out.println(p);
	}//else
}//try
	catch(HibernateException he) {
		he.printStackTrace();
		}//catch
	}//main
}//main

