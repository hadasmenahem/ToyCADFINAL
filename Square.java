
public class Square extends Rectangle {

	public Square(int ID, String color, Point point1, double length){
		super(ID, color, point1, new Point(point1.GetX()+length, point1.GetY()+length));
		
	}
}
