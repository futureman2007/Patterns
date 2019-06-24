package futureman.clocks;

public class AlarmClock extends SetableClock{
	
	enum Alarm {OFF, ON}
	
	Time _alarmTime;
	Alarm _alarm;
	AlarmListener _aListener;
	
	public AlarmClock(Time time) {
		super(time);
		_alarm = Alarm.OFF;
		
	}
	
	public void alarmOn(){
		checkAlarmClockInvariants();
		_alarm = Alarm.ON;
		
		assert _alarm.equals(Alarm.ON);
	}
	
	public void alarmOff() {
		checkAlarmClockInvariants();
		
		_alarm = Alarm.OFF;
		_aListener = null;
		
		assert (_alarm.equals(Alarm.OFF) && _aListener == null);
				
	}

	public void setAlarmTime(Time alarmTime, AlarmListener aListener) {
		validateAlarmTime(alarmTime);
		_alarmTime = alarmTime;
		_aListener = aListener;
		
		_alarm = Alarm.ON;
		
		assert _alarmTime != null;
		assert _aListener != null;
	}
	
	public void setAlarmTime(int hour, int min, int sec, AlarmListener aListener) {
		checkAlarmClockInvariants();
		
		super.validateTime(hour, min, sec);
		_alarmTime._hours = hour;
		_alarmTime._minutes = min;
		_alarmTime._seconds = sec;
		
		_aListener = aListener;
		_alarm = Alarm.ON;
		
		checkAlarmClockInvariants();
		
	}
		
	@Override
	public void tick() {
		super.tick();
		
		if( (_time._hours == _alarmTime._hours) && (_time._minutes == _alarmTime._minutes) && (_alarm.equals(Alarm.ON) )  ) {
			fireAlarmEvent();
		}else if(_time._minutes +1 == _alarmTime._minutes){
			fireAlarmEvent();
		}
			
		checkAlarmClockInvariants();
	}
	
	protected void fireAlarmEvent() {
		_aListener.alarm();
	}
	
	protected void validateAlarmTime(Time alarmTime) {
		super.validateTime(alarmTime._hours,alarmTime._minutes, alarmTime._seconds);
	}
	
	public void checkAlarmClockInvariants() {
		super.checkClockInvariants();
		assert (_alarm.equals(Alarm.ON) && _aListener != null) || (_alarm.equals(Alarm.OFF) && _aListener == null);		
	}
	public Alarm getAlarmStatus() {
		return _alarm;
	}
	
	public boolean isAlarmOn() {
		if(_alarm.equals(Alarm.ON)) {
			checkAlarmClockInvariants();
			return true;
		}	
		checkAlarmClockInvariants();
		return false;
		
	}
	
	public boolean isAlarmOff() {
		if(_alarm.equals(Alarm.OFF)) {
			checkAlarmClockInvariants();
			return true;
		}
		checkAlarmClockInvariants();
		return false;
	}

}
