package com.nt.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Embeddable
@Table(name="Person")
public class JobDetails {
private String desg;
private String company;
private Integer Salary;
}
