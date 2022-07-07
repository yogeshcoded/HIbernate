/*package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class NativeQueryTest {

	public static void main(String[] args) {

		// builds session factory object having info in xml file
		SessionFactory factory = HBUtil.getSessionFactory();
		// create session object
		Session sec = HBUtil.getSession();
        Transaction tx=null;
		try (sec; factory) {
			NativeQuery query=sec.createNativeQuery("GET_PRODUCT_DETAILS");
			//map query to hibernate db obj
			query.addEntity(Product.class);
			//set parameter
			query.setParameter(1, 10);
			//execute query
			List<Product>list=query.getResultList();
			list.forEach(prod->{
				System.out.println(prod);
			});
			
			System.out.println("===============================================================================");
			
			tx=sec.beginTransaction();
			NativeQuery query1=sec.createNativeQuery("UPDATE_PRODUCT");
			//set param 
			query1.setParameter(1, 500);
			query1.setParameter(2, "cot");
			//execute query
			int count=query1.executeUpdate();
			System.out.println(count);
			//Commit
			tx.commit();
			System.err.println("Product data is update");
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx!=null&&tx.getRollbackOnly()&&tx.getStatus()!=null) {
				System.out.println("Problem in data update ");
				tx.rollback();
			}
		} // catch

	}// main
}// class
*/