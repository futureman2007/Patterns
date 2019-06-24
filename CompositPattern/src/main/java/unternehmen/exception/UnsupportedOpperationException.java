package unternehmen.exception;

public class UnsupportedOpperationException extends Exception {

	public UnsupportedOpperationException() {
		super("This opperation is not supported for this type");
	}
	public UnsupportedOpperationException(Object o) {
		super("This opperation is not supported for " + o.getClass().toString());
	}
}
