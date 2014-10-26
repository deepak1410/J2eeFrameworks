package org.deepak.aop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop implements Product{
	private String name;
	private int price;
	private String os;

	public String getName() {
		return name;
		//throw new RuntimeException();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return getName();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	public String setOsAndGet(String os) {
		this.os = os;
		return os;
	}
}
