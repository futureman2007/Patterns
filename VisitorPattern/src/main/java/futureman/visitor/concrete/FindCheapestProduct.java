package futureman.visitor.concrete;

import java.util.List;

import futureman.visitable.concrete.*;
import futureman.visitable.concrete.Package;
import futureman.visitor.Visitor;

public class FindCheapestProduct implements Visitor {

	private static FindCheapestProduct _cheapestItemFinder = null;
	private static Product _cheapestItem= null;
	
	
	private FindCheapestProduct() {}
	
	@Override
	public void visit(futureman.visitable.concrete.Package pack) {
		
		if(pack == null) {
			throw new NullPointerException("Cannot opperate with null referenze!");
		}
		
		Product cheapest = null;
		Product current = null;
		List<Product> pList = pack.get_products();
		
		cheapest = pList.get(0);
		
		for(int i = 0; i < pList.size(); i++) {
			current = pList.get(i);
			if(current.get_price() < cheapest.get_price()) {
				cheapest = current;
			}
		}
		_cheapestItem = cheapest;
		
	}

	@Override
	public void visit(Item item) {
		// TODO Auto-generated method stub
		
	}
	public static FindCheapestProduct getInstance() {
		if(_cheapestItemFinder == null) {
			_cheapestItemFinder = new FindCheapestProduct();
		}
		return _cheapestItemFinder;
	}
	
	public static Product get_cheapestProduct(){
		return _cheapestItem;
	}

	
}
