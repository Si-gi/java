import java.util.ArrayList;

public class WeaponStore {

	int number_weapons = 3 ;
	Number extra_damage =new Integer(42);
	Weapon axe =new Axe();
	Weapon hammer =new Hammer();
	static ArrayList<Weapon> store = new ArrayList<>();
	public WeaponStore() {
		this.store.add(axe);
		store.add(hammer);
	}
	
	public double price(Weapon w) {
		System.out.println(w.price());
		System.out.println(w.ascii_art());
		return w.price();
		}
}
