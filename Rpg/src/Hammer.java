
public class Hammer extends Weapon{
	private static final double DAMAGE = 20;
	private static final double PRICE = 11.0;
	public Hammer() {
		super(DAMAGE,PRICE);
	}
	public String ascii_art() {
		return  "_________\n"+     // What’s wrong here ?
				"|_ _||__|  \n" +
				"    ||    \n"+  // And here ?
				"    ||     \n" +
				"    ||     \n" +
				"    ||     \n";
		}
}
