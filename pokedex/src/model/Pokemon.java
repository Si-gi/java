package model;

import java.util.ArrayList;

public class Pokemon extends Card{
	private int hp;
	private ArrayList<Attack> attacks;
	
	public Pokemon(String name, String type, String description, String image, int id, int hp, ArrayList<Attack> attacks) {
		super(name,type,description,image, id);
		this.hp=hp;
		this.attacks = attacks;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(ArrayList<Attack> attacks) {
		this.attacks = attacks;
	}
	public void addAttack(Attack attack) {
		this.attacks.add(attack);
	}
	public void deleteAttack(Attack attack) {
		this.attacks.remove(attack);
	}

}
