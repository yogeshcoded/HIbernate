package com.nt.test;

import com.nt.dao.IOneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;

public class OneToOnePKTest {

	public static void main(String[] args) {
		IOneToOnePKDAO dao=new OneToOnePKDAOImpl();
			//dao.saveDataUsingParant();
			//dao.saveDataUsingChild();
		
		         dao.loadDataUsingParent();

	}

}
