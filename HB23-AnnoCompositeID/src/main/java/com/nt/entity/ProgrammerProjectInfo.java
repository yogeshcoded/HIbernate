package com.nt.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammerProjectInfo {
	//HAS-A property of id class
	@EmbeddedId
	private PrgmrProjId id;
	private String prgmrName; 
	private String projName; 
	private double salary; 
	private double budget; 

}//class
