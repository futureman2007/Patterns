package futureman.sandwich.toppings.types.bread;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Bread;

public class Granary extends Bread{

	public Granary(Sandwich sandwich) {
		super(sandwich);
		_name = "Granary";
		_cost = 0.35;
	}
}
