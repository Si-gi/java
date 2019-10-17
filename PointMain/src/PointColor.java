
public class PointColor extends Point {
	private String couleur;
	public PointColor(double x, double y, String couleur) {
		super(x,y);
		this.couleur = couleur;
	}
	
	public String getCouleur(){return couleur;}
}
