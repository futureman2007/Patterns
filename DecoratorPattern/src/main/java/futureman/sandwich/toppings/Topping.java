package futureman.sandwich.toppings;

import futureman.sandwich.Sandwich;

public abstract class Topping implements Sandwich  {

	protected Sandwich _sandwich;
	
	protected String _name;
	protected double _cost;
	
	public Topping(Sandwich sandwich) {
		_sandwich = sandwich;
	}
	public String topping() {
		return _sandwich.topping() + " " + _name;
	}
	
	public double getCost() {
		return _sandwich.getCost() + _cost;
	}
	
}
