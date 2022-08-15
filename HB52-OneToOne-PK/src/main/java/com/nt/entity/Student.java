package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Student  implements Serializable{
	private Integer sno;
	private String sname;
	private String sadd;
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("Student.Student:: 0-param constructor  "+this.getClass());
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddrs=" + sadd + "]";
	}
	
}
