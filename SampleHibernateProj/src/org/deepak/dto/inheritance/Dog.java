package org.deepak.dto.inheritance;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("Dogs")
public class Dog extends Pet {

	private String bark;

	public String getBark() {
		return bark;
	}

	public void setBark(String bark) {
		this.bark = bark;
	}
	
}
