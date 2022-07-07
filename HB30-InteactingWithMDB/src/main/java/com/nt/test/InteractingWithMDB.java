package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.nt.entity.Product;
import com.nt.utility.HBMySQLUtil;
import com.nt.utility.HBOracleUtil;

public class InteractingWithMDB {
	public static void main(String[] args) {

		SessionFactory oraclefactory=HBOracleUtil.getSessionFactory();
		SessionFactory mysqlfactory=HBMySQLUtil.getSessionFactory();
		Session oraclesec = HBOracleUtil.getSession();
		Session mysqlsec = HBMySQLUtil.getSession();
		Transaction mysqlTx = null;
		try (oraclefactory; mysqlfactory; oraclesec; mysqlsec) {

			// get object/record from oracle
			Product prod = oraclesec.get(Product.class,8014);
			
			// get save record to mysql
			mysqlTx = mysqlsec.beginTransaction();
			int idVal = (int) mysqlsec.save(prod);
			mysqlTx.commit();
			System.out.println("Record is transper to mysql DB");
		} // try
		catch (HibernateException he) {
			if (mysqlTx != null && mysqlTx.getRollbackOnly() && mysqlTx.getStatus() != null) {
				mysqlTx.rollback();
				System.out.println("PRoblem to transper the record");
				he.printStackTrace();
			}
		}
	}// main
}// class
