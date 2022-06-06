package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nt.entity.Movie;
import com.nt.utility.HBUtil;

public class SaveObjectUsingAnnotationTest {

	public static void main(String[] args) {
	SessionFactory factory=HBUtil.getSessionFactory();
	Session sec=HBUtil.getSession();
	Transaction tx=null;
	try(sec;factory){
		//being Transaction
	tx=sec.beginTransaction();
	//prepare object
	Movie m=new Movie(103,"WAR","Vijay",400);
	//save object 
	sec.save(m);
	//commit
	tx.commit();
	System.out.println("object is saved");
	
	}//try
	catch(HibernateException he) {
		he.printStackTrace();
		if (tx!=null && tx.getRollbackOnly()&&tx.getClass()!=null) 
			tx.rollback();
		System.out.println("object is not saved");
	}
	
	}//main
}//class
