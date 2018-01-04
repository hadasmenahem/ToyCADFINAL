import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays; 

public class ToyCAD {
	static final int DATA_LOCATION=3;
	
	private static int ID_Counter;
	
	private static void PrintCurrentID(){
		System.out.println(ID_Counter);
	}
	
	private static void CopyShapeWithDifferentCoordinates(ArrayList<Shape> shapesArray, String[] splitInputLine){
		shapesArray.add(shapesArray.get(Integer.parseInt(splitInputLine[1])));
		shapesArray.get(ID_Counter).Move(Double.parseDouble(splitInputLine[2]),Double.parseDouble(splitInputLine[3]));
		ID_Counter++;
	}
	
	private static void CalculateComulativeColorCircumference(ArrayList<Shape> shapesArray, String[] splitInputLine){
		String colorToCalculateCircumferenceFor=splitInputLine[1];
		double comulativeCircumference=0.0;
		for (int i=0; i<shapesArray.size(); i++){
			if (shapesArray.get(i)!=null){
				if (shapesArray.get(i).GetColor().equalsIgnoreCase(colorToCalculateCircumferenceFor)){
					comulativeCircumference+=shapesArray.get(i).CircumferenceCalculation();
				}
			}
		}
		System.out.println(String.format("%.2f", comulativeCircumference));
	}
	
	private static void ChangeShapeColor(ArrayList<Shape> shapesArray, String[] splitInputLine){
		shapesArray.get(Integer.parseInt(splitInputLine[2])).SetNewColor(splitInputLine[1]);
	}
	
	private static void CalculateComulativeColorArea(ArrayList<Shape> shapesArray, String[] splitInputLine){
		String colorToCalculateAreaFor=splitInputLine[1];
		double comulativeArea=0.0;
		for (int i=0; i<shapesArray.size(); i++){
			if (shapesArray.get(i)!=null){
				if (shapesArray.get(i).GetColor().equalsIgnoreCase(colorToCalculateAreaFor)){
					comulativeArea+=shapesArray.get(i).AreaCalculation();
				}
			}
		}
		System.out.println(String.format("%.2f", comulativeArea));
	}
	
	private static void ConvertStringArrayToDoubleArray(String[] arrayString, double[] arrayDouble){
		for (int i=0; i<arrayString.length; i++){
			arrayDouble[i]=Double.parseDouble(arrayString[i]);
		}
	}
	private static void MoveShapeCoordinates(ArrayList<Shape> shapesArray, String[] splitInputLine){
		shapesArray.get(Integer.parseInt(splitInputLine[1])).Move(Double.parseDouble(splitInputLine[2]),
				Double.parseDouble(splitInputLine[3]));
	}
	private static void RemoveShapeFromShapesArray(ArrayList<Shape> shapesArray, int ID){
		shapesArray.remove(ID);
	}
	
	private static void IsCoordinateInsideShape(ArrayList<Shape> shapesArray, String[] splitInputLine){
		if (shapesArray.get(Integer.parseInt(splitInputLine[1])).IsInside(new Point(Double.parseDouble(splitInputLine[2]), Double.parseDouble(splitInputLine[3])))){
			System.out.println("1");
		}
		else{
				System.out.println("0");
		}
	}
	
	private static void AddNewShapeToShapesArray(ArrayList<Shape> shapesArray, String[] splitInputLine){
		String shapeType=splitInputLine[1];
		String color=splitInputLine[2];
		String[] dataInStringType=Arrays.copyOfRange(splitInputLine, DATA_LOCATION, splitInputLine.length);
		double[] dataInDoubleType=new double[dataInStringType.length];
		ConvertStringArrayToDoubleArray(dataInStringType, dataInDoubleType);
		
		switch(shapeType.toLowerCase()){
		
		case "circle":
			shapesArray.add(new Circle(ID_Counter, color, new Point(dataInDoubleType[0], dataInDoubleType[1]), dataInDoubleType[2]));
			break;
		
		case "ellipse":
			shapesArray.add(new Ellipse(ID_Counter, color,new Point(dataInDoubleType[0], dataInDoubleType[1]),new Point(dataInDoubleType[2], dataInDoubleType[3]), dataInDoubleType[4]));
			break;
			
		case "parallelogram":
			shapesArray.add(new Parallelogram(ID_Counter, color,new Point(dataInDoubleType[0], dataInDoubleType[1]),new Point(dataInDoubleType[2], dataInDoubleType[3]), new Point(dataInDoubleType[4], dataInDoubleType[5])));
			break;
			
		case "rectangle":
			shapesArray.add(new Rectangle(ID_Counter, color, new Point(dataInDoubleType[0], dataInDoubleType[1]), new Point(dataInDoubleType[2],dataInDoubleType[3])));
			break;
			
		case "square":
			shapesArray.add(new Square(ID_Counter, color,new Point(dataInDoubleType[0],dataInDoubleType[1]),dataInDoubleType[2]));
			break;
			
		case "triangle":
			shapesArray.add(new Triangle(ID_Counter, color, new Point(dataInDoubleType[0],dataInDoubleType[1]), new Point(dataInDoubleType[2],dataInDoubleType[3]), new Point(dataInDoubleType[4], dataInDoubleType[5])));
			break;
			
		}
		
		PrintCurrentID();
		ID_Counter++;
	}
	
	private static void SendCommandsToExecution(String[] splitInputLine, ArrayList<Shape> shapesArray){
		String commandType=splitInputLine[0];
		
		switch(commandType.toLowerCase()){
		
		case "new":
			AddNewShapeToShapesArray(shapesArray, splitInputLine);
			break;
			
		case "delete":
			RemoveShapeFromShapesArray(shapesArray, Integer.parseInt(splitInputLine[1]));
			break;
			
		case "move":
			MoveShapeCoordinates(shapesArray, splitInputLine);
			break;
			
		case "copy":
			CopyShapeWithDifferentCoordinates(shapesArray, splitInputLine);
			break;
			
		case "area":
			CalculateComulativeColorArea(shapesArray, splitInputLine);
			break;
			
		case "color":
			ChangeShapeColor(shapesArray, splitInputLine);
			break;
			
		case "circumference":
			CalculateComulativeColorCircumference(shapesArray, splitInputLine);
			break;
			
		case "is_inside":
			IsCoordinateInsideShape(shapesArray, splitInputLine);
			break;
			
		}
	}
	
	public static void main(String[] args){
		ID_Counter=0;
		String inputLine=null;
		String[] splitInputLine;
		Scanner input=new Scanner(System.in);
		ArrayList<Shape> shapesArray=new ArrayList<Shape>();
		
		do{
			inputLine=input.nextLine();
			splitInputLine=inputLine.split(" ");
			SendCommandsToExecution(splitInputLine, shapesArray);
		}
		while (!inputLine.equalsIgnoreCase("exit"));
			
		input.close();
		
	}
}
