package org.deepak.test;

import java.util.Collection;
import java.util.Date;

import org.deepak.dto.Address;
import org.deepak.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

	public static void main(String[] args) {
		// Creating 1st row
		UserDetails userDetails = new UserDetails();
		Address homeAddress = new Address();
		// userDetails.setUserId(1);
		userDetails.setUserName("First User");
		userDetails.setJoinedDate(new Date());
		userDetails.setDescription("Description of the user");

		homeAddress.setStreet("Street1");
		homeAddress.setState("Alabama");
		homeAddress.setCity("New York");
		homeAddress.setZipcode("102030");
		userDetails.setHomeAddress(homeAddress);
		
		// Creating 2nd row
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setUserName("Second User");
		userDetails2.setJoinedDate(new Date());
		userDetails2.setDescription("Description of the user");
		
		Address address2 = new Address();
		address2.setStreet("Street2");
		address2.setState("CA");
		address2.setCity("California");
		address2.setZipcode("102030");
		
		userDetails2.getOfficeAddress().add(address2);
		userDetails2.getOfficeAddress().add(homeAddress);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.save(userDetails2);
		session2.getTransaction().commit();
		session2.close();
		
		userDetails2 = null;
		Session session3 = sessionFactory.openSession();
		userDetails2 = (UserDetails)session3.get(UserDetails.class, 1);
		System.out.println("The user name is=" + userDetails2.getUserName());
		System.out.println("Size of officeAddress=" + userDetails2.getOfficeAddress().size());

	}

}
