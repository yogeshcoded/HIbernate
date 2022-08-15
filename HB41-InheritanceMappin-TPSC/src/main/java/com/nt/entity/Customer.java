package com.nt.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	private Integer billNo;
	private Integer billAmt;

	@Override
	public String toString() {
		return "Customer [billNo=" + billNo + ", billAmt=" + billAmt + ", Person=" + super.toString() + "]";
	}

}
