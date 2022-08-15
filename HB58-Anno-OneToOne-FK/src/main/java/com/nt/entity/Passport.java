package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ANNO_PASSPORT_OTOFK")
public class Passport implements Serializable{
	@Id
	@SequenceGenerator(name="gen1",initialValue =8001,allocationSize = 1,sequenceName = "PAPORT_SEQ")
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
private Integer passportNo;
private String country;
private LocalDate expiryDate;

@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
private Person personDetails;

public Passport() {
	System.out.println("Passport:: 0-param constructor"+this.getClass());
}

@Override
public String toString() {
	return "Passport [passportNo=" + passportNo + ", contry=" + country + ", expiryDate=" + expiryDate + "]";
}



}
