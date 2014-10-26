package org.deepak.dto;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Bike")
public class Bike {
	private String bikeName;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bikeId;
	
	@ManyToOne
	@JoinColumn(name="Person_Id")
	//@NotFound(action=NotFoundAction.IGNORE)
	private Person person = new Person();

	public String getBikeName() {
		return bikeName;
	}
	
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	
	public int getBikeId() {
		return bikeId;
	}
	
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

}
