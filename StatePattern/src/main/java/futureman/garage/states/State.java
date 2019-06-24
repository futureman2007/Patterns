package futureman.garage.states;

import futureman.garage.Garagentor;

public abstract class State {
	// besser: UnsupportedOpperationException werfen
	public void close() {
		System.out.println("Closing at this state is not supported ¯\\_(ツ)_/¯");
	}
	
	public void open() {
		System.out.println("Opening at this state is not supported ¯\\_(ツ)_/¯");
	}
	
	public void lock() {
		System.out.println("Locking at this state is not supported ¯\\_(ツ)_/¯");
	}
	
	
	public void startUnlock() {
		System.out.println("StartUnlocking at this state is not supported ¯\\_(ツ)_/¯");
	}
	
	public void rightCombination() {
		System.out.println("No Combination can be entered at this state ¯\\_(ツ)_/¯");
	}

	public void wrongCombination() {
		System.out.println("No Combination can be entered at this state ¯\\_(ツ)_/¯");
	}
}
