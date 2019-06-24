package futureman.clocks;

public class SetableClock extends Clock{

	public SetableClock(int hour, int minutes, int seconds) {
		super(hour,minutes,seconds);
	}
	
	public SetableClock(Time time) {
		super(time);
	}
	
	public void setTime(int hours, int mins) {
		validateTime(hours, mins, 0);
		_time._hours = hours;
		_time._minutes = mins;
		checkClockInvariants();
	}
	
}
