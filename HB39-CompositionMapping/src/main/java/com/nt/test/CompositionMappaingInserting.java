package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HBUtil;

public class CompositionMappaingTesting {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
			tx = sec.beginTransaction();
			JobDetails dt = new JobDetails();
			dt.setDesg("DB Developer");
			dt.setCompany("TCS");
			dt.setSalary(250000);
			Person pr = new Person();
			pr.setPname("Jani");
			pr.setAddrs("Bangl");
			pr.setDetails(dt);

			int idVal = (Integer) sec.save(pr);
			System.out.println("Generated id for table is "+idVal);
			tx.commit();
			System.out.println("Data is save");
		} // try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getRollbackOnly() && tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Problem to insert the data");
			}
		}
	}// main
}// class
