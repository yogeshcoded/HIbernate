package com.nt.dao;

public interface IPersonDetailsDAO {
	public void saveDataUsingParant();
	public void LoadDataUsingParant();
	public void addChildToExsitingParent();
	
	public void deleteAllChildFromParent();
	public void deleteParentAndChild();

}
