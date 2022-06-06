package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		//activate hibernate
		Configuration cfg=new Configuration();
		//create sesssoon 
		cfg.configure("com/nt/cfg/hibenate.cfg.xml");
Transaction tx=null;
try(
		SessionFactory factory=cfg.buildSessionFactory();
		//create session factory obj
		Session sec=factory.openSession();
			){
	//begin transaction
	tx=sec.beginTransaction();
	Student st=new Student();
	//set values
	st.setSid(1);
	st.setSname("jani");
	st.setMarks(35.20f);
	//save object
	sec.save(st);
	tx.commit();
	System.out.println("object  saved");
}//try
catch(HibernateException he) {
	he.printStackTrace();
	if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
		tx.rollback();
		System.out.println("object not saved");
	}//if
}//catch
	}//main
}//class
