package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HBUtil;

public class CompositionMappaingSelecting {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();

		try (sec; factory) {
			/*	// create query object
				Query query = sec.createQuery("from Person");
				// execute query
				List<Person> pList = query.getResultList();
				pList.forEach(per -> System.out.println(per));*/
			System.out.println("====================================================================");
			// create query object
			Query query = sec.createQuery("from Person where details.salary=?1");
			// set parameters
			query.setParameter(1, 25000);
			// execute query
			List<Person> pList = query.getResultList();
			pList.forEach(per -> System.out.println(per));
				/*System.out.println("Person Details::");
				System.out.println(per.getPid() + "             " + per.getPname() + "             " + per.getAddrs());
				JobDetails details = per.getDetails();
				System.out.println("Details Details::");
				System.out.println(
						details.getDesg() + "         " + details.getCompany() + "           " + details.getSalary());
				*/
		

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch

	}// main
}// class
