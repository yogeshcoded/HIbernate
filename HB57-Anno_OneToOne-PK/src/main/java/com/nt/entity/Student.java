package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name="ANNO_STUDENT_OTOPK")
public class Student  implements Serializable{
	@Id
	@GeneratedValue
	private Integer sno;
	private String sname;
	private String sadd;
	@OneToOne(targetEntity = LibraryMembership.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name ="lid",referencedColumnName = "sno")
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("Student.Student:: 0-param constructor  "+this.getClass());
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddrs=" + sadd + "]";
	}
	
}
