package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nt.entity.Movie;
import com.nt.utility.HBUtil;

public class EnableEgarLoadingAnnotationTest {

	public static void main(String[] args) {
	SessionFactory factory=HBUtil.getSessionFactory();
	Session sec=HBUtil.getSession();
	Transaction tx=null;
	try(sec;factory){
				//prepare object
	Movie m=sec.load(Movie.class, 101);
		//System.out.println(m);
	
	}//try
	catch(HibernateException he) {
		he.printStackTrace();
				System.out.println("object is not saved");
	}
	
	}//main
}//class
