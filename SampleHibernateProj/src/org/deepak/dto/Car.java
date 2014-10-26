package org.deepak.dto;

import javax.persistence.*;

@Entity
@Table(name="Car")
public class Car {
	private String carName;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int carId;

	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}

}
