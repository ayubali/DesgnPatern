package decoratorpattern;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape = null;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		decoratedShape.draw();

	}
}
