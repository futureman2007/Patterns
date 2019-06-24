package futureman.garage.states;

import futureman.garage.Garagentor;

public class Closed extends State{

	private static Closed _closed = null;
	private static Garagentor _gt = null;
	
	private Closed(Garagentor gt) {
		_gt = gt;
	}
	
	public static State enter(Garagentor gt) {
		if(_closed == null) {
			_closed = new Closed(gt);
		}else {
			_gt = gt;
		}
		return _closed;
	}
	
	public void open() {
		System.out.println("Opening...");
		_gt.setState(Opened.enter(_gt));
	}
	
	public  void lock() {
		System.out.println("locking...");
		_gt.setState(Locked.enter(_gt));
	}
	
	public String toString() {
		return "Closed" ;
	}
}
