package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.PersonDetails;
import com.nt.utility.HBUtil;

public class CompositionMappaingSelectTest {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		try (sec; factory) {
			Query query= sec.createQuery("from PersonDetails");
			//execute query 
			List<PersonDetails> pList=query.getResultList();
			pList.forEach(pd->{
				System.out.println("Person Details::  " +pd.getPid() +"        "+pd.getPname()+"      "+pd.getPaddrs());
	//nicknames
				List<String> nickNames=pd.getNickNames();
				System.out.println("Nicknames are:: " +nickNames.toString() );
			
	//friends name
				List<String> friends=pd.getFriends();
				System.out.println("Friends names are::   "+friends);
				
//contact no 
				Set<Long> contactNo=pd.getContactNo();
				System.out.println(contactNo);
				
//contact no 
				Map<String,Long>idDetails=pd.getIdDetails();
				System.out.println(idDetails);
			});
			
		
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch

	}// main
}// class
