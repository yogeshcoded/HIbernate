package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class NativeQueryTest {

	public static void main(String[] args) {

		// builds session factory object having info in xml file
		SessionFactory factory = HBUtil.getSessionFactory();
		// create session object
		Session sec = HBUtil.getSession();

		try (sec; factory) {
			/*		NativeQuery query=sec.createNativeQuery("SELECT * FROM PRODUCT");
					//map entity result to  entity obj
					query.addEntity(Product.class);
					//execute query
					List<Product>list=query.list();
				list.forEach(prod->{
					System.out.println(prod);
				});*/

			/*NativeQuery query=sec.createNativeQuery("SELECT * FROM PRODUCT");
			//map entity result to  entity obj
					//execute query
			List<Object[]>list=query.getResultList();
			list.forEach(result->{
				for(Object val:result)	{
					System.out.println(val);
				}//for
				System.out.println();
					});*/

			// scalar query for getting more cols
			/*NativeQuery query = sec.createNativeQuery("SELECT PID ,PNAME,PRICE,QTY FROM PRODUCT WHERE PRICE>=? AND PRICE<=?");
			// map scalar prod to hibernate data obj
			query.addScalar("PID", StandardBasicTypes.INTEGER);
			query.addScalar("PNAME", StandardBasicTypes.STRING);
			query.addScalar("PRICE",StandardBasicTypes.INTEGER);
			query.addScalar("QTY",StandardBasicTypes.INTEGER);
			
			// set query param
			query.setParameter(1, "1000");
			query.setParameter(2, "5000");
			// execute query
			List<Object[]> list = query.getResultList();
			list.forEach(result -> {
				for(Object val:result) {
					System.out.println(val);
				}
				System.out.println();
			});*/

			NativeQuery query = sec.createNativeQuery("SELECT * FROM PRODUCT WHERE PNAME in(:p1,:p2) ");

			// map scalar prod to hibernate data obj
			query.addEntity(Product.class);
			// set query param
			query.setParameter("p1", "temple");
			query.setParameter("p2", "cot");

			// execute query
			List<Product> list = query.getResultList();
			list.forEach(prod -> {
				System.out.println(prod);
			});
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch

	}// main
}// class
