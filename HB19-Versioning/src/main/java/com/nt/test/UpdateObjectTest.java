package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CallerTune;
import com.nt.utility.HBUtil;

public class UpdateObjectTest {
	public static void main(String[] args) {
		SessionFactory factory=HBUtil.getSessionFactory();
		Session sec=HBUtil.getSession();
		
		Transaction tx=null;
		try (sec;factory){
			
			CallerTune tune=sec.get(CallerTune.class,1);
			if (tune==null) {
				System.out.println("record not found");
				return;
			}
			else {
				tx=sec.beginTransaction();
			//update object
				tune.setTuneName("sami sami");
				sec.update(tune);
			 //commit
			tx.commit();
			System.out.println("Object  updated for "+tune.getUpdationCount()+"..times");
			}//else
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
			tx.rollback();
			System.out.println("object is not update");
		}//if
		}//catch
	}//main
}//class
