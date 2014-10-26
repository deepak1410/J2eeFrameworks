package org.deepak.dto;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Address {

	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	private String zipcode;

	@Column(name="STREET_NAME")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="ZIP_CODE")
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
