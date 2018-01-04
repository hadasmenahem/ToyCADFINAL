
public class Point {

	private double x;
	private double y;
	
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double GetY(){
		return y;
	}
		
	public double GetX(){
		return x;
	}
	
	public void SetY(double y){
		this.y=y;
	}
	
	public void SetX(double x){
		this.x=x;
	}
	
	public static double GetDistanceBetweenTwoAxisValues(double value1, double value2){
		return Math.abs(value2-value1);
	}
	
	public static double GetDistanceBetweenTwoPoints(Point point1, Point point2){
		double xDistance=GetDistanceBetweenTwoAxisValues(point1.GetX(), point2.GetX());
		double yDistance=GetDistanceBetweenTwoAxisValues(point1.GetY(), point2.GetY());
		return (Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2)));
	}
	
	
	public static Point GetFourthPoint(Point point1, Point point2, Point point3){
		Point point4=new Point(0,0);
		
		point4.SetX(point1.GetX()+point3.GetX()-point2.GetX());
		point4.SetY(point1.GetY()+point3.GetY()-point2.GetY());
		
		return point4;
	}
}
