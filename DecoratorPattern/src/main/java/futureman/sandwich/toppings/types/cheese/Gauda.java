package futureman.sandwich.toppings.types.cheese;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Cheese;

public class Gauda extends Cheese {

	public Gauda(Sandwich sandwich) {
		super(sandwich);
		_name = "Gauda";
		_cost = 0.40;
	}
}
