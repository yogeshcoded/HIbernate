package com.nt.entity;

import lombok.Data;

@Data
public  class Product implements IProduct {
private Integer pid;
private String pname;
private Integer price;
private Integer qty;
}//class
