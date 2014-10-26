package org.deepak.aop.service;

import org.deepak.aop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ecom")
public class EComService {
	private Product phone;
	private Product laptop;

	public Product getPhone() {
		return phone;
	}

	@Autowired
	public void setPhone(Product phone) {
		this.phone = phone;
	}

	public Product getLaptop() {
		return laptop;
	}

	@Autowired
	public void setLaptop(Product laptop) {
		this.laptop = laptop;
	}

}
