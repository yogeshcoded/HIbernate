package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;



import lombok.AllArgsConstructor;
import lombok.Data;



 @Data
 @AllArgsConstructor
 @Entity
 @DynamicInsert(value = true)
 @Proxy(lazy = false)
public class Movie  {
	@Id //singular id
	private Integer mid;
	private String mname;
	private String hero;
	private Integer budget;
	
	public Movie() {
		System.out.println("o-param contructor");
	}
	
	
}//class
