package futureman.pizzabaecker.makkaroni;

import java.lang.reflect.InvocationTargetException;

import futureman.pizza.Pizza;
import futureman.pizza.types.CalzonePizza;
import futureman.pizza.types.CheesePizza;
import futureman.pizza.types.PepperoniPizza;
import futureman.pizza.types.VegetarianPizza;
import futureman.pizzabaecker.PizzaBaecker;

public class PizzeriaMakkaroniBaecker implements PizzaBaecker{

	@Override
	public Pizza backePizza(Class pizza) {
		System.out.println("=== PIZZERIA MAKKARONI ===\n");
		System.out.println("Your order " + pizza.getSimpleName() + " will be delivered soon!");
		Pizza pizzaObj = null;
		if(pizza.isAssignableFrom(CheesePizza.class)) {
			pizzaObj = new PizzeriaMakkaroniCheesePizza();
		}
		if(pizza.isAssignableFrom(CalzonePizza.class)) {
			pizzaObj = new PizzeriaMakkaroniCalzonePizza();
		}
		if(pizza.isAssignableFrom(PepperoniPizza.class)) {
			pizzaObj = new PizzeriaMakkaroniPepperoniPizza();
		}
		if(pizza.isAssignableFrom(VegetarianPizza.class)) {
			pizzaObj = new PizzeriaMakkaroniVegetarianPizza();
		}
		
		pizzaObj.prepare();
		pizzaObj.bake();
		pizzaObj.box();
		pizzaObj.box();
		
		return pizzaObj;
	}

}
