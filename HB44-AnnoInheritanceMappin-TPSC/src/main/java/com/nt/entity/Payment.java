package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ANNO_PAYAMENT_TPSC")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long txid;
	private Double amount;
	private LocalDateTime txdate;

	@Override
	public String toString() {
		return "Payment [txid=" + txid + ", amount=" + amount + ", txdate=" + txdate + "]";

	}

}
