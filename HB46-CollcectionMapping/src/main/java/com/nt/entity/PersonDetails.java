package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String pname;
	private String paddrs;
	
	private List<String> nickNames;
	private List<String>friends;
	
	private Set<Long>contactNo;
	
	private Map<String,Object> idDetails;
	
	
	
	

}
