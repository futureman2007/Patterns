package futureman.sandwich.toppings.types;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.Topping;

public abstract class Cheese extends Topping{
	
	public Cheese(Sandwich sandwich) {
		super(sandwich);
	}
}
