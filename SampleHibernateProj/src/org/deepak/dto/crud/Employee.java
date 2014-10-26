package org.deepak.dto.crud;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="Employee.getById", query="from Employee where employeeId = ?")
@NamedNativeQuery(name="Employee.getUsingId",query="Select * from Employee where employeeId = ?",resultClass=Employee.class)
public class Employee {
	private String employeeName;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	
	public Employee() {};
	
	public Employee(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
