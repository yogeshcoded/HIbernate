package com.nt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ANNO_CARDPAYMENT_TPSC")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID")
public class CardPayment extends Payment {

	private Long cardNo;
	private String cardType;
	private String gateway;

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateway=" + gateway + ", "
				+ super.toString() + "]";
	}

}
