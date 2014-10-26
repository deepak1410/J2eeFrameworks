package org.deepak.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Person")
public class Person {

	private String personName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Car_Id")
	private Car car = new Car();
	
	@ManyToMany(mappedBy="person")
	private Collection<Bus> buses = new ArrayList<Bus>();
	
	// This makes to create a new table for the mapping
/*	@OneToMany
	@JoinTable(name="Person_Bike", joinColumns=@JoinColumn(name="Person_Id"), inverseJoinColumns=@JoinColumn(name="Bike_Id"))
	private Collection<Bike> bikes = new ArrayList<Bike>();
*/

	@OneToMany(mappedBy="person")
	private Collection<Bike> bikes = new ArrayList<Bike>();

	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	public Collection<Bike> getBikes() {
		return bikes;
	}
	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}
	
	public Collection<Bus> getBuses() {
		return buses;
	}

	public void setBuses(Collection<Bus> buses) {
		this.buses = buses;
	}
}
