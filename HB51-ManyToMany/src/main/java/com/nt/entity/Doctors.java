package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Doctors {
	private Integer doctId;
	private String doctorName;
	private String hospital;
	private Set<Patients> patients;

	public Doctors() {
		System.out.println("Doctors::0-param constructor");
	}

	@Override
	public String toString() {
		return "Doctors [doctId=" + doctId + ", doctorName=" + doctorName + ", hospital=" + hospital + "]";
	}

}
