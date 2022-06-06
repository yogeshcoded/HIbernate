package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HBUtil;

public class SaveObjTest {

	public static void main(String[] args) {
		SessionFactory factory=HBUtil.getSessionFactory();
		Session sec=HBUtil.getSession();
		Transaction tx=null;
		try(sec;factory){
			tx=sec.beginTransaction();
			PrgmrProjId id=new PrgmrProjId(102,1002);
			ProgrammerProjectInfo pinfo=new ProgrammerProjectInfo(id,"manish","openX",85000,200000000);
			PrgmrProjId idVal=(PrgmrProjId) sec.save(pinfo);
			tx.commit();
			System.out.println("object is save");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if (tx!=null&&tx.getRollbackOnly()&&tx.getClass()!=null) {
				tx.rollback();
				System.out.println("object is not saved");
			}
		}
		}//main
}//class
