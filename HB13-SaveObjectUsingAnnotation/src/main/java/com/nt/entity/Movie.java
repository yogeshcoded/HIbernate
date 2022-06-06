package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String hero;
	private Integer budget;
	
}//class
