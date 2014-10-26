package org.deepak.test;

import java.util.Map;

import org.deepak.shape.Point;
import org.deepak.shape.Shape;
import org.deepak.shape.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingTest {

	public static void main(String[] args) {
		// BeanFactory uses Factory pattern method to get instance of objects. There is another way is by using ApplicationContext
		// ApplicationContext has some more features than BeanFactory and gives better performance.
		// Please note that the xml config file in this case should be inside the class path.

		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring-config.xml"));
		//Triangle triangle = (Triangle) factory.getBean("triangle");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Shape shape = (Shape) context.getBean("triangle");
		// System.out.println("The triangle is: " + shape.getType());
		shape.draw();
		
		System.out.println("Creating new Triangle.....");
		Triangle triangle1 = (Triangle) context.getBean("triangle1");
		System.out.println("The dimension is:(" + triangle1.getPointA().getX() + "," + triangle1.getPointA().getY() + 
		"),(" + triangle1.getPointB().getX()+","+triangle1.getPointB().getY()+"),("+triangle1.getPointC().getX()+","+triangle1.getPointC().getY()+")");
		
		Triangle triangle2 = (Triangle) context.getBean("triangle2");
		System.out.println("Displaying Triangle using Map in Spring...");
		for(Map.Entry<String, Point> eachPoint: triangle2.getPointList().entrySet()) {
			System.out.println(eachPoint.getValue());
		}
		
		Triangle triangle3 = (Triangle) context.getBean("triangle3");
		System.out.println("Displaying Triangle using List in Spring...");
		for(Point eachPoint: triangle3.getPoints()) {
			System.out.println(eachPoint);
		}
		
		Triangle triangle4 = (Triangle) context.getBean("triangle4");
		System.out.println("Testing autowire feature of Spring...");
		System.out.println(triangle4.getPointA());
		
	}

}
