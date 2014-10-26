package org.deepak.test;

import java.util.List;
import java.util.Map;

import org.deepak.dto.crud.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class HibernateCacheTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// 1. Session Level Cache
		// 2. Second Level Cache
		// 3. Cachable Query

		Employee employee = (Employee)session.get(Employee.class, 4);
		Employee employee1 = (Employee)session.get(Employee.class, 4);
		
		Query query1 = session.createQuery("from Employee where employeeId = 3");
		query1.setCacheable(true);
		List<Employee> employeeList = query1.list();

		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		Employee employee2 = (Employee)session2.get(Employee.class, 4);
		Employee employee3 = (Employee)session2.get(Employee.class, 4);
		
		Query query2 = session.createQuery("from Employee where employeeId = 3");
		query2.setCacheable(true);
		List<Employee> employeeList2 = query2.list();

		session2.getTransaction().commit();
		session2.close();

	}

}
