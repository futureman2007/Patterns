package futureman.sandwich;

import futureman.sandwich.toppings.types.cheese.Cheddar;
import futureman.sandwich.toppings.types.cheese.Gauda;
import futureman.sandwich.toppings.types.meat.Turkey;
import futureman.sandwich.toppings.types.spread.Butter;
import futureman.sandwich.toppings.types.vegetables.Pineapple;
import futureman.sandwich.types.SandwichHawai;

public class SandwichTester {
	public static void main(String[] args) {
		Sandwich sandwich = new Pineapple(new Turkey(new SandwichHawai()));
		System.out.println(sandwich.topping());
		System.out.println("Cost: " + sandwich.getCost());
		
		sandwich = new Cheddar(sandwich);
		sandwich = new Butter(sandwich);
		
		System.out.println(sandwich.topping());
		System.out.println("Cost: " + sandwich.getCost());
		
	}
}
