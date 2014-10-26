package org.deepak.jdbc.model;

public class TestUser {
	private int id;
	private String name;
	
	public TestUser(int id, String name) {
		setId(id);
		setName(name);
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	
	
}
