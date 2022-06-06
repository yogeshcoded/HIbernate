package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HBUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		SessionFactory factory = HBUtil.getSessionFactory();
		Session sec = HBUtil.getSession();
		try (sec; factory) {
			PrgmrProjId id = new PrgmrProjId(101, 1001);
			ProgrammerProjectInfo info = sec.get(ProgrammerProjectInfo.class, id);
				System.out.println();
			System.out.println(info);
			if (info == null) 
				System.out.println("object is found");
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		}//catch
	}//main
}//class
