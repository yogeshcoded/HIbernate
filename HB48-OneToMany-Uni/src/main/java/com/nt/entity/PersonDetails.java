package com.nt.entity;

import java.io.Serializable;
import java.util.Set;


import lombok.Data;

@Data
public class PersonDetails  implements Serializable {
	private Integer pid;
	private String pname;
	private String paddrs;

	private Set<PhoneNumber> phones;

	@Override
	public String toString() {
		return "PersonDetails [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", phones=" + phones + "]";
	}

}
