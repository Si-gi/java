import java.util.*;

public class Joueur {
	private List<Carte> cartes = new ArrayList<>();
	
	
	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}
	public void loseCarte(Carte carte) {
		cartes.remove(carte);
	}
	
	public List<Carte> getCartes(){
		return this.cartes;
	}
	
	public Carte getCarte(int index) {
		Carte[] item = this.cartes.toArray(new Carte[this.cartes.size()]);  
		return item[index];
	}
}
