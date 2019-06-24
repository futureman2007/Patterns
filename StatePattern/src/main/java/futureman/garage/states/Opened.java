package futureman.garage.states;

import futureman.garage.Garagentor;

public class Opened extends State {

	private static Opened _opened= null;
	private static Garagentor _gt = null;
	
	private Opened(Garagentor gt) {
		_gt = gt;
	}
	
	public static State enter(Garagentor gt) {
		if(_opened == null) {
			_opened = new Opened(gt);
		}else {
			_gt = gt;
		}
		return _opened;
	}
	
	public void close() {
		System.out.println("Closing...");
		_gt.setState(Closed.enter(_gt));
	}
	
	public String toString() {
		return "Opened";
	}
}
