package com.nt.entity;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ANNO_EMPLYOEE_OTM")
public class Employee {
	@Id
	@SequenceGenerator(initialValue = 501,allocationSize = 1,sequenceName = "EMPOTM_SEQ", name = "emp1")
	@GeneratedValue(generator = "emp1",strategy = GenerationType.SEQUENCE)
	private Integer empNo;
	private String empName;
	private Integer empSalary;
	
	@ManyToOne(targetEntity =Department.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="DEPARTMENT_ID",referencedColumnName = "DEPTNO")
	@LazyToOne(LazyToOneOption.FALSE)
	private Department dept;
public Employee() {
	System.out.println("Employee::0-param constructor"+this.getClass());
}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}// class
