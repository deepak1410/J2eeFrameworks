package org.deepak.test;

import org.deepak.annotations.Cricketer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsTest {

	public static void main(String[] args) {

		// AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// context.registerShutdownHook();

		// Greeting message from the website
		String greetingMsg = context.getMessage("greetings", null, "Default Greeting", null);
		System.out.println(greetingMsg);
		
		Cricketer cricketer = (Cricketer)context.getBean("batsman");
		cricketer.play();
		
		
	}

}
