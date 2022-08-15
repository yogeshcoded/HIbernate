package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.ListIndexBase;

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
	
	@ElementCollection
	@CollectionTable(name = "ANNO_NICKNAMES_COL",
	                joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	@OrderColumn(name = "INDXX")
	@ListIndexBase(value = 1)
	private List<String> nickNames;
	
	@ElementCollection
	@CollectionTable(name = "ANNO_FRIENDS_COL",
	                 joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	private List<String>friends;
	
	
	@ElementCollection
	@CollectionTable(name = "ANNO_CONTACTNO_COL",
	                 joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	private Set<Long>contactNo;
	
	@ElementCollection
	@CollectionTable(name = "ANNO_IDDETAILS_COL",
	              joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	@MapKeyColumn(name = "IDTYPE")
	private Map<String,Long> idDetails;
	
	
	
	

}
