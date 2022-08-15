//Department.java
package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Integer deptNo;
	private String deptName;
	private String deptHead;
	private Set<Employee> employees;

	public Department() {
		System.out.println("Department::0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";

	}

}// class
