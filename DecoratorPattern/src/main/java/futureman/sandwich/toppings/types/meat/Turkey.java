package futureman.sandwich.toppings.types.meat;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Meat;

public class Turkey extends Meat {
	
	public Turkey(Sandwich sandwich) {
		super(sandwich);
		_name="Turkey";
		_cost=1.0;
	}
}
