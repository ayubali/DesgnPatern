package factorypatern;
enum ShapeType {
	CIRCLE, RECTANGLE, SQUARE
}

interface Shape {
	void draw();
}

class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("draw in Circle.");
	}
}

class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("draw in Rectangle");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("draw in Square.");
	}
}

class FactorShape {

	public static Shape getShape(ShapeType type) {
		Shape shape = null;
		switch (type) {
		case CIRCLE:
			shape = new Circle();
			break;
		case RECTANGLE:
			shape = new Rectangle();
			break;
		case SQUARE:
			shape = new Square();
			break;
		default:
			break;
		}

		return shape;
	}

}

public class FactoryPatern {

	public static void main(String[] args) {
		Shape circle = FactorShape.getShape(ShapeType.CIRCLE);
		circle.draw();
		Shape rectangle = FactorShape.getShape(ShapeType.RECTANGLE);
		rectangle.draw();
		Shape square = FactorShape.getShape(ShapeType.SQUARE);
		square.draw();
	}

}
