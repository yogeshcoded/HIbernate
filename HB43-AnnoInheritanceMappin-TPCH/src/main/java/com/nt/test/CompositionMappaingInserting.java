package com.nt.test;


import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;

import com.nt.utility.HBUtil;

public class CompositionMappaingInserting {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx=null;
		try(sec;factory){
			ChequePayment cheque=new ChequePayment();
			cheque.setChequeNo(1245L);
			cheque.setChequeType("SELF");
			cheque.setTxdate(LocalDateTime.of(2022,07,21, 13, 31));
			cheque.setAmount(2501468.0);
			
			
		CardPayment card=new CardPayment();
		card.setAmount(25000.0);
		card.setTxdate(LocalDateTime.of(2022,07,21, 13, 31));
		card.setCardNo(45210215455L);
		card.setCardType("CREDIT");
		card.setGateway("Rupay");
		
		
            tx=sec.beginTransaction();
            //save obejct 
            sec.save(card);
            sec.save(cheque);
           
            tx.commit();
            System.out.println("Object is saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem to  saving the  objects..");
		}//if
		}//catch
	}// main
}// class
