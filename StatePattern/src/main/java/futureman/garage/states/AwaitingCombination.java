package futureman.garage.states;

import futureman.garage.Garagentor;

public class AwaitingCombination extends State {

	private static AwaitingCombination _awaiting = null;
	private static Garagentor _gt = null;
	
	private AwaitingCombination(Garagentor gt) {
		_gt = gt;
	}
	
	public static State enter(Garagentor gt) {
		if(_awaiting == null) {
			_awaiting = new AwaitingCombination(gt);
		}else {
			_gt = gt;
		}
		return _awaiting;
	}
	public void wrongCombination() {
		System.out.println("Wrong combination entered ¯\\_(ツ)_/¯ ");
		_gt.setState(Locked.enter(_gt));
	}
	
	public void rightCombination() {
		System.out.println("Unlock successfull!");
		_gt.setState(Closed.enter(_gt));
	}
	
	public void startUnlock() {
		System.out.println("Unlocking...");
		_gt.setState(AwaitingCombination.enter(_gt));
	}
	public String toString() {
		return "AwaitingCombination" ;
	}
}
