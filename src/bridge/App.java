package bridge;

interface DrawAPI {
	public void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: red, radius: " + radius
				+ ", x: " + x + ", " + y + "]");
	}
}

class GreenCircle implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: " + radius
				+ ", x: " + x + ", " + y + "]");
	}
}

abstract class Shape {
	protected DrawAPI drawAPI;

	public Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	abstract void draw();
}

class Circle extends Shape {
	private int x, y, radius;

	public Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	void draw() {
		drawAPI.drawCircle(radius, x, y);
	}
}

public class App {

	public static void main(String[] args) {
		Circle greenCircle = new Circle(1150, 200, 100, new GreenCircle());
		Circle redCircle = new Circle(1150, 200, 100, new RedCircle());
		greenCircle.draw();
		redCircle.draw();
	}

}
