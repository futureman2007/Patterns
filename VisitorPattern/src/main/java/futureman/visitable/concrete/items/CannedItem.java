package futureman.visitable.concrete.items;

import futureman.visitable.concrete.Item;

public class CannedItem extends Item {
	
	public CannedItem(double price, boolean isRecycleable) {
		super(price);
		_isRecycleable = isRecycleable;
	}
	
	public CannedItem(double price) {
		super(price);
	}
	public void set_isRecycleable(boolean bool) {
		_isRecycleable = bool;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(super.toString());
		buff.append(" isRecycleable: " +_isRecycleable);
		return buff.toString();
	}

}
