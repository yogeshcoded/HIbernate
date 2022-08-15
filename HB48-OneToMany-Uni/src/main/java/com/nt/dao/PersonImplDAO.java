package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PersonDetails;
import com.nt.entity.PhoneNumber;
import com.nt.util.HBUtil;

public class PersonImplDAO implements IPersonDetailsDAO {

	@Override
	public void saveDataUsingParant() {

		// get session factory object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
			tx = sec.beginTransaction();
			// parent object
			PersonDetails pDetails = new PersonDetails();
			pDetails.setPname("Raja");
			pDetails.setPaddrs("Hyd");

			// prepare child object
			PhoneNumber ph1 = new PhoneNumber();
			ph1.setMobileNo(9884984564L);
			ph1.setNumberType("home");
			ph1.setProvider("airtel");

			PhoneNumber ph2 = new PhoneNumber();
			ph2.setMobileNo(9421568547L);
			ph2.setNumberType("office");
			ph2.setProvider("jio");

			// set child object to parent object
			pDetails.setPhones(Set.of(ph1, ph2));

			int idVal = (Integer) sec.save(pDetails);
			tx.commit();
			System.out.println("object is save");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
				System.out.println("Problem to record insertion ");
			}
		}
	}// ()

	@Override
	public void LoadDataUsingParant() {
		Session sec = HBUtil.getSession();
		try (sec) {
			Query query = sec.createQuery("from PersonDetails");
			List<PersonDetails> list = query.getResultList();
			list.forEach(pd -> {
				System.out.println(pd);

				System.out.println();
			});
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}
	}

	@Override
	public void addChildToExsitingParent() {
		// get session factory object
				Session sec = HBUtil.getSession();
				Transaction tx = null;
				try (sec) {
					tx = sec.beginTransaction();
					//load the records
					PersonDetails pDetails=sec.load(PersonDetails.class, 1);
					//get all child to parent 
					Set<PhoneNumber> child = pDetails.getPhones();
					// prepare child object
					PhoneNumber ph1 = new PhoneNumber();
					ph1.setMobileNo(99999999L);
					ph1.setNumberType("Personal");
					ph1.setProvider("BSNL");
					child.add(ph1);
					tx.commit();
					System.out.println("object is save");

				} catch (HibernateException he) {
					he.printStackTrace();
					if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
						tx.rollback();
						System.out.println("Problem to record insertion ");
					}
				}
	}//method()
	
	@Override
	public void deleteAllChildFromParent(){
		// get session factory object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
			tx = sec.beginTransaction();
			//load the records
			PersonDetails pDetails=sec.load(PersonDetails.class, 1);
			//get all child to parent 
			Set<PhoneNumber> child = pDetails.getPhones();
			// prepare child object
			PhoneNumber ph1 = new PhoneNumber();
			child.removeAll(child);
			tx.commit();
					System.out.println("recoeds is delete");
		} 
		catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
				System.out.println("Problem to record delete ");
			}
	}
	}
	@Override
	public void deleteParentAndChild() {
		// get session factory object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
			tx = sec.beginTransaction();
			// load the records
			PersonDetails pDetails = sec.load(PersonDetails.class, 2);
			sec.delete(pDetails);
			tx.commit();
			System.out.println("recoeds is delete");
		} catch (HibernateException he) {
			he.printStackTrace();
			if (tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
				System.out.println("Problem to record delete ");
			}
			}
			
	}
}// class

