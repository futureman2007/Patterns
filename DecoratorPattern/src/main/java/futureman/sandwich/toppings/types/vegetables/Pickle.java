package futureman.sandwich.toppings.types.vegetables;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Vegetable;

public class Pickle extends Vegetable{

	public Pickle(Sandwich sandwich) {
		super(sandwich);
		_name = "Pickles";
		_cost = 0.10;
	}

}
