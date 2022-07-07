package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Person implements Serializable{
	@Id
	@GeneratedValue(generator = "increment")
	private Integer pid;
	private String pname;
	private String addrs;
     private JobDetails details;

}
