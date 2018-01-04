
public class Parallelogram extends Shape {
	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
		
	public Parallelogram(int ID, String color,Point point1, Point point2, Point point3){
		super(ID, color);
		this.point1=point1;
		this.point2=point2;
		this.point3=point3;
		this.point4=Point.GetFourthPoint(point1,point2,point3);
	}
	
	public double AreaCalculation(){
		return (4*new Triangle(this.GetID(), this.GetColor(),this.point1,this.point2,
				new Point(0.5*(this.point1.GetX()+this.point3.GetX()),
				0.5*(this.point1.GetY()+this.point3.GetY()))).AreaCalculation());
	}
	
	
	public double CircumferenceCalculation(){
		double sideDistance=Point.GetDistanceBetweenTwoPoints(this.point1, this.point2);
		double baseDistance=Point.GetDistanceBetweenTwoPoints(this.point2, this.point3);
		
		return (2*(sideDistance+baseDistance));
	}
	
	public void Move(double xUnitsToMove, double yUnitsToMove){
		this.point1.SetY(this.point1.GetY()+yUnitsToMove);
		this.point1.SetX(this.point1.GetX()+xUnitsToMove);
		
		this.point2.SetY(this.point2.GetY()+yUnitsToMove);
		this.point2.SetX(this.point2.GetX()+xUnitsToMove);
		
		this.point3.SetY(this.point3.GetY()+yUnitsToMove);
		this.point3.SetX(this.point3.GetX()+xUnitsToMove);
		
		this.point4.SetY(this.point4.GetY()+yUnitsToMove);
		this.point4.SetX(this.point4.GetX()+xUnitsToMove);
		
	}
	
	
	public boolean IsInside(Point coordinate){
		Point middlePoint=new Point(0.5*(this.point1.GetX()+this.point3.GetX()),
				0.5*(this.point1.GetY()+this.point3.GetY()));
		
		boolean isInsideSubTriangle1=new Triangle(this.GetID(), this.GetColor(),this.point1,this.point2,
				middlePoint).IsInside(coordinate);
		boolean isInsideSubTriangle2=new Triangle(this.GetID(), this.GetColor(),this.point1,this.point4,
				middlePoint).IsInside(coordinate);
		boolean isInsideSubTriangle3=new Triangle(this.GetID(), this.GetColor(),this.point2,this.point3,
				middlePoint).IsInside(coordinate);
		boolean isInsideSubTriangle4=new Triangle(this.GetID(), this.GetColor(),this.point3,this.point4,
				middlePoint).IsInside(coordinate);
		
		if (isInsideSubTriangle1 || isInsideSubTriangle2 || isInsideSubTriangle3 || isInsideSubTriangle4){
		 return true;
		}
		else{
			return false;
		}
		
	}
		
	
}
