package futureman.pizza;

public class ImplementationRequiredException extends Exception {
	public ImplementationRequiredException() {
		super("This Method needs to be implemented!");
	}
	public ImplementationRequiredException(String methodname) {
		super(methodname + "() needs to be implemented!");
	}
}
