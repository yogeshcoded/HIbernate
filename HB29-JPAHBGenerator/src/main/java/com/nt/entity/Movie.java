package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity

public class Movie {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	
	/*@SequenceGenerator(name = "gen1",sequenceName="JPA_SEQ",
	                                                                                initialValue = 700,allocationSize=10)
		@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
		@Id*/
	
	/*@Id
	@SequenceGenerator(name="gen1",sequenceName="JPA_SEQ1")
	@GeneratedValue(generator = "gen1",strategy =GenerationType.SEQUENCE)*/
	
	/*@Id
	@TableGenerator(name = "gen1",pkColumnName = "ID_VAl",table = "ID_TAB",pkColumnValue = "MID",
	                                                                       valueColumnName = "VAL_COL",initialValue = 750,allocationSize = 5)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)*/
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.TABLE)*/
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="JPA_MN1",initialValue = 500,allocationSize = 5)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Integer mid;
	private String mname;
	private String hero;
	private Integer budget;

}// class
