package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

import com.nt.proxy.IMovie;

import lombok.Data;
@Entity
@Data
@Proxy(lazy = true,proxyClass = com.nt.proxy.IMovie.class)
public final class Movie implements IMovie {
	@Id //singular id
	private Integer mid;
	private String mname;
	private String hero;
	private Integer budget;
	
	public Movie() {
		System.out.println("o-param contructor");
	}
	
	
}//class
