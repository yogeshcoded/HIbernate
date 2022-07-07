package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Product {
@Id
@GeneratedValue
	private Integer pid;
	private String pname;
	private Integer price;
	private Integer qty;

}// class
