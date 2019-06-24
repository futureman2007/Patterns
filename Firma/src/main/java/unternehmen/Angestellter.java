package unternehmen;

public abstract class Angestellter {
	
	private static int counter = 1;
	
	protected String _vorname;
	protected String _nachname;
	protected String _personalnummer;
	protected String _abteilung;
	protected double _gehalt;
	
	private Angestellter() {}
	
	public Angestellter(String vorname, String nachname, String abteilung) {
		_vorname = vorname;
		_nachname = nachname;
		_personalnummer = Integer.toString(counter);
		counter++;
		_gehalt = 0.0;
		_abteilung = abteilung;
	}
	
	
	public String get_nachname() {
		return _nachname;
	}
	public String get_vorname() {
		return _vorname;
	}

	public String get_personalnummer() {
		return _personalnummer;
	}
	public String get_abteilung() {
		return _abteilung;
	}
	public double getGehalt() {
		return _gehalt;
	}
	
	public void set_nachmane(String nachname) {
		_nachname = nachname;
	}
	
	public void setGehalt(double gehalt) {
		_gehalt = gehalt;
	}
	
	
	
}
