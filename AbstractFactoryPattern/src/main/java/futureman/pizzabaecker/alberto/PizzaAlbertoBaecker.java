package futureman.pizzabaecker.alberto;

import java.lang.reflect.InvocationTargetException;

import futureman.pizza.Pizza;
import futureman.pizza.types.CalzonePizza;
import futureman.pizza.types.CheesePizza;
import futureman.pizza.types.PepperoniPizza;
import futureman.pizza.types.VegetarianPizza;
import futureman.pizzabaecker.PizzaBaecker;
import futureman.pizzabaecker.makkaroni.PizzeriaMakkaroniCalzonePizza;
import futureman.pizzabaecker.makkaroni.PizzeriaMakkaroniCheesePizza;
import futureman.pizzabaecker.makkaroni.PizzeriaMakkaroniPepperoniPizza;
import futureman.pizzabaecker.makkaroni.PizzeriaMakkaroniVegetarianPizza;

public class PizzaAlbertoBaecker implements PizzaBaecker {

	@Override
	public Pizza backePizza(Class pizza) {
		System.out.println("=== PIZZERIA ALBERTO! ===\n");
		System.out.println("YOU ORDERD A " + pizza.getSimpleName());
		Pizza pizzaObj = null;
		if(pizza.isAssignableFrom(CheesePizza.class)) {
			pizzaObj = new AlbertoCheesePizza();
		}
		if(pizza.isAssignableFrom(CalzonePizza.class)) {
			pizzaObj = new AlbertoCalzonePizza();
		}
		if(pizza.isAssignableFrom(PepperoniPizza.class)) {
			pizzaObj = new AlbertoPepperoniPizza();
		}
		if(pizza.isAssignableFrom(VegetarianPizza.class)) {
			pizzaObj = new AlbertoVegetarianPizza();
		}
		

		pizzaObj.prepare();
		pizzaObj.bake();
		pizzaObj.box();
		pizzaObj.box();
		
		return pizzaObj;
	}

}
