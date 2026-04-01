public class Circle {
	
	// Class variables
	double radius;
	
	// Constructor
	Circle(double radius){
		this.radius=radius;
	}
	
	// Method to find area of circle
	public void areaCircle() {
		System.out.printf("Area of circle: %.4f",(Math.PI*radius*radius));
	}
	
	// Method to find the circumference of circle
	public void circumferenceCircle() {
		System.out.printf("\nCircumference of circle: %.4f ",(2*Math.PI*radius));
	}
	
	public static void main(String[] args) {

		// Object created
	    Circle circle = new Circle(2.5);
	
		// Methods called
	    circle.areaCircle();
	    circle.circumferenceCircle();
	
    }
}
