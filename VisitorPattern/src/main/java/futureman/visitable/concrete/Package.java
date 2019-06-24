package futureman.visitable.concrete;

import java.util.List;

import futureman.visitor.Visitor;

public class Package extends Product{

	protected List<Product> _products;

	public Package(List<Product> list) {
		super(0.0);
		_products = list;
		calculatePrice();
		
	}
	public Package() {
		super(0.0);
	}
	
	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}
	
	public void addProduct(Product prod) {
		if(prod == null) {
			return;
		}
		if(_products == null) {
			throw new NullPointerException();
		}
		_products.add(prod);
		_price += prod.get_price();
	}
	
	public void removeProduct(Product prod) {
		for(int i = 0; i < _products.size(); i++) {
			if(prod._ID == _products.get(i)._ID) {
				_products.remove(i);
				_price -= _products.get(i).get_price();
				break;
			}
		}
	}
	
	public void set_products(List<Product> list) {
		_products = list;
		calculatePrice();
	}
	
	public List<Product> get_products(){
		return _products;
	}
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("Package:\n");
		buff.append("   ID: " + _ID);
		buff.append(" price: " + _price + "\n");
		buff.append("   products:\n ");
		for(int i = 0; i < _products.size(); i++) {
			buff.append("      " + _products.get(i).toString());
			buff.append("\n");
		}
		return buff.toString();
	}
	
	protected void calculatePrice() {
		if(_products == null) {
			_price = 0.0;
		}
		_price = 0.0;
		for(int i = 0; i < _products.size(); i++) {
			_price += _products.get(i)._price;
		}
		
	}
	
	
}
