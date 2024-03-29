package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtil {
private static SessionFactory factory;

 static {
	 Configuration cfg=new Configuration();
	 cfg.configure("com/nt/cfg/hibernate.cfg.xml");
	 factory=cfg.buildSessionFactory();
 }
 
 public static SessionFactory getSessionFactory() {
	 return factory;
 }
 
 public static Session getSession() {
	 Session sec=null;
	 if(factory!=null) 
		 sec=factory.openSession();
		return sec;
 }
 
}
