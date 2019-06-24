package futureman.sandwich.toppings.types.cheese;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Cheese;

public class Cheddar extends Cheese{
	
	public Cheddar(Sandwich sandwich) {
		super(sandwich);
		_name = "Cheddar";
		_cost = 0.45;
	}
}
