package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Data

public class CallerTune {
	@Id
@GeneratedValue
private Integer tuneId;
private String tuneName;
private String movieName;
@Version
private Integer updationCount;
}
