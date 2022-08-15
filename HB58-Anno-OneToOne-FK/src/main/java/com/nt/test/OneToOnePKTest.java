package com.nt.test;

import com.nt.dao.IOneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOImpl;

public class OneToOnePKTest {

	public static void main(String[] args) {
		IOneToOneFKDAO dao=new OneToOneFKDAOImpl();
		//dao.saveDataUsingChild();
			dao.loadDataUsingChild();
		
		      

	}

}
