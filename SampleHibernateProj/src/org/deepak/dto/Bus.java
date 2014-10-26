package org.deepak.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Bus")
public class Bus {
	private String busName;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int busId;

	@ManyToMany
	@JoinColumn(name="person_id")
	@JoinTable(name="Person_Bus_Details", joinColumns=@JoinColumn(name="Person_Id"), inverseJoinColumns=@JoinColumn(name="Bus_Id"))
	private Collection<Person> person = new ArrayList<Person>();

	public String getBusName() {
		return busName;
	}
	
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
	public int getBusId() {
		return busId;
	}
	
	public void setBusId(int busId) {
		this.busId = busId;
	}
	
	public Collection<Person> getPerson() {
		return person;
	}

	public void setPerson(Collection<Person> person) {
		this.person = person;
	}

}
