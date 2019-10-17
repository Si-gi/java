
public class Rectangle extends FormeGeometrique {

	private double longueur;
	private double largeur;
	public Rectangle(Point a, Point b, Point x, Point y) {
		super(a,b,x,y);
	}
	
	public void angle() {
		int i = 1;
		for(final Point p: listPoint ){
			//triangle rectangle
			Point pointActu =listPoint.get(i-1);
			double dist = pointActu.distance(p);
			
			i ++;
			if(i == 3) {
				break;
			}
		}
	}
	
	public void setCotes() {
			double c1 = listPoint.get(0).distance(listPoint.get(1));
			this.longueur = c1;
			double c2 = listPoint.get(1).distance(listPoint.get(2));
			this.largeur = c2;
	}
	public double getAir() {
		double air = longueur * largeur;
		return air;
	}
	
	public void setCoolor(String color) {
		double air = this.getAir();
		
	}
}
