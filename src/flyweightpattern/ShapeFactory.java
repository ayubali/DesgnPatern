package flyweightpattern;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

	private static Map<String, Shape> circleMap = new HashMap<String, Shape>();

	public static Shape getCircle(String color) {
		Shape shape = circleMap.get(color);
		if (shape == null) {
			shape = new Circle(color);
			circleMap.put(color, shape);
			System.out.println("Creating circle of color : " + color);
		}
		return shape;
	}
}
