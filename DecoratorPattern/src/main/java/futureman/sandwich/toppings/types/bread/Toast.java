package futureman.sandwich.toppings.types.bread;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Bread;

public class Toast extends Bread {

	public Toast(Sandwich sandwich) {
		super(sandwich);
		_name = "Toast";
		_cost = 0.20;
	}

	
}
