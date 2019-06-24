package futureman.sandwich.toppings.types.vegetables;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Vegetable;

public class Cocumber extends Vegetable{
	public Cocumber(Sandwich sandwich) {
		super(sandwich);
		_name = "Cocumber";
		_cost = 0.10;
	}
}
