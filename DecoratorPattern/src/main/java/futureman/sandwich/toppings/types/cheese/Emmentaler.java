package futureman.sandwich.toppings.types.cheese;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Cheese;

public class Emmentaler extends Cheese{
	public Emmentaler(Sandwich sandwich) {
		super(sandwich);
		_name = "Emmentaler";
		_cost = 0.45;
	}
}
