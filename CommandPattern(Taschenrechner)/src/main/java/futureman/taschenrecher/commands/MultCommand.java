package futureman.taschenrecher.commands;

public class MultCommand implements TRCommand{
	
	private static MultCommand _mult = null;
	private MultCommand() {}
	
	public static MultCommand getMultCommand() {
		if(_mult == null) {
			_mult = new MultCommand();
		}
		return _mult;
	}
	
	@Override
	public double calculate(double opperand1, double opperand2) {
		return opperand1 * opperand2;
	}



}
