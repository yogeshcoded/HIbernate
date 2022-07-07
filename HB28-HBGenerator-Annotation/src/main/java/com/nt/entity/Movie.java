package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity

public class Movie {
//increment generator
	/*@Id
	@GenericGenerator(name = "gen1", strategy = "Increment")
	@GeneratedValue(generator = "gen1")*/
	
	//identity generator
	/*@Id
	@GenericGenerator(name = "gen1", strategy = "identity")
	@GeneratedValue(generator = "gen1")*/
	
	//sequence generator
	/*	@Id
		@GenericGenerator(name = "HBSQ", strategy = "sequence")
		@GeneratedValue(generator = "HBSQ")*/
	
	/*@Id
	@GenericGenerator(name = "HBSQ", strategy = "sequence",parameters= {@Parameter( name="sequence_name",value="GEN1")})
	@GeneratedValue(generator = "HBSQ")*/
	
	@Id
	@GenericGenerator(name = "HB_YOGESH", strategy = "sequence",parameters= {@Parameter(name="sequence", value = "gen1"),
			@Parameter(name="initial_value", value="100"),
			@Parameter(name="increment_size", value="10"),
	           }
	)
	@GeneratedValue(generator = "HB_YOGESH")
	private Integer mid;
	private String mname;
	private String hero;
	private Integer budget;

}// class
