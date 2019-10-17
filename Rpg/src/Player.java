
public class Player extends Monster {
	public static float Hp = 100;
	private double force = 30;
	private Weapon weapon;
	public static boolean status[] = {false,false,false,false,false};
	
	public Player(String name) {
		super(name);
		this.weapon = null;
	}
	
	public float getHp() {
		return this.Hp;
	}
	public void setHp(float hp) {
		this.Hp = hp;
	}
	
	public double getForce() {
		return this.force;
	}
	
	public void changeStatu(int index) {
		this.status[index] = (status[index]) ? false : true;
	}
	
	public double attack(Monster m) {
		return this.weapon.getDmg() + this.force;
	}
}
