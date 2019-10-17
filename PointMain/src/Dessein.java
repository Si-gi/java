import java.util.ArrayList;

public class Dessein{
	
	private ArrayList<FormeGeometrique> formes;
	
	public Dessein(ArrayList<FormeGeometrique> formes) {
		this.formes = formes;
	}
	
	public void add(FormeGeometrique forme) {
		this.formes.add(forme);
	}
	
	public void translate(int i, int x) {
		for(FormeGeometrique f: this.formes) {
			
		}
	}
	
}
