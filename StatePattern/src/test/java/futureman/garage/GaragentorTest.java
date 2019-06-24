package futureman.garage;

public class GaragentorTest {

	public static void main(String[] args) {
		Garagentor gt = new Garagentor();
		System.out.println("===START WITH===");
		printGaragentor(gt);
		System.out.println("================");
		gt.open();
		printGaragentor(gt);
		gt.close();
		printGaragentor(gt);
		gt.lock();
		printGaragentor(gt);
		gt.startUnlock();
		printGaragentor(gt);
		gt.wrongCombination();
		printGaragentor(gt);
		gt.startUnlock();
		printGaragentor(gt);
		gt.rightCombination();
		printGaragentor(gt);
		gt.open();
		printGaragentor(gt);
		System.out.println("=== Unsupported Opperations Testing ===\n");
		System.out.println("===START WITH===");
		printGaragentor(gt);
		System.out.println("================");
		gt.lock();
		gt.startUnlock();
		gt.open();
		System.out.println("====== END ======");
		
		
		
	}
	
	public static void printGaragentor(Garagentor gt) {
		System.out.println(gt.toString());
	}
	
	
	
}
