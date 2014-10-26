package org.deepak.test;

import javax.persistence.*;

import org.deepak.dto.inheritance.Pet;
import org.deepak.dto.inheritance.Dog;
import org.deepak.dto.inheritance.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class InheritanceTest {

	public static void main(String[] args) {

		Pet pet1 = new Pet();
		pet1.setName("First Pet");
		
		Dog dog1 = new Dog();
		dog1.setName("first Dog");
		dog1.setBark("Barking of Dog");

		Cat cat1 = new Cat();
		cat1.setName("First Cat");
		cat1.setClimb("Cat climbing");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(pet1);
		session.save(dog1);
		session.save(cat1);
		session.getTransaction().commit();
	}

}
