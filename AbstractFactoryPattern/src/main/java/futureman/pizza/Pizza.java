package futureman.pizza;

import java.util.LinkedList;

public abstract class Pizza {
	protected String _name;
	protected LinkedList<String> _zutaten = new LinkedList<String>();
	
	public Pizza() {
	}
	
	public void prepare() {
		try {
			throw new ImplementationRequiredException();
		} catch (ImplementationRequiredException e) {
			e.printStackTrace();
		}
	}
	
	public void bake() {
		try {
			throw new ImplementationRequiredException();
		} catch (ImplementationRequiredException e) {
			e.printStackTrace();
		}
	}
	
	public void cut() {
		try {
			throw new ImplementationRequiredException();
		} catch (ImplementationRequiredException e) {
			e.printStackTrace();
		}
	}
	
	public void box() {
		try {
			throw new ImplementationRequiredException();
		} catch (ImplementationRequiredException e) {
			e.printStackTrace();
		}
		
	}
	public String getName() {
		return _name;
	}
	
	public LinkedList<String> getZutaten(){
		return _zutaten;
	}
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("Pizza: " + _name + "\n");
		buff.append("With: " + _zutaten + "\n");
		return buff.toString();
	}
}
