package futureman.garage;

import futureman.garage.states.Closed;
import futureman.garage.states.State;

public class Garagentor {

	private State _state;
	private int _combination = 3575805;
	
	public Garagentor() {
		_state = Closed.enter(this);
	}
	
	public void close() {
		_state.close();
	}
	public void open() {
		_state.open();
	}
	public void lock() {
		_state.lock();
	}
	public void startUnlock() {
		_state.startUnlock();
	}
	
	public void rightCombination() {
		_state.rightCombination();
	}

	public void wrongCombination() {
		_state.wrongCombination();
	}
	
	
	public void setState(State newstate) {
		_state = newstate;
	}
	
	public boolean isCombinationRight(int combination) {
		if(combination == _combination) {
			return true;
		}
		return false;
	}
	
	protected void setCombination(int combination) {
		_combination = combination;
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("Garage: " + _state);
		return buff.toString();
		
	}
	
	
}
