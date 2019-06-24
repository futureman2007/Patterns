package futureman.taschenrecher.commands;

public class SubCommand implements TRCommand {
	private static SubCommand _sub = null;
	private SubCommand() {}
	
	public static SubCommand getSubCommand() {
		if(_sub == null) {
			_sub = new SubCommand();
		}
		return _sub;
	}
	
	@Override
	public double calculate(double opperand1, double opperand2) {
		return opperand1 - opperand2; 
	}



}
