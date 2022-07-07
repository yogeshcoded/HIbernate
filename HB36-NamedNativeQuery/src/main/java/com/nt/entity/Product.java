package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.Data;
@Entity
@Data
@NamedNativeQuery(name="GET_PRODUCT_DETAILS",
                                           query ="SELECT *FROM PRODUCT WHERE QTY>=?",
                                           resultClass=Product.class)
@NamedNativeQuery(name="UPDATE_PRODUCT",
                                       query="UPDATE PRODUCT SET PRICE=PRICE+? WHERE PNAME=?")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String pname;
	private Integer price;
	private Integer qty;

}// class
