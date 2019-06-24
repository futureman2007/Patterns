package futureman.clocks;

public class Clock {

	protected Time _time;
	
	public Clock(int hour, int min, int sec ) {
		validateTime(hour, min, sec);
		_time = new Time(hour,min,sec);
	}
	public Clock(Time time) {
		validateTime(time);
		_time = time;
	}

	
	public int get_hours() {
		checkClockInvariants();
		return _time._hours;
	}

	public int get_minutes() {
		checkClockInvariants();
		return _time._minutes;
	}

	public int get_seconds() {
		checkClockInvariants();
		return _time._seconds;
	}
	
	public void tick() {
		checkClockInvariants();
		_time._seconds++;
		checkTime(_time);
		
//		assert (_time.wholeTimeInSeconds() == oldTime.wholeTimeInSeconds() +1);
		// assert (_time.wholeTimeInSeconds() <= (_time.wholeTimeInSeconds() % 24 * 60 * 60 ) );
		
		
	}
	
	public String toString(){
		return _time.toString();
	}
	
	protected void validateTime(Time time) {
		if(time == null) {
			throw new NullPointerException("time cannot be null in any clock!");
		}
		validateTime(time._hours, time._minutes, time._seconds);
	}
	
	protected void validateTime(int hour, int min, int sec) {
		if(hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("Invalid argument: hour must be between 0 and 23!");
		}
		if(min < 0 || min >= 60) {
			throw new IllegalArgumentException("Invalid argument: minute must be between 0 and 59!");
		}
		if(sec < 0 || sec >= 60) {
			throw new IllegalArgumentException("Invalid argument: second must be between 0 and 59!");
		}
	}
	protected void checkClockInvariants() {
		assert (_time._hours >= 0 && _time._hours < 24);
		assert (_time._minutes >= 0 && _time._minutes < 60);
		assert (_time._seconds >= 0 && _time._seconds < 60);
	}

	
	// intern functions
	private void checkSeconds(Time t) {
		if(t._seconds >= 60) {
			t._seconds = 0;
			t._minutes++;
		}
	}
	
	private void checkMinutes(Time t) {
		if(t._minutes >= 60) {
			t._minutes = 0;
			t._hours++;
		}
	}
	
	private void checkHours(Time t) {
		if(t._hours >= 24) {
			t._hours = 0;
		}
	}
	
	private void checkTime(Time t) {
		checkSeconds(t);
		checkMinutes(t);
		checkHours(t);
	}
	

	
	
}
