import java.lang.Math;
import java.util.ArrayList;
import java.util.List; 

public class JeuPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur p1 = new Joueur();
		Joueur p2 = new Joueur();
		final List<Carte> cartes = new ArrayList<>();
		final List<Carte> tempCartesp1 = new ArrayList<>();
		final List<Carte> tempCartesp2 = new ArrayList<>();		
		for(int i =0; i<4; i++) {
			for(int j = 0; j<11; j++) {
				cartes.add(new Carte(i, j));
			}
		}
		System.out.println(cartes.size());
		for(int i =0; i<cartes.size() - 1; i++)
		{
			int nbAlea = (int)(Math.random() * ((cartes.size() - 1)));
			if(i%2 == 0) {
				p1.addCarte(cartes.get(nbAlea));
			}else {
				p2.addCarte(cartes.get(nbAlea));
			}
			cartes.remove(nbAlea);
		}

		while( (p1.getCartes().size() > 0 && p2.getCartes().size() > 0) ) {
			int nbCarteP1 = p1.getCartes().size();
			int nbCarteP2 = p2.getCartes().size();
			
			int p1Alea = (int)(Math.random() * ((nbCarteP1)));
			int p2Alea = (int)(Math.random() * ((nbCarteP2)));
			Carte cartep1 = p1.getCarte(p1Alea);
			Carte cartep2 = p2.getCarte(p2Alea);

			tempCartesp1.add(cartep1);
			tempCartesp2.add(cartep2);
			if(p1Alea == 13 && p2Alea == 12) {
				System.out.println("ACAB");
			}
			if( cartep1.getIndex(cartep1.getValeur()) < cartep2.getIndex(cartep2.getValeur()) ){
				for(Carte carte: tempCartesp1) {
					p2.addCarte(carte);
					p1.loseCarte(carte);
				}
				tempCartesp1.clear();
				tempCartesp2.clear();
			}
			else if(cartep1.getIndex(cartep1.getValeur()) > cartep2.getIndex(cartep2.getValeur())){
				for(Carte carte: tempCartesp2) {
					p1.addCarte(carte);
					p2.loseCarte(carte);
				}			
				tempCartesp1.clear();
				tempCartesp2.clear();
			}
		}
		System.out.println("c'est fini !");
	}
}
