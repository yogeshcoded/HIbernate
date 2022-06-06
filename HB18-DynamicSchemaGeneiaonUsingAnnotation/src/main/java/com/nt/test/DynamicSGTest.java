package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class DynamicSGTest {

	public static void main(String[] args) {
		SessionFactory factory=HBUtil.getSessionFactory();
		Session sec=HBUtil.getSession();
		
		Transaction tx=null;
		try {
			tx=sec.beginTransaction();
			Product p=new Product();
			//set values
		    p.setPid(3);
		p.setPname("raja5ha");
			p.setPrice(15245);
			p.setQty(10);
			
			Thread.sleep(30000);
		Integer idVal=(Integer) sec.save(p);
		System.err.println(idVal);
			//commit
			tx.commit();
			System.out.println("object is saved");
			Thread.sleep(30000);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("object is not saved");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		sec.close();
		factory.close();

	}

}
