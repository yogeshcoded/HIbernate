package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Person;
import com.nt.utility.HBUtil;

public class CompositionMappaingSelectTest {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		try (sec; factory) {
		Query query= sec.createQuery("from Person");
		//execute query 
		List<Person> pList=query.getResultList();
		pList.forEach(per->System.out.println(per));
		System.out.println();
		
		Query query1= sec.createQuery("from Employee");
		//execute query 
		List<Person> pList1=query1.getResultList();
		pList.forEach(emp->System.out.println(emp));
		System.out.println();
		
		Query query2= sec.createQuery("from Customer");
		//execute query 
		List<Person> pList2=query2.getResultList();
		pList.forEach(cust->System.out.println(cust));

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch

	}// main
}// class
