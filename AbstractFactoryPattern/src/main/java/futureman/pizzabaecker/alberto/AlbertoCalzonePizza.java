package futureman.pizzabaecker.alberto;

import futureman.pizza.types.CalzonePizza;

public class AlbertoCalzonePizza extends CalzonePizza {

	@Override
	public void prepare() {
		System.out.println("Preparing Pizza! Takes about 5 minutes...");
		_zutaten.add("AlbertoPizzaboden");
		_zutaten.add("Tomaten-Souce");
		_zutaten.add("PFeffer");
		_zutaten.add("Salz");
		_zutaten.add("Curry");
		_zutaten.add("Knoblauch");
		_zutaten.add("Gauda");
		_zutaten.add("Emmentaler");
		_zutaten.add("Cheddar");
		_zutaten.add("Salami");
		_zutaten.add("Pepperoni");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Got Interrupted while preparing ¯\\_(ツ)_/¯. You can afterwars but the rest on it. ");
			return;
		}
		System.out.println("Preperation Done!");
	}
	@Override
	public void bake() {
		System.out.println("Backing... This will take 30 Minutes @ 350°C ! ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Got Interrupted while backing ¯\\_(ツ)_/¯. I wouldn´t try to eat it if i where you... ");
			return;
		}
		System.out.println("Backing Completed!");
	}

	@Override
	public void cut() {
		System.out.println("Cutting CalzonePizza ala Alberto! This may take a while");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("The Phone ¯\\_(ツ)_/¯. You can finish it at home anyway... ");
			return;
		}
		System.out.println("Done!");
		
	}

	@Override
	public void box() {
		System.out.println("Boxing Pizza! This may take a few Sekonds");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.err.println("Well... idk what happened ¯\\_(ツ)_/¯. At the end u will throw the box away, so why bother? ");
			return;
		}
		System.out.println("Done!");
		
	}

}
