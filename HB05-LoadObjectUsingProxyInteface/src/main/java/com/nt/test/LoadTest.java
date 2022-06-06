package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.IProduct;
import com.nt.entity.Product;

public class LoadTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session sec=factory.openSession();
		
		try(factory;sec){
			IProduct prod=sec.load(Product.class,1);
         			System.out.println(prod.getClass()+" "+prod.getClass().getSuperclass());
         			System.out.println("---------------------------------------");
         		//	System.out.println(prod);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			System.out.println("record not found");
		}//catch
		}//main
}//class
