package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nt.entity.Movie;
import com.nt.utility.HBUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
	SessionFactory factory=HBUtil.getSessionFactory();
	Session sec=HBUtil.getSession();
	Transaction tx=null;
	try(sec;factory){
		//being Transaction
	tx=sec.beginTransaction();
	//prepare object
	Movie movie=new Movie();
	//movie.setMid(101);
	movie.setMname("Anek");
	movie.setHero("Raja");
	movie.setBudget(150245);
	//save object 
	
	int idVal=(Integer)sec.save(movie);
	System.out.println("object id ::"+idVal);
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
