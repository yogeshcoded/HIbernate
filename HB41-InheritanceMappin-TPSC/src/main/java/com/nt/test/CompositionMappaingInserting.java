package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HBUtil;

public class CompositionMappaingInserting {
	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		Transaction tx=null;
		try(sec;factory){
			Person per=new Person();
			per.setPname("Raja");
			per.setCompany("HCL");
			
			Employee emp=new Employee();
			emp.setPname("Ramesh");
			emp.setCompany("TCS");
			emp.setDesg("Develpoer");
            emp.setSalary(25000);
            emp.setDeptNo(10);
            
            Customer cust=new Customer();
            cust.setPname("Ganesh");
            cust.setCompany("CTS");
            cust.setBillNo(1215);
            cust.setBillAmt(100000);
            
            tx=sec.beginTransaction();
            //save obejct 
            sec.save(per);
            sec.save(emp);
            sec.save(cust);
            tx.commit();
            System.out.println("Record is saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem is saving objects..");
		}//if
		}//catch
	}// main
}// class
