package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="ANNO_PERSON_OTM")
public class PhoneNumber implements Serializable {
	@Id
	@SequenceGenerator(name = "perg1",sequenceName = "PHON_SEQ",initialValue = 101,allocationSize = 1)
	@GeneratedValue(generator = "perg1",strategy = GenerationType.SEQUENCE)
private Integer regNo;
private Long mobileNo;
private String numberType;
private String provider;

@Override
public String toString() {
	return "PhoneNumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", numberType=" + numberType + ", provider="
			+ provider + "]";
}


}
