package com.nt.test;

import com.nt.dao.CompantDAOImpl;
import com.nt.dao.ICompantDAO;

public class OneToManyTest {
public static void main(String[] args) {
	ICompantDAO dao=new CompantDAOImpl();
	
	//dao.saveDataUsingParent();
	//dao.saveDataUsingChild();
	
	//------------------------------------------
	
	//dao.loadDataUsingParent();
	  dao.loadDataUsingChild();
}
}
