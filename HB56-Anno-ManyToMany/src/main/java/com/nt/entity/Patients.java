package com.nt.entity;

import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ANNO_PATIENT_MTM")
public class Patients {
	@Id
	@SequenceGenerator(sequenceName = "PATIENT_SEQU",initialValue = 1001,allocationSize = 1,name="seq1")
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	private String pname;
	private String problem;
	
	@ManyToMany(targetEntity = Doctors.class,cascade = CascadeType.ALL,fetch =FetchType.LAZY ,mappedBy = "patients")
		@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Doctors> doctors;

	public Patients() {
		System.out.println("Patients:: 0-param constructor");

	}

	@Override
	public String toString() {
		return "Patients [pid=" + pid + ", pname=" + pname + ", problem=" + problem + "]";
	}

}
