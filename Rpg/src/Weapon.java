
public class Weapon {

	protected double dmg;
	protected double price;

	public Weapon(double damage, double price) {
		this.dmg = damage;
		this.price = price;
	}
	
	public double price() {
		return this.price;
	}
	public String ascii_art() {
		return  "coucou";
		}
	public double getDmg() {
		return this.dmg;
	}
}
