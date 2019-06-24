package futureman.experiment;

import futureman.clocks.AlarmClock;
import futureman.clocks.AlarmListenerProvider;
import futureman.clocks.Clock;
import futureman.clocks.Time;

public class Experiment {

	public static void main(String [] args) throws InterruptedException {
		assert args.length == 0;
		System.out.println("STARTING CLOCKTEST");
		short i = 0;
		
		Clock clock = new Clock(07,59,50);
		Time alarmTime = new Time(5,0,0);
		
		AlarmClock aclock = new AlarmClock(new Time(4,59,50));
		
		aclock.setAlarmTime(alarmTime, new AlarmListenerProvider());
		
		while(true) {
			aclock.tick();
			Thread.sleep(999);
			System.out.println(aclock.toString());
		}
		
	}
}
