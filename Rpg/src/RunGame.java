import java.util.Scanner;

public class RunGame {

	private Player player;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeaponStore store = new WeaponStore();
		store.price(store.axe);
		Player player = new Player("toto");
		while(player.getHp() > 0) {
			choiceAction(player);
		}
	}
	public static void arene(Player player){
		//choice monster
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		System.out.println("Un orc : 1");
		System.out.println("Un troll: 2");
		System.out.println("Un flic:3");
		String str = sc.nextLine();
		System.out.println("Vous avez saisi : " + str);
		int choice = Integer.parseInt(str);	
		switch(choice) {
		default:
			Monster poulet = new Poulet();
			new Arene(poulet, player);
			break;
		case 1:
		Monster orc = new Orc();
			new Arene(orc, player);
			break;
		case 2:
			Monster p = new Poulet();
			new Arene(p,player);
			break;
		}
	}
	
	public static void choiceAction(Player player) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez combattre ou acheter du stuff ?");
		System.out.println("combattre: 1");
		System.out.println("Shopping: 2");
		String str = sc.nextLine();
		int choice = Integer.parseInt(str);
		switch(choice) {
		default:
			arene(player);
			break;
		case 1 :
			arene(player);
			break;
		case 2 :
			makeShopping();
			break;
		}
	}
	
	public static void makeShopping() {
		
	}
	

}
