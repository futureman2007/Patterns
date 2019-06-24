package futureman.visitor.concrete;

import java.util.List;

import futureman.visitable.concrete.Item;
import futureman.visitable.concrete.Package;
import futureman.visitable.concrete.Product;
import futureman.visitor.Visitor;

public class ReduceAllItemPrices implements Visitor {

	private static ReduceAllItemPrices _instance = null;
	private double _reductionAmountOfCosts = 0.0;
	
	private ReduceAllItemPrices() {}
	
	@Override
	public void visit(futureman.visitable.concrete.Package pack) {
		if(pack == null) {
			throw new NullPointerException("Cannot opperate with null referenze!");
		}
		
		List<Product> pList = pack.get_products();
		
		
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i) instanceof Item) {
				pList.get(i).accept(this);
			}
			if(pList.get(i) instanceof futureman.visitable.concrete.Package) {
				pList.get(i).accept(this);
			}
		}
		calculateNewPrice(pack);
		
	}

	@Override
	public void visit(Item item) {
		
		if(item == null) {
			throw new NullPointerException();
		}
		double reduction = getInstance()._reductionAmountOfCosts;
		
		item.set_price(item.get_price() - reduction );	
	}
	
	public static ReduceAllItemPrices getInstance() {
		if(_instance == null) {
			_instance = new ReduceAllItemPrices();	
		}
		return _instance;
	}
	public void set_reductionAmountOfCosts(double amount) {
		_reductionAmountOfCosts = amount;
	}
	public double get_reductionAmountOfCosts() {
		return _instance._reductionAmountOfCosts;
	}
	
	protected void calculateNewPrice(Package pack) {
		
		if(pack == null) {
			throw new NullPointerException();
		}
		if(pack.get_products() == null) {
			pack.set_price(0.0);
			return;
		}
		List<Product> pList = pack.get_products();
		double newPrice = 0.0;
		pack.set_price(0.0);
		
		for(int i = 0; i < pList.size(); i++) {
			newPrice += pList.get(i).get_price();
		}
		pack.set_price(newPrice);
		
	}

}
