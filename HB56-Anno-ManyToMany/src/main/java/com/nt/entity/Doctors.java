package com.nt.entity;

import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name ="ANNO_DOCTORS_MTM")
public class Doctors {
	@Id
	@GeneratedValue
	private Integer doctId;
	private String doctorName;
	private String hospital;

	@ManyToMany(targetEntity = Patients.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "ANNO_HB_DOCTOR_PATIENT_MTM", 
	joinColumns = @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "DOCTID"), 
	inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PID"))
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Patients> patients;

	public Doctors() {
		System.out.println("Doctors::0-param constructor");
	}

	@Override
	public String toString() {
		return "Doctors (doctId=" + doctId + ", doctorName=" + doctorName + ", hospital=" + hospital + ")";
	}

}
