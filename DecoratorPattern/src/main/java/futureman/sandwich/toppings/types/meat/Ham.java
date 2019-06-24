package futureman.sandwich.toppings.types.meat;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Meat;

public class Ham extends Meat{
	public Ham(Sandwich sandwich) {
		super(sandwich);
		_name = "Ham";
		_cost = 0.75;
	}
}
