package pfeiffer.time;

public class TimeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TimeDisplay t = new TimeDisplay(new DefaultTimeProvider());
		
		
		
		System.out.println(t.getTimeMessageAsHTML());

	}

}
