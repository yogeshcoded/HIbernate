package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class CriteraAPITest {

	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
			// create criateria builder object
			CriteriaBuilder ctBuilder = sec.getCriteriaBuilder();
			//create criteria object
			CriteriaQuery<Product> ctQuery=ctBuilder.createQuery(Product.class);
			// create Root object specifying from the operration
			Root<Product>root=ctQuery.from(Product.class);
			//create query objt having ctriteria object
			Query query=sec.createQuery(ctQuery);
			//execute query 
			List<Product>list=query.getResultList();
			//process the result
			list.forEach(System.out::println);

		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
