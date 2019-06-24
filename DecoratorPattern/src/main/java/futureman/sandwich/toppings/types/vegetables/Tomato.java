package futureman.sandwich.toppings.types.vegetables;
import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.types.Vegetable;

public class Tomato extends Vegetable{

	public Tomato(Sandwich sandwich) {
		super(sandwich);
		_name = "Tomato";
		_cost = 0.10;
	}

}
