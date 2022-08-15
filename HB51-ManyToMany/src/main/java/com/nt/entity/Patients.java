package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Patients {
	private Integer pid;
	private String pname;
	private String problem;
	private Set<Doctors> doctors;

	public Patients() {
		System.out.println("Patients:: 0-param constructor");

	}

	@Override
	public String toString() {
		return "Patients [pid=" + pid + ", pname=" + pname + ", problem=" + problem + "]";
	}

}
