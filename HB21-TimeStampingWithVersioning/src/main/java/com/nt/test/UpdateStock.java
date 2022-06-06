package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Stock;
import com.nt.utility.HBUtil;

public class UpdateStock {
public static void main(String[] args) {
	SessionFactory factory = HBUtil.getSessionFactory();
	Session sec = HBUtil.getSession();
	Transaction tx = null;
	try (sec; factory) {
		Stock stock=sec.get(Stock.class,5);
		if (stock==null) {
			System.out.println("stock not found");
		}
		else{
		tx=sec.beginTransaction();
		stock.setPrice(700);
		sec.update(stock);
		System.out.println("stock is update");
		
		System.out.println("stock is  update for  "+stock.getUpdationCount()+ "  times");
		System.out.println("stock is last update  "+stock.getLastUpdateTime());
			tx.commit();
		}//else
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
				tx.rollback();
				System.out.println("object is not saved");
			}//if
		}//catch
}//main
}//class
