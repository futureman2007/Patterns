package futureman.visitable.concrete;

import futureman.visitable.Visitable;
import futureman.visitor.Visitor;

public abstract class Product implements Visitable {

	private static long ID_generator = 0;
	
	protected double _price; 
	protected final long _ID;
	

	
	public Product(double price) {
		ID_generator++;
		_ID = ID_generator;
		_price = price;
		checkAttributes();
	}
	

	
	public abstract void accept(Visitor vis);

	public double get_price() {
		return _price;
	}
	
	public long get_ID() {
		return _ID;
	}
	
	public void set_price(double price) {
		_price = price;
		try {
			checkAttributes();
		} catch (IllegalArgumentException iae) {
			_price = 0.0;
		}
	}
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("ID: " + _ID);
		buff.append(" Price: " + _price);
		return buff.toString();
	}
	
	protected void checkAttributes() {
		if(_price < 0) {
			throw new IllegalArgumentException("Price cannot be under 0!");
		}
		
	}
}
