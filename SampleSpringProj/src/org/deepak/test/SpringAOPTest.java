package org.deepak.test;

import org.deepak.aop.model.Product;
import org.deepak.aop.service.EComService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
		
		Product phone = (Product)context.getBean("phone");
		//Product laptop = context.getBean("laptop", Product.class);
		Product laptop = (Product)context.getBean("laptop");

		EComService service = context.getBean("ecom", EComService.class);
		
		phone.setName("Moto G");
		laptop.setName("Dell Latitude");
		
		// Please note that the advice which is written on getName() will be called only on service.getPhone().getName() and not on service.getLaptop()
		// even though the toString() method is calling it.
		// System.out.println("The Phone is: " + service.getPhone().getName() + " and the Laptop is: " + service.getLaptop());
		
		System.out.println("The Phone is: " + service.getPhone().getName() + " and the Laptop is: " + service.getLaptop().getName());

	}

}
