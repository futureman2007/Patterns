package pfeiffer.time;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TimeDisplayTest {

	static Calendar cStub = null;
	static TimeDisplay display = null;
	
	
	//stub einrichten
	@Test 
	void testMiddnightMessage() {
		String expectedHTML = "<span class=\"tinyBoldText\">MidNight</span>";
		TimeDisplay tDis = new TimeDisplay();
		tDis.setTime( () -> {
			cStub = Calendar.getInstance();
			cStub.set(Calendar.HOUR_OF_DAY,0);
			cStub.set(Calendar.MINUTE, 0);
			cStub.set(Calendar.SECOND,0);
			return cStub;
		});
		assertTrue(tDis.getTimeMessageAsHTML().contains("MidNight"), "tDis was not as Expected!");
		
	}
	
	
	
	
}
