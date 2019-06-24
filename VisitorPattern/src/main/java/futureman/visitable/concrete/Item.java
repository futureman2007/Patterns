package futureman.visitable.concrete;

import futureman.visitor.Visitor;

public abstract class Item extends Product {
	
	protected boolean _isRecycleable = false;
	
	public Item(double price) {
		super(price);
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}
	public boolean get_isRecycleable() {
		return _isRecycleable;
	}
	
	public String toString() {
		return super.toString();
	}


}
