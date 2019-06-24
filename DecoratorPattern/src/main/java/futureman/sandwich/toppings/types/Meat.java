package futureman.sandwich.toppings.types;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.Topping;

public abstract class Meat extends Topping{
	
	public Meat(Sandwich sandwich) {
		super(sandwich);
	}
}
