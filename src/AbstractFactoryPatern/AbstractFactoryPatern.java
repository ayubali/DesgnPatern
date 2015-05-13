package AbstractFactoryPatern;

enum ShapeType {
	CIRCLE, RECTANGLE, SQUARE
}

enum ColorType {
	RED, GREEN, BLUE
}

enum FactorType {
	SHAPE, COLOR
}

interface Shape {
	void draw();
}

interface Color {
	void fill();
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

class Red implements Color {
	@Override
	public void fill() {
		System.out.println("fill color in RED");
	}
}

class Blue implements Color {
	@Override
	public void fill() {
		System.out.println("fill color in Blue");
	}
}

class Green implements Color {
	@Override
	public void fill() {
		System.out.println("fill color in Green");
	}
}

abstract class AbstractFactory {
	public abstract Shape getShape(ShapeType type);

	public abstract Color getColor(ColorType type);
}

class ShapeFactory extends AbstractFactory {
	@Override
	public Shape getShape(ShapeType type) {
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

	@Override
	public Color getColor(ColorType type) {
		return null;
	}
}

class Colorfactory extends AbstractFactory {
	@Override
	public Color getColor(ColorType type) {
		Color color = null;
		switch (type) {
		case RED:
			color = new Red();
			break;
		case GREEN:
			color = new Green();
			break;
		case BLUE:
			color = new Blue();
			break;
		default:
			break;

		}
		return color;
	}

	@Override
	public Shape getShape(ShapeType type) {
		return null;
	}
}

class FactoryPorducer {

	public static AbstractFactory getFactoryPaterb(FactorType type) {
		AbstractFactory factory = null;
		switch (type) {
		case SHAPE:
			factory = new ShapeFactory();
			break;

		case COLOR:
			factory = new Colorfactory();
			break;
		default:
			break;
		}

		return factory;
	}

}

public class AbstractFactoryPatern {

	public static void main(String[] args) {

		AbstractFactory shapeFactory = FactoryPorducer
				.getFactoryPaterb(FactorType.SHAPE);
		Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
		circle.draw();
		Shape rectangle = shapeFactory.getShape(ShapeType.RECTANGLE);
		rectangle.draw();
		Shape square = shapeFactory.getShape(ShapeType.SQUARE);
		square.draw();

		AbstractFactory colorFactor = FactoryPorducer
				.getFactoryPaterb(FactorType.COLOR);
		Color red = colorFactor.getColor(ColorType.RED);
		red.fill();
		Color green = colorFactor.getColor(ColorType.GREEN);
		green.fill();
		Color blue = colorFactor.getColor(ColorType.BLUE);
		blue.fill();

	}

}
