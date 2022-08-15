package com.nt.test;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PersonDetails;
import com.nt.utility.HBUtil;

public class CompositionMappaingInserting {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx=null;
		try(sec;factory){
	
tx=sec.beginTransaction();
          PersonDetails details=new PersonDetails();
         details.setPname("Jani");
         details.setPaddrs("hyd");
         details.setNickNames(List.of("bujji","chinna","chitti"));
         details.setFriends(List.of("Ramesh","suresh","shreya"));
         details.setContactNo(Set.of(888888888L,999999999L,5555555555L));
         details.setIdDetails(Map.of("aadhar",452158744L,"voterid",84578554L,"pancard",451454555L));
         int idVal=(Integer)sec.save(details);
         System.out.println("object is saved by generated id :: "+idVal);
         tx.commit();
            System.out.println("Record is saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem is saving objects..");
		}//if
		}//catch
	}// main
}// class
