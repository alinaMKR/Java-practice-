
//create a class that implements Comparable Interface 
public class Rectangle implements Comparable<Rectangle>{
	private float length;
	private float width;
	private float area;
	
	// non-arg constructor
	public Rectangle(){
	}
	
	// Construct a rectangle
	public Rectangle(float length, float width){
		this.length = length;
		this.width = width;
		this.area = length*width;
	}
		
	//getter for length
	float getLength() {
		return length;
	}
		
	//setter for length
	void setLength(float length) {
		this.length = length;
	}
	
	//getter for height
	float getWidth() {
		return width;
		}
			
	//setter for height
	void setWidth(float width) {
		this.width = width;
	}
	
	//String method
	public String toString() {
		return "Length: " + String.format("%.2f", this.length)+ " cm, Width: " +
				String.format("%.2f", this.width) + " cm, Area: " + String.format("%.2f", this.area)
				+ "cm"; // show up to 2 decimal points 
	}
	
	// use compareTo method to sort rectangles by areas 
	public int compareTo(Rectangle o) {
		return (int)(this.area-o.area);
	}
		
	}


