package futureman.sandwich.toppings.types.vegetables;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Vegetable;

public class Pineapple extends Vegetable{

	public Pineapple(Sandwich sandwich) {
		super(sandwich);
		_name = "Pineapple";
		_cost = 0.15;
	}

}
