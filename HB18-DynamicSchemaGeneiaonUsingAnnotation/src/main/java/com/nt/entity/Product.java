package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product {
	@Id
private Integer pid;
	@Column(name = "PNAME",length=15)
private String pname;
private Integer price;
private Integer qty;



}
