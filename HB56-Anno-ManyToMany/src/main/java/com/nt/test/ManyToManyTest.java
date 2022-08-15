package com.nt.test;

import com.nt.dao.HospitalDAOImpl;
import com.nt.dao.IHospitalDAO;

public class ManyToManyTest {
public static void main(String[] args) {
	
	 IHospitalDAO dao=new HospitalDAOImpl();
	 dao.saveDataUsingParent();
}
}
