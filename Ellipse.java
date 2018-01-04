
public class Ellipse extends Shape {
	private Point focus1;
	private Point focus2;
	private double D;
	
	public Ellipse(int ID, String color, Point focus1, Point focus2, double D){
		super(ID, color);
		this.focus1=focus1;
		this.focus2=focus2;
		this.D=D;
	}
	
	private double aSubAxisCalculation(){
		return this.D/2;
	}
	
	private double bSubAxisCalculation(){
		double distanceBetweenFocusPoints=Point.GetDistanceBetweenTwoPoints(this.focus1, this.focus2);
		return(Math.sqrt(Math.pow(this.D/2, 2)-Math.pow(distanceBetweenFocusPoints/2, 2)));
	}
	
	public double GetCircleRadius(){
		return this.D/2;
	}
	
	public double AreaCalculation(){
		double aSubAxis=aSubAxisCalculation();
		double bSubAxis=bSubAxisCalculation();
		return (aSubAxis*bSubAxis*Math.PI);	
	}
	
	public double CircumferenceCalculation(){
		double aSubAxis=aSubAxisCalculation();
		double bSubAxis=bSubAxisCalculation();
		return (Math.PI*(aSubAxis+bSubAxis)-Math.sqrt(10*aSubAxis*bSubAxis+3*(Math.pow(aSubAxis, 2)+Math.pow(bSubAxis, 2))));
	}
	
	public void Move(double xUnitsToMove, double yUnitsToMove){
		this.focus1.SetX(this.focus1.GetX()+xUnitsToMove);
		this.focus1.SetY(this.focus1.GetY()+yUnitsToMove);
		this.focus2.SetX(this.focus2.GetX()+xUnitsToMove);
		this.focus2.SetY(this.focus2.GetY()+yUnitsToMove);
	}
	
	public boolean IsInside(Point coordinate){
		double coordinateToFocus1Didtance=Point.GetDistanceBetweenTwoPoints(coordinate, this.focus1);
		double coordinateToFocus2Didtance=Point.GetDistanceBetweenTwoPoints(coordinate, this.focus2);
		if (coordinateToFocus1Didtance+coordinateToFocus2Didtance<=this.D){
			return true;
		}
		else{
			return false;
		}
	}
}

