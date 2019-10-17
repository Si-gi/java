import java.util.ArrayList;
import java.util.List; 

public class FormeGeometrique{
	
	public List<Point> listPoint = new ArrayList<Point>();
	public String color;
	public FormeGeometrique(Point a, Point b, Point x, Point y) {
		listPoint.add(a);
		listPoint.add(b);
		listPoint.add(x);
		listPoint.add(y);

	}
	
	public FormeGeometrique(Point a, Point b, Point x) {
		listPoint.add(a);
		listPoint.add(b);
		listPoint.add(x);
	}
	
	public FormeGeometrique(Point a, Point b) {
		listPoint.add(a);
		listPoint.add(b);
	}
	
	public FormeGeometrique(ArrayList<Point> Points){
		this.listPoint = Points;
	}
	
	public List<Point> getPoints() {
		return listPoint;
	}
	
	public Point getPoint(int i) {
		return listPoint.get(i);
	}
	
	public void setCouleur(String couleur) {
		
	}

}
