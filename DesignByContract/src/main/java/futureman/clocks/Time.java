package futureman.clocks;

import java.io.InvalidClassException;

public class Time implements Comparable{
	protected int _hours;
	protected int _minutes;
	protected int _seconds;
	
	public Time(int h, int m, int s) {
		_hours = h;
		_minutes = m;
		_seconds = s;
	}
	//copy constructor
	public Time(Time t) {
		_hours = t._hours;
		_minutes = t._minutes;
		_seconds = t._seconds;
	}
	
	public String toString() {
		return(String.format("%02d" + ":" + "%02d" + ":" + "%02d", _hours ,_minutes, _seconds));
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Time) {
			Time other = (Time) o;
			
			if(other._hours > this._hours)
				return 1;
			if(other._hours == this._hours && other._minutes > this._minutes)
				return 1;
			if(other._hours == this._hours && other._minutes == this._minutes && other._seconds > this._seconds)
				return 1;
			
			if(other.equals(this))
				return 0;
			
			if(other._hours < this._hours)
				return -1;
			if(other._hours == this._hours && other._minutes < this._minutes)
				return -1;
			if(other._hours == this._hours && other._minutes == this._minutes && other._seconds < this._seconds)
				return -1;
			
		}else{
			return 0;
		}
		return 0;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Time) {
			Time other = (Time) o;
			
			if(this._hours == other._hours && this._minutes == other._minutes && this._seconds == other._seconds ) {
				return true;
			}
		}
		return false;
	}
	public int wholeTimeInSeconds() {
		return _seconds + _minutes * 60 + _hours * 3600;
	}
	
	
	
}
