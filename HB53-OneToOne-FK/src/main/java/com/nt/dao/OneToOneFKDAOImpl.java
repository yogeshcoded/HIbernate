package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.util.HBUtil;

public class OneToOneFKDAOImpl implements IOneToOneFKDAO {

	

	@Override
	public void saveDataUsingChild() {
		// Session object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
			tx = sec.beginTransaction();
			// create parent object
			Person per = new Person();
			per.setPname("Raja");
			per.setPadd("Hyd");
			// create child object
			Passport port = new Passport();
			port.setCountry("India");
			port.setExpiryDate(LocalDate.now());
			// set parent to child
		port.setPersonDetails(per);
		sec.save(port);
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
	public void loadDataUsingChild() {
		//get session object 
		Session sec=HBUtil.getSession();
		try(sec	){	
	//load the parent object
		Query query=sec.createQuery("from Passport");
		List<Passport> list =query.getResultList();
		list.forEach(pspt->{
			System.out.println(pspt);
			/*Person per=pspt.getPersonDetails();
			System.out.println(per);*/
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
