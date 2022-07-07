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

public class JPAQBCTest {

	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec; factory) {
			// create queryBulilder obj
			CriteriaBuilder ctBuilder = sec.getCriteriaBuilder();
			// create criteria query obj
			CriteriaQuery<String> ctQuery = ctBuilder.createQuery(String.class);
			// create root onject specifing the form operation
			Root<Product> root = ctQuery.from(Product.class);
			// specify specific multiple column and where clause condition
			/*ctQuery.multiselect(root.get("pid"), root.get("pname"))
					.where(ctBuilder.and(ctBuilder.ge(root.get("price"), 500), ctBuilder.le(root.get("price"), 5000)));*/
			//select name where its start from s%
			//ctQuery.multiselect(root.get("pname")).where(ctBuilder.like(root.get("pname"), "m%"));
			//Aggricate Function
			ctQuery.multiselect(ctBuilder.count(root.get("pid")));
			// create query object having Criteria Query
			Query query = sec.createQuery(ctQuery);
			// execute the QBC Query
			Object result[]=(Object[]) query.getSingleResult();
			// process the result
			System.out.println(result[0]);

		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}// main
}// class
