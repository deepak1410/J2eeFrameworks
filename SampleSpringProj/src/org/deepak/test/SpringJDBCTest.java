package org.deepak.test;

import org.deepak.jdbc.dao.SpringJdbcDaoImpl;
import org.deepak.jdbc.model.TestUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*In this project for the spring-jdbc integration derby database has been used. This requires 2  jars
 * derby.jar and derbyclient.jar */
public class SpringJDBCTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		SpringJdbcDaoImpl springJdbcDaoImpl = context.getBean("springJdbcDaoImpl", SpringJdbcDaoImpl.class);
		
		springJdbcDaoImpl.getTestUser(1);
	}

}
