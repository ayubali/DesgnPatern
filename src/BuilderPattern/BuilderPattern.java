package builderpattern;

import java.util.ArrayList;
import java.util.List;

interface Packing {
	public String pack();
}

interface Item {
	public String name();

	public Packing packing();

	public float price();
}

class Wrapper implements Packing {
	@Override
	public String pack() {
		return "Wrapper";
	}
}

class Bottle implements Packing {
	@Override
	public String pack() {
		return "Bottle";
	}
}

abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}
}

abstract class ColdDrink implements Item {
	@Override
	public Packing packing() {
		return new Bottle();
	}
}

class VegBurger extends Burger {
	@Override
	public String name() {
		return "VegBurger";
	}

	@Override
	public float price() {
		return 50.0f;
	}
}

class ChickenBurger extends Burger {
	@Override
	public String name() {
		return "ChickenBurger";
	}

	@Override
	public float price() {
		return 70.0f;
	}
}

class Coke extends ColdDrink {
	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 70.8f;
	}
}

class Pepsi extends ColdDrink {
	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 78.12f;
	}

}

class Meal{
	private List<Item> items = new ArrayList<Item>();
	
	public void add(Item item) {
		items.add(item);
	}
	
	public float getCost() {
		float cost =0.0f;
		
		for (Item item : items) {
			cost +=item.price();
		}
		return cost;
	}
	
	public void showItems(){
		for (Item item : items) {
			System.out.println("Item: "+ item.name());
			System.out.println("Packing: "+ item.packing().pack());
			System.out.println("Price: "+ item.price());
		}
	}
}

class MealBuilder{
	
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.add(new VegBurger());
		meal.add(new Coke());
		return meal;
	}
	
	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.add(new ChickenBurger());
		meal.add(new Pepsi());
		return meal;
	}
	
}

public class BuilderPattern {
	public static void main(String[] args) {

		MealBuilder builder = new MealBuilder();
		Meal meal = builder.prepareNonVegMeal();
		System.out.println("Mon-Veg Meal: ");
		meal.showItems();
		System.out.println("Total cost: "+ meal.getCost());
		System.out.println("........................................");
		Meal meal1 = builder.prepareVegMeal();
		System.out.println("Veg Meal: ");
		meal1.showItems();
		System.out.println("Total cost: "+ meal1.getCost());
		
	}

}
