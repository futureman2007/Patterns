package pfeiffer.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeDisplay {
	
	private  Calendar _currentTime = null;
	
	protected TimeDisplay(TimeProvider provider) {
		_currentTime = provider.getTime();
	}
	public TimeDisplay(Calendar time){
		_currentTime = time;
	}
	public TimeDisplay(){
		_currentTime = Calendar.getInstance();
	}
	
	
	public void setTime(Calendar time) {
		_currentTime = time;
	}
	
	public void setTime(TimeProvider provider) {
		_currentTime = provider.getTime();
	}
	
	public void setToCurrentTime() {
	      try {
	         _currentTime = new DefaultTimeProvider().getTime();
	      } catch (Exception e) {
	    	 e.printStackTrace();
	      }
	}
	
	public String getTimeMessageAsHTML() {
	    return  "<span class=\"tinyBoldText\">" + getTimeMessage() + "</span>";
	}
	
	protected String getTimeMessage() {
		
		if(_currentTime == null) {
			return "";
		}
		
		 if (_currentTime.get(Calendar.HOUR_OF_DAY) == 0 || (_currentTime.get(Calendar.HOUR) == 12 && _currentTime.get(Calendar.AM) == 1))
	    	  return "MidNight";
	      else {
	    	  SimpleDateFormat formatter = new SimpleDateFormat("E hh:mm:ss a");
	          return formatter.format(_currentTime.getTime());

	      }
	}
	
	protected void setCalendar(TimeProvider prov) {
		_currentTime = prov.getTime();
	}
}
