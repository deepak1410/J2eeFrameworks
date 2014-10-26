package org.deepak.test;

import org.deepak.dto.Bike;
import org.deepak.dto.Bus;
import org.deepak.dto.Car;
import org.deepak.dto.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {

	public static void main(String[] args) {
		
		Person person1 = new Person();
		person1.setPersonName("Sachin");
		
		Car car1 = new Car();
		car1.setCarName("Swift");
		
		Car car2 = new Car();
		car2.setCarName("Audi");
		
		Bike bike1 = new Bike();
		bike1.setBikeName("Pulsar");
		Bike bike2 = new Bike();
		bike2.setBikeName("Apache RTR");
		
		person1.setCar(car1);
		person1.getBikes().add(bike1);
		person1.getBikes().add(bike2);
		
		// This is for many to one relationship
		bike1.setPerson(person1);
		bike2.setPerson(person1);
		
		// This is for many to many relationShip
		Person person2 = new Person();
		person2.setPersonName("Kohli");
		person2.setCar(car2);
		Bus bus1 = new Bus();
		Bus bus2 = new Bus();
		bus1.setBusName("Volvo");
		bus2.setBusName("Ordinary");
		person1.getBuses().add(bus1);
		person1.getBuses().add(bus2);
		person2.getBuses().add(bus1);
		person2.getBuses().add(bus2);
		bus1.getPerson().add(person1);
		bus1.getPerson().add(person2);
		bus2.getPerson().add(person1);
		bus2.getPerson().add(person2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.persist(person1);
		//session.save(car1);
		session.persist(person2);
		//session.save(car1);
		session.save(bike1);
		session.save(bike2);
		session.save(bus1);
		session.save(bus2);
		session.getTransaction().commit();
		session.close();

	}

}
