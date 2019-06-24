package futureman.sandwich.toppings.types;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.Topping;

public abstract class Spread extends Topping{
	
	public Spread(Sandwich sandwich) {
		super(sandwich);
	}
}
