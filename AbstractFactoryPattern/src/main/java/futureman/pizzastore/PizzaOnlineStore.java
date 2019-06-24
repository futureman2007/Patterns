package futureman.pizzastore;

import java.lang.reflect.InvocationTargetException;

import futureman.pizza.Pizza;
import futureman.pizza.types.CheesePizza;
import futureman.pizza.types.PepperoniPizza;
import futureman.pizza.types.VegetarianPizza;
import futureman.pizzabaecker.PizzaBaecker;

public class PizzaOnlineStore {
	
	public PizzaBaecker _pb = null;
	
	public PizzaOnlineStore(PizzaBaecker pb) {
		_pb = pb;
	}
	
	public Pizza order(Class pizza) {
		Pizza pizzaObj = _pb.backePizza(pizza);
		return pizzaObj;
	}
}
