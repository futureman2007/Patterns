package futureman.sandwich.toppings.types.spread;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Spread;

public class Butter extends Spread{
	public Butter(Sandwich sandwich) {
		super(sandwich);
		_name = "Butter";
		_cost = 0.01;
	}
}
