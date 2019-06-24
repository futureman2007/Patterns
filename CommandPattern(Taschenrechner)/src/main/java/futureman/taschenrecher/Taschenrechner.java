package futureman.taschenrecher;

import java.util.Observable;

import futureman.taschenrecher.commands.AddCommand;
import futureman.taschenrecher.commands.TRCommand;

public class Taschenrechner extends Observable {
	
	private double _result = 0.0;
	protected TRCommand _cmd;
	
	public Taschenrechner() {
		TRCommand _cmd = AddCommand.getAddCommand();
	}
	
	public void setCommand(TRCommand cmd) {
		_cmd = cmd;
	}
	
	public void berechne(double operator) {
		_cmd.calculate(_result, operator);	
		this.setChanged();
		this.notifyObservers();
	}

	public void setResult(double operand) {
		_result = operand;
		this.setChanged();
		this.notifyObservers();
	
}

public double getResult() {
	return _result; 
}

	
	
	

}
