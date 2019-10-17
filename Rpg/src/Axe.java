
public class Axe extends Weapon{
	private static final double DAMAGE = 10;
	private static final double PRICE = 5.5;
	public Axe() {
		super(DAMAGE, PRICE);
	}
	
	public String ascii_art() {
		return  "/�-,/\\_  \n"+     // What�s wrong here ?
				"|   ||,>  \n" +
				"\\.-�||    \n"+  // And here ?
				"    ||     \n" +
				"    ||     \n" +
				"    ||     \n";
		}
}
