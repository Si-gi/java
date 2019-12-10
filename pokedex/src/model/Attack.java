package model;

public class Attack {

	private String name;
	private String description;
	private int power;
	
	public Attack(String name, String description, int power) {
		this.name = name;
		this.description = description;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
