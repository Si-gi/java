import java.util.Scanner;
import java.util.*;

public class PointMain{
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Point pointA = new Point();
		/*String tableauPosition[][] = {
				{"[ ]","[ ]","[ ]","[ ]"},
				{"[ ]","[ ]","[ ]","[ ]"},
				{"[ ]","[ ]","[ ]","[ ]"},
				{"[ ]","[ ]","[ ]","[ ]"}, 
				{"[ ]","[ ]","[ ]","[ ]"}
			};
		*/
		Point p1 = new Point(2,4);
		Point p2 = new Point(5,6);
		Scanner sc = new Scanner(System.in);
		//System.out.println(tableauPosition);
		 System.out.println("Saisissez x : ");
		 double x = sc.nextInt();
		 System.out.println("Saisissez y : ");
		 double y = sc.nextInt();
		 
		 p1.moveTo(x, y);
		 System.out.println(p1.getX() +" "+ p1.getY());
		 System.out.println("Saisissez x : ");
		 x = sc.nextInt();
		 System.out.println("Saisissez y : ");
		 y = sc.nextInt();
		 p1.rMoveTo(x, y);
		 System.out.println(p1.getX() +" "+ p1.getY());
	}
}
