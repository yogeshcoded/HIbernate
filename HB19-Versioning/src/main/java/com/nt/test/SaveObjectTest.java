package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HBUtil;

public class SaveObjectTest {

			public static void main(String[] args) {
				SessionFactory factory=HBUtil.getSessionFactory();
				Session sec=HBUtil.getSession();
				
				Transaction tx=null;
				try (sec;factory){
					tx=sec.beginTransaction();
					CallerTune ct=new CallerTune();
					//set values
					ct.setTuneName("srivalli");
					ct.setMovieName("pusha");
					//save object
					 sec.save(ct);
					 //commit
					tx.commit();
					System.out.println("object is saved");
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
					tx.rollback();
					System.out.println("object is not saved");
				}//if
				}//catch
			}//main
}//class
				

			

