//Department.java
package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ANNO_DEPARTMENT_OTM")
public class Department {
	@Id
	@GeneratedValue()
	private Integer deptNo;
	private String deptName;
	private String deptHead;
	
	@OneToMany(targetEntity =Employee.class,cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,mappedBy = "dept",orphanRemoval = true)
	private Set<Employee> employees;

	public Department() {
		System.out.println("Department::0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";

	}

}// class
