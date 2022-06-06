package com.nt.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session sec=factory.openSession();
		
		try(factory;sec){
			Product prod=sec.load(Product.class,1);
			System.out.println(prod.getPname());
			System.out.println("---------------------------------------");
           System.out.println(prod.getPrice());
			System.out.println(prod.getClass()+" "+prod.getClass().getSuperclass());
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		}//main
}//class
