package prototype;

import java.util.Hashtable;
abstract class Shape implements Cloneable {

	private String id;
	protected String type;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	protected Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	abstract void draw();
}

class Circle extends Shape {
	public Circle() {
		type = "Circle";
	}

	@Override
	void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
class Rectangle extends Shape {
	public Rectangle() {
		type = "Rectangle";
	}
	
	@Override
	void draw() {
	System.out.println("Inside Rectangle::draw() method.");
		
	}
}

class Square extends Shape {
	public Square() {
		type = "Square";
	}

	@Override
	void draw() {
		System.out.println("Inside Square::draw() method.");

	}
}

class ShapeCache {
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape shape = shapeMap.get(shapeId);
		return (Shape) shape.clone();
	}

	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("2");
		shapeMap.put(rectangle.getId(), rectangle);

		Square square = new Square();
		square.setId("3");
		shapeMap.put(square.getId(), square);

		System.out.println("Cache:" + shapeMap);
	}
}
public class App {

	public static void main(String args[]) {
		ShapeCache.loadCache();
		
		Shape cloneShape = ShapeCache.getShape("1");
		System.out.println("Shape type: " + cloneShape);
				
		cloneShape = ShapeCache.getShape("2");
		System.out.println("Shape type: " + cloneShape);
		
		cloneShape = ShapeCache.getShape("3");
		System.out.println("Shape type: " + cloneShape);
	}
}
