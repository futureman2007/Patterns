package futureman.sandwich.types;

import futureman.sandwich.Sandwich;
import futureman.sandwich.toppings.Topping;
import futureman.sandwich.toppings.types.Bread;
import futureman.sandwich.toppings.types.bread.Toast;
import futureman.sandwich.toppings.types.meat.Turkey;
import futureman.sandwich.toppings.types.vegetables.Pineapple;;

public class SandwichHawai implements Sandwich {

	@Override
	public String topping() {
		return "HawaiToast";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0.50;
	}
}
