package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HBUtil;

public class SaveObjectTestMultiThreadedTest {

	public static void main(String[] args) {

		TicketBokkingOperation opt = new TicketBokkingOperation();
		Thread th1 = new Thread(opt);
		th1.start();

		Thread th2 = new Thread(opt);
		th2.start();

		Thread th3 = new Thread(opt);
		th3.start();

	}// main
}// class
