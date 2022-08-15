package com.nt.entity;

import lombok.Data;

@Data

public class Employee extends Person {
	private String desg;
	private Integer salary;
	private Integer deptNo;

@Override
public String toString() {
	return "Employee [desg=" + desg + ", salary=" + salary + ", deptNo=" + deptNo + ", Person:: " + super.toString()+"]";
			
}//tostring(-,-)

}//class
