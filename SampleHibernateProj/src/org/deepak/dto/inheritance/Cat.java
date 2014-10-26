package org.deepak.dto.inheritance;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("Cats")
public class Cat extends Pet {
	private String climb;

	public String getClimb() {
		return climb;
	}

	public void setClimb(String climb) {
		this.climb = climb;
	}

}
