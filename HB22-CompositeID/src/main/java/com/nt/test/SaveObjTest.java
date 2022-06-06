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
			PrgmrProjId id=new PrgmrProjId(101,1001);
			ProgrammerProjectInfo pinfo=new ProgrammerProjectInfo(id,"suresh","HMS",90000,120000);
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
