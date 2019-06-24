package futureman.pizzastore;

import futureman.pizza.types.CalzonePizza;
import futureman.pizza.types.CheesePizza;
import futureman.pizza.types.PepperoniPizza;
import futureman.pizzabaecker.PizzaBaecker;
import futureman.pizzabaecker.alberto.PizzaAlbertoBaecker;
import futureman.pizzabaecker.makkaroni.PizzeriaMakkaroniBaecker;
import futureman.pizzabaecker.makkaroni.PizzeriaMakkaroniCheesePizza;

public class PizzaOnlineStoreTest {
	
	public static void main(String [] args) {
		PizzaOnlineStore storeMak = new PizzaOnlineStore(new PizzeriaMakkaroniBaecker());
		PizzaOnlineStore storeAlb = new PizzaOnlineStore(new PizzaAlbertoBaecker());
		
		storeMak.order(CheesePizza.class);
		storeAlb.order(CalzonePizza.class);
		storeAlb.order(PepperoniPizza.class);
	}
}
