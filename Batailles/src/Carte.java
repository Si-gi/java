
public class Carte {
	
	public static String couleurs[] = {"Carreau", "Coeur", "Trefle", "Pic"};
	public static String valeurs[] = {"2" ,"3", "4", "5", "6", "7", "8", "9", "valet", "dame", "roi", "as"};
    private String couleur;
    private String valeur;
    public Carte(int i, int j) {
    	this.couleur = couleurs[i];
    	this.valeur = valeurs[j];
    }

	public String getCouleur() {
		return couleur;
	}

	public String getValeur() {
		return valeur;
	}
	
	public int getIndex (String item) {
		int index = -1;
		for(int i = 0; i< this.valeurs.length; i++) {
	        if (this.valeurs[i] == item) {
	            index = i;
	            break;
	        }
		}
		return index;
	}
	
}
