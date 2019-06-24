package futureman.sandwich.toppings.types.meat;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Meat;

public class Salami extends Meat{

	public Salami(Sandwich sandwich) {
		super(sandwich);
		_name = "Salami";
		_cost = 0.50;
	}
	
}
