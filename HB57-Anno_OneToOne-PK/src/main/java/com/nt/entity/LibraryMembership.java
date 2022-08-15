package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="AANO_LIBRARYMEMBERSHIP_OTOPK")
public class LibraryMembership implements Serializable{
	@Id
	@GenericGenerator(name="gen1",strategy = "foreign",
	parameters = @Parameter(name="property",value="studentDetails"))
	@GeneratedValue(generator = "gen1")
private Integer lid;
private String type;
private LocalDate doj;
@OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "libraryDetails")
private Student studentDetails;

public LibraryMembership() {
	System.out.println("LibraryMembership:: 0-param constructor  "+this.getClass());
}

@Override
public String toString() {
	return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
}

}
