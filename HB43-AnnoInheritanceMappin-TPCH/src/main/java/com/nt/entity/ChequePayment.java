package com.nt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("cheque")
public class ChequePayment extends Payment {
	private Long chequeNo;
	private String chequeType;

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ",  " + super.toString() + "]";
	}

}
