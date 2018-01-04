
public class Triangle extends Shape {
	private Point point1;
	private Point point2;
	private Point point3;
	
	
	public Triangle(int ID, String color, Point point1, Point point2, Point point3){
	super(ID, color);
	this.point1=point1;
	this.point2=point2;
	this.point3=point3;
}
	
	
	public double AreaCalculation(){
		return (0.5*Math.abs((this.point1.GetX()*this.point2.GetY()+this.point1.GetY()*this.point3.GetX()+
				this.point2.GetX()*point3.GetY())-(this.point1.GetY()*this.point2.GetX()+
						this.point1.GetX()*this.point3.GetY()+this.point2.GetY()*this.point3.GetX())));
	}
	
	
	public double CircumferenceCalculation(){
		double lengthSide1=Point.GetDistanceBetweenTwoPoints(this.point2, this.point1);
		double lengthSide2=Point.GetDistanceBetweenTwoPoints(this.point3, this.point1);
		double lengthSide3=Point.GetDistanceBetweenTwoPoints(this.point2, this.point3);
		
		return (lengthSide1+lengthSide2+lengthSide3);
	}
	
	public void Move(double xUnitsToMove, double yUnitsToMove){
		this.point1.SetY(this.point1.GetY()+yUnitsToMove);
		this.point1.SetX(this.point1.GetX()+xUnitsToMove);
		
		this.point2.SetY(this.point2.GetY()+yUnitsToMove);
		this.point2.SetX(this.point2.GetX()+xUnitsToMove);
		
		this.point3.SetY(this.point3.GetY()+yUnitsToMove);
		this.point3.SetX(this.point3.GetX()+xUnitsToMove);
	}
	
	public boolean IsInside(Point coordinate){
		double givenTriangleArea=AreaCalculation();
		
		double subArea1=new Triangle(this.GetID(), this.GetColor(),coordinate,this.point1,this.point2).AreaCalculation();
		double subArea2=new Triangle(this.GetID(), this.GetColor(),coordinate,this.point2,this.point3).AreaCalculation();
		double subArea3=new Triangle(this.GetID(), this.GetColor(),coordinate,this.point1,this.point3).AreaCalculation();
		
		if ((subArea1+subArea2+subArea3)==givenTriangleArea){
			return true;
		}
		else{
			return false;
		}
	}
}
