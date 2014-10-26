package org.deepak.annotations;

public class Baller implements Cricketer {
	
	private String name;
	private PlayerDetails type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerDetails getType() {
		return type;
	}

	public void setType(PlayerDetails type) {
		this.type = type;
	}

	@Override
	public void play() {
		System.out.println(getType() + "Baller delivers the next ball");
	}

}
