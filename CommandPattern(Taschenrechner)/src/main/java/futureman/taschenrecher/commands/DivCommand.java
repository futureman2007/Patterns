package futureman.taschenrecher.commands;

public class DivCommand implements TRCommand {

	private static DivCommand _div = null;
	private DivCommand() {}
	
	public static DivCommand getDivCommand() {
		if(_div == null) {
			_div = new DivCommand();
		}
		return _div;
	}
	
	@Override
	public double calculate(double opperand1, double opperand2) {
		if(opperand2 != 0) {
			return opperand1 / opperand2;
		}
		return 0;
	}

}
