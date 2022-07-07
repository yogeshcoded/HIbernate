package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBMySQLUtil {
	private static SessionFactory factory;
static {
	Configuration cfg=new Configuration();
	cfg.configure("com/nt/cfgs/hibernate-mysql.cfg.xml");
	 factory=cfg.buildSessionFactory();
	}//static
public static SessionFactory getSessionFactory() {
	return factory;
}

public static Session getSession() {
	Session sec=null;
	if (factory!=null) 
		sec=factory.openSession();
		return sec;
}	
}//class
