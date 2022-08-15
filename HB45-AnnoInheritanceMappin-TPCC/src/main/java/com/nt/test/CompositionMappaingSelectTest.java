package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;

import com.nt.utility.HBUtil;

public class CompositionMappaingSelectTest {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		try (sec; factory) {
			Query query2 = sec.createQuery("from ChequePayment");
			// execute query
			List<ChequePayment> list1 = query2.getResultList();
			list1.forEach(card -> System.out.println(card));

			Query query1 = sec.createQuery("from CardPayment");
			// execute query
			List<CardPayment> list2 = query1.getResultList();
			list2.forEach(card -> System.out.println(card));
			System.out.println();

			Query query = sec.createQuery("from Payment");
			// execute query
			List<Payment> list3 = query.getResultList();
			list3.forEach(pay -> System.out.println(pay));
			System.out.println();

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch

	}// main
}// class
