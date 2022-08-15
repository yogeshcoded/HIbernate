package com.nt.test;

import com.nt.dao.IPersonDetailsDAO;
import com.nt.dao.PersonImplDAO;

public class OneToManyTest {
	public static void main(String[] args) {
		IPersonDetailsDAO dao = new PersonImplDAO();
	//dao.saveDataUsingParant();
		//dao.addChildToExsitingParent();
		dao.LoadDataUsingParant();
	//dao.deleteAllChildFromParent();
		//dao.deleteParentAndChild();
	}

}
