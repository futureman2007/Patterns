package futureman.garage.states;

import futureman.garage.Garagentor;

public class Locked extends State {

	private static Locked _locked = null;
	private static Garagentor _gt = null;
	
	private Locked(Garagentor gt) {
		_gt = gt;
	}
	
	public static State enter(Garagentor gt) {
		if(_locked == null) {
			_locked = new Locked(gt);
		}else {
			_gt = gt;
		}
		return _locked;
	}
	
	public void startUnlock() {
		System.out.println("Unlocking...");
		_gt.setState(AwaitingCombination.enter(_gt));
	}
	
	public String toString() {
		return "Locked" ;
	}
}
