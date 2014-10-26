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


public class HibernateAPI2Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Named Query : HQL
		Query query1 = session.getNamedQuery("Employee.getById");
		query1.setInteger(0, 5);
		List<Employee> empList = query1.list();
		System.out.println("Emp= " + empList.get(0).getEmployeeName());

		// Named Native query : SQL
		Query query2 = session.getNamedQuery("Employee.getUsingId");
		query2.setInteger(0, 3);
		List<Employee> employeesList = query2.list();
		System.out.println("Emp= " + employeesList.get(0).getEmployeeName());
		
		// Criteria Restrictions
		Criteria criteria = session.createCriteria(Employee.class);
		Criteria criteria1 = session.createCriteria(Employee.class);
		Criteria criteria2 = session.createCriteria(Employee.class);

		// AND Restrictions
		criteria.add(Restrictions.like("employeeName", "%Emp%" ))
		.add(Restrictions.between("employeeId", 2, 4));
		List<Employee> empCriteriaList = criteria.list();
		
		// OR Restrictions
		criteria1.add(Restrictions.or(Restrictions.between("employeeId", 7, 9), Restrictions.between("employeeId", 2, 4)));
		List<Employee> empCriteria1List = criteria1.list();
		for(Employee emp : empCriteria1List) {
			System.out.println("Emp based on OR criteria List= " + emp.getEmployeeName());
		}
		
		// Projection
		List max = session.createCriteria(Employee.class).setProjection(Projections.max("employeeId")).list();
		System.out.println(max.get(0));
		
		List<Integer> empIdList = session.createCriteria(Employee.class).setProjection(Projections.property("employeeId")).addOrder(Order.desc("employeeId")).list();
		for(int empId : empIdList) {
			System.out.println("Each Emp Id= " + empId);
		}
		
		// Order
		criteria2.addOrder(Order.desc("employeeName"));
		List<Employee> empCriteria2List = criteria2.list();
		
		for(Employee emp : empCriteria2List) {
			System.out.println("Emp name based on projection = " + emp.getEmployeeName());
		}


		session.getTransaction().commit();
		session.close();		

	}

}
