package com.nt.dao;

public interface ICompantDAO {
  public void saveDataUsingParent();
  public void saveDataUsingChild();
  
  public void loadDataUsingParent();
  public void loadDataUsingChild();
  public void loadDataUsingChildWithProxy();
}
