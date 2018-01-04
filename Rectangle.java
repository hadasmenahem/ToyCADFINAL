
public class Rectangle extends Parallelogram{
	
	public Rectangle(int ID, String color, Point point1, Point point3){
		super(ID, color, point1, new Point(point1.GetX(),point3.GetY()), point3);
	}
}
