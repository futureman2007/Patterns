package futureman.taschenrecher.commands;

public class AddCommand implements TRCommand{

	private static AddCommand _add = null;
	private AddCommand() {}
	
	public static AddCommand getAddCommand() {
		if(_add == null) {
			_add = new AddCommand();
		}
		return _add;
	}
	
	@Override
	public double calculate(double opperand1, double opperand2) {
		return opperand1 + opperand2;
	}

}
