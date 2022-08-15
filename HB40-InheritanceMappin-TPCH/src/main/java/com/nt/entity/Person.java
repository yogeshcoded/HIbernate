package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data

public class Person {
	@Id
	@GeneratedValue(generator = "increment")
	private Integer pid;
	private String pname;
	private String company;
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", company=" + company + "]";
	}
	
	

}
