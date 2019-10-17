
public class Arene {
	private Monster monster;
	private Player player;
	public Arene(Monster m, Player p) {
		this.monster = m;
		this.player = p;
	}
	
	public void fight() {
		while(player.getHp() > 0 || monster.getHp() > 0) {
			player.attack(monster);
			monster.attack(player);
		}
		
	}

}
