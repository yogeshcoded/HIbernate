package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name="GET_PRODUCT_DETAILS",
                             query="from Product where price>=:min and price<=:max")
@NamedQuery(name="UPDATE_PRODUCT_DETAILS",
                             query=" update Product set price=price+:newValue where price<=:range")
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Integer  price;
	private  Integer qty;
	
	
}//class
