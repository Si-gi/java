import java.util.Scanner;

public class RunGame {

	private Player player;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeaponStore store = new WeaponStore();
		store.price(store.axe);
		Player player = new Player("toto");
		while(player.getHp() > 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un mot :");
			System.out.println("Un orc : 1");
			System.out.println("Un troll: 2");
			System.out.println("Un flic:3");
			System.out.println("A bootlicker:4");
			String str = sc.nextLine();
			System.out.println("Vous avez saisi : " + str);
			int choice = Integer.parseInt(str);	
			switch(choice) {
			default:
				//figh;
				break;
			case 1:
				Scanner sc = new Scanner(System.in);
				System.out.println("Veuillez saisir un mot :");
				System.out.println("Un orc : 1");
				System.out.println("Un troll: 2");
				System.out.println("Un flic:3");
				System.out.println("A bootlicker:4");
				String str = sc.nextLine();
				System.out.println("Vous avez saisi : " + str);
				int monstre = Integer.parseInt(str);	
				new Arene(monstre);
				break;
			case 2:
				goToShop();
				break;
			}
		}
	}
	public void arene(){
		//choice monster
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		System.out.println("Un orc : 1");
		System.out.println("Un troll: 2");
		System.out.println("Un flic:3");
		System.out.println("A bootlicker:4");
		String str = sc.nextLine();
		System.out.println("Vous avez saisi : " + str);
		int choice = Integer.parseInt(str);	
		switch(choice) {
		default:
			Monster poulet = new Poulet();
			this.player.fight(poulet);
			break;
		case 1:
		Monster orc = new Orc();
			player.fight(orc);
			break;
		case 2:
			Monster p = new Poulet();
			player.fight(p);
			break;
		}
	}

}
