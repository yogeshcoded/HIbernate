package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.util.HBUtil;

public class OneToOnePKDAOImpl implements IOneToOnePKDAO {

	@Override
	public void saveDataUsingParant() {
		// Session object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
			tx = sec.beginTransaction();
			// create parent object
			Student std = new Student();
			std.setSname("Vihan");
			std.setSadd("vizag");
			// create child object
			LibraryMembership lib = new LibraryMembership();
			lib.setType("Gold");
			lib.setDoj(LocalDate.now());
			// set parent to child
			std.setLibraryDetails(lib);
			lib.setStudentDetails(std);
			sec.save(std);
			tx.commit();
			System.out.println("Record is save");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
				System.out.println("Record not save");
			} // if
		} // catch

	}

	@Override
	public void saveDataUsingChild() {
		// Session object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
			tx = sec.beginTransaction();
			// create parent object
			Student std = new Student();
			std.setSname("Raja");
			std.setSadd("Hyd");
			// create child object
			LibraryMembership lib = new LibraryMembership();
			lib.setType("silver");
			lib.setDoj(LocalDate.now());
			// set parent to child
			std.setLibraryDetails(lib);
			lib.setStudentDetails(std);
			sec.save(lib);
			tx.commit();
			System.out.println("Record is save");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
				System.out.println("Record not save");
			} // if
		} // catch
	}// ()

	@Override
	public void loadDataUsingParent() {
		//get session object 
		Session sec=HBUtil.getSession();
		try(sec	){	
	//load the parent object
		Query query=sec.createQuery("from Student");
		List<Student> list =query.getResultList();
		list.forEach(stud->{
			System.out.println(stud);
			LibraryMembership lib=stud.getLibraryDetails();
			System.out.println(lib);
		});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//load()

	
}// class
