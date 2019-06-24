package futureman.sandwich.toppings.types;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.Topping;

public abstract class Vegetable extends Topping{

	public Vegetable(Sandwich sandwich) {
		super(sandwich);
	}

}
