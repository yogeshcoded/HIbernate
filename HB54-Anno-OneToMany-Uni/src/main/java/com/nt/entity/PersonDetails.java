package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
@Table(name="ANNO_PERSON_DEATALS_OTM")
public class PersonDetails  implements Serializable {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private String paddrs;

	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(columnDefinition = "PERSON_ID",referencedColumnName = "PID" )
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<PhoneNumber> phones;

	@Override
	public String toString() {
		return "PersonDetails [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", phones=" + phones + "]";
	}

}
