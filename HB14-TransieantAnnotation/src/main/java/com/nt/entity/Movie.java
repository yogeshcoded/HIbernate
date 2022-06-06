package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
public class Movie {
	@Id //singular id
	private Integer mid;
	private String mname;
	@Transient
	private String hero;
	@Transient
	private Integer budget;
	
}//class
