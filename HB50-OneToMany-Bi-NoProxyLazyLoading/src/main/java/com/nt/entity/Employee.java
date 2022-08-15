package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
	private Integer empNo;
	private String empName;
	private Integer empSalary;
	private IDepartment dept;

	public Employee() {
		System.out.println("Employee::0-param constructor"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}// class
