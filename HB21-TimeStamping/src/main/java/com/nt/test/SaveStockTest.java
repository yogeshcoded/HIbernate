package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.utility.HBUtil;

public class SaveStockTest {

	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
			tx = sec.beginTransaction();
			Stock stock = new Stock("TATAMOTOR", 495, "NSL");
			Integer idVal = (Integer) sec.save(stock);
			System.out.println("Objecet generated id val is " + idVal);
			System.out.println("Objecet last saved  " + stock.getLastUpdate());
			tx.commit();
			System.out.println("object is save");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
				tx.rollback();
				System.out.println("object is not saved");
			}//if
		}//catch

	}//main

}//class
