package com.nt.test;

import com.nt.dao.CompanyDAOImpl;
import com.nt.dao.ICompanyDAO;

public class OneToManyTest {
public static void main(String[] args) {
	ICompanyDAO dao=new CompanyDAOImpl();
	
	//dao.saveDataUsingParent();
	//dao.saveDataUsingChild();
	
	//------------------------------------------
	
	dao.loadDataUsingParent();
	  //dao.loadDataUsingChild();
}
}
