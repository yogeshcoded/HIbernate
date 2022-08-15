package com.nt.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Doctors;
import com.nt.entity.Patients;
import com.nt.util.HBUtil;

public class HospitalDAOImpl implements IHospitalDAO {

	@Override
	public void saveDataUsingParent() {
		// Session object
		Session sec = HBUtil.getSession();
		Transaction tx = null;
		try (sec) {
		
			// create parent project
			Doctors doct1 = new Doctors();
			doct1.setDoctorName("Rajesh");
			doct1.setHospital("OM");
			Doctors doct2 = new Doctors();
			doct2.setDoctorName("Milind");
			doct2.setHospital("Chinmay");
			// create child object
			Patients pat1 = new Patients();
			pat1.setPname("NIsha");
			pat1.setProblem("Cold");
			Patients pat2 = new Patients();
			pat2.setPname("NIsha");
			pat2.setProblem("Cold");
			Patients pat3 = new Patients();
			pat3.setPname("Chinna");
			pat3.setProblem("Flue");
			//assign child to parent 
			doct1.setPatients(Set.of(pat1,pat2));
			doct1.setPatients(Set.of(pat1,pat2,pat3));
			//assign parant to child
			pat1.setDoctors(Set.of(doct1,doct2));
			pat2.setDoctors(Set.of(doct1,doct2));
			pat3.setDoctors(Set.of(doct2));
			tx = sec.beginTransaction();
			//saving using parents
			sec.save(doct1);sec.save(doct2);
			tx.commit();
			System.out.println("Record is save");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null&&tx.getRollbackOnly()&&tx.getStatus()!=null) {
				tx.rollback();
				System.out.println("Record not save");
			}//if
		}//catch
		}

	}

