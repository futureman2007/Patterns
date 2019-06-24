package unternehmen.abstrakt;

import java.util.ArrayList;

import unternehmen.exception.UnsupportedOpperationException;

public abstract class Angestellter {
	// transaprenz variante gewählt: so kann ein cast von mitarbeiter zu abteilungsleiter und umgekehrt leichter stadtfinden oder?
	private static int counter = 0;
	
	protected String _vorname;
	protected String _nachname;
	protected String _personalnummer;
	protected String _abteilung;
	protected String _zustaendigkeit;
	protected double _gehalt;
	
	protected ArrayList<Angestellter> _unterstellte;
	
	private Angestellter() {}
	
	public Angestellter(String vorname, String nachname, String abteilung, double gehalt) {
		counter++;
		_vorname = vorname;
		_nachname = nachname;
		_personalnummer = Integer.toString(counter);
		_gehalt = gehalt;
		_abteilung = abteilung;
		
	}	
	public int get_personalnummerAsNumber() {
		return Integer.parseInt(_personalnummer);
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
	public String get_zustaendigkeit() {
		return _zustaendigkeit;
	}
	public void set_nachmane(String nachname) {
		_nachname = nachname;
	}
	
	public void setGehalt(double gehalt) {
		_gehalt = gehalt;
	}
	
	
	// must be overwritten in explicit classes. this are just default implementations for normal Mitarbeiter
	
	public void set_unterstellte(ArrayList<Angestellter> unterstellte) throws UnsupportedOpperationException {
		throw new UnsupportedOpperationException(this);
	}
	
	public boolean addUnterstellten(Angestellter a) throws UnsupportedOpperationException {
		throw new UnsupportedOpperationException(this);
	}
	public boolean removeUnterstellten(Angestellter a) throws UnsupportedOpperationException{
		throw new UnsupportedOpperationException();
	}
	
	
	public ArrayList<Angestellter> get_unterstellte() {
		return null;
	}
	// default
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("\n Personalnummer: " + _personalnummer + "\n");
		bf.append("Name: " + _vorname + " " + _nachname + "\n");
		bf.append("Abteilung: " + _abteilung + " Zustaendigkeit: " + _zustaendigkeit + "\n");
		bf.append(_gehalt + "\n");
		return bf.toString();
	}
	
	
	
}
