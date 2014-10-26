package org.deepak.test;

import java.util.List;
import java.util.Map;

import org.deepak.dto.crud.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateAPITest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		// Fetching records and pagination
		Query query = session.createQuery("from Employee where employeeId > 2");
		query.setFirstResult(4);
		query.setMaxResults(3);
		List<Employee> employeeList = query.list();
		for(Employee emp : employeeList) {
			System.out.println("Employees id:" + emp.getEmployeeId() + " Employee Name: " + emp.getEmployeeName());
		}
		// SQL query
		String minUser = "5";
		String maxUser = "9";
		String userName = "Employee 7";
		Query query1 = session.createQuery("Select employeeName from Employee where employeeId > ? AND employeeId < ?"
				+ "AND employeeName = ?");
		query1.setInteger(0, Integer.parseInt(minUser));
		query1.setInteger(1, Integer.parseInt(maxUser));
		query1.setString(2, userName);
		List<String> employeeNameList = query1.list();
		for(String emp : employeeNameList) {
			System.out.println("Employees Name is:" + emp);
		}
		// Parameter Binding
		Query query2 = session.createQuery("Select employeeName from Employee where employeeId > :minEmpId AND employeeId < :maxEmpId");
		query2.setInteger("minEmpId", Integer.parseInt(minUser));
		query2.setInteger("maxEmpId", Integer.parseInt(maxUser));
		List<String> empNameList = query2.list();
		for(String emp : empNameList) {
			System.out.println("The Employees are:" + emp);
		}

		// 
		session.getTransaction().commit();
		session.close();
		
		 System.out.println("The number of employees is: " + employeeList.size());

		/* CRUD Operations
		//Create
		for(int i=0;i<10;i++) {
			Employee employee = new Employee("User " + i);
			session.save(employee);
		} 

		// Read
		 Employee employee = (Employee)session.get(Employee.class, 4);

		// Delete
		 session.delete(employee);

		// Update
		employee.setEmployeeName("Updated User");
	    session.update(employee);
		*/

		// Transient vs Persistence vs Detached Objects
		/*
		Employee employee1 = new Employee("Employee 1");
		// employee1 is Transient upto now since its not saved.

		session.save(employee1);
		// employee1 has become persistent now
		employee1.setEmployeeName("New Employee");
		employee1.setEmployeeName("New Employee again");
		session.getTransaction().commit();
		session.close();

		// employee1 is detached object now since the session has closed. Any change to it will not persist into db.
		employee1.setEmployeeName("New Test Employee");
		*/
		

	}

}
