package org.deepak.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.deepak.jdbc.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcDaoImpl {
	private DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	protected void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public TestUser getTestUser(int id) {
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement("Select * from TestUser where id=?");
			TestUser testUser = null;
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				testUser = new TestUser(id, rs.getString("name"));
			}
			rs.close();
			statement.close();
			return testUser; 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	
}
