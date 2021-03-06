
import java.lang.Math;

public class Point {
    private double x;
    private double y;
    
    public Point(double x, double y) {
    	this.x = x;
    	this.y = y;
    }

    public double getX(){
    	return this.x;
    }

    public void setX(Double x){
    	this.x = x;
    }

    public double getY(){
    	return this.y;
    }
    
    public void setY(Double y){
    	this.y=y;
    }

    public void moveTo(double x, double y){
    	setX(x);
    	setY(y);
    }

    public void rMoveTo(double x, double y){
    	this.x = x+getX();
    	this.y = y+getY();
    	
    }
    
    public double distance(Point second){
    	double xP = second.getX();
    	double yP = second.getY();
    	double result =	Math.sqrt( (xP - this.getX()) * (xP - getX()) + (yP - getY()) * (yP - getY()) ); 
    	return result;
    }
}
