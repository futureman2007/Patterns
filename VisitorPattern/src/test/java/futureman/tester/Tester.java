package futureman.tester;
import java.util.List;

import futureman.visitable.concrete.items.CannedItem;
import futureman.visitable.concrete.items.FreshVegetable;
import futureman.visitor.concrete.*;

public class Tester {

	public static void main(String[] args) {
		
		futureman.visitable.concrete.Package pack = new futureman.visitable.concrete.Package();
		
		FindCheapestProduct cheapest = FindCheapestProduct.getInstance();
		ReduceAllItemPrices reduce = ReduceAllItemPrices.getInstance();
		
		pack.set_products(List.of(
				new CannedItem(1.20, true),
				new CannedItem(3.20, true),
				new FreshVegetable(2.12),
				new FreshVegetable(2.13),
				new FreshVegetable(0.25),
				new CannedItem(2.49, false),
				new futureman.visitable.concrete.Package(
						List.of(new CannedItem(0.25, false),
								new CannedItem(0.20,true),
								new CannedItem(0.10,true),
								new CannedItem(0.70, false)
								))
				));
		System.out.println("Package before any Opperation:");
		System.out.println(pack.toString());
		System.out.println("Searching cheapest item:");
		pack.accept(cheapest);
		System.out.println(cheapest.get_cheapestProduct().toString());
		System.out.println("Reducing all prices with: 0.20€ ");
		reduce.set_reductionAmountOfCosts(0.20);
		pack.accept(reduce);
		System.out.println("After Reduction:");
		System.out.println(pack.toString());
				
	}
	
}
