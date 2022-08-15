package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name="ANNO_PERSON_OTOFK")
public class Person  implements Serializable{
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private String padd;
	
	public Person() {
		System.out.println("Person:: 0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", padd=" + padd + "]";
	}
	
	
}
