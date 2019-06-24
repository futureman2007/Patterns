package futureman.sandwich.toppings.types;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.Topping;

public abstract class Bread extends Topping {

	public Bread(Sandwich sandwich) {
		super(sandwich);
	}

}
