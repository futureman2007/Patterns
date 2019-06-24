package unternehmen.impl;
import java.util.ArrayList;
import java.util.List;

import unternehmen.abstrakt.Angestellter;
import unternehmen.exception.UnsupportedOpperationException;

public class Abteilungsleiter extends Angestellter {

	ArrayList<Angestellter> _unterstellte = new ArrayList<Angestellter> ();
	
	public Abteilungsleiter(String vorname, String nachname, String abteilung, double gehalt) {
		super(vorname, nachname, abteilung, gehalt);
		_zustaendigkeit = "Abteilungsleiter";
	}
	public Abteilungsleiter(String vorname, String nachname, String abteilung, double gehalt, String zustaendigkeit) {
		super(vorname, nachname, abteilung, gehalt);
		_zustaendigkeit = zustaendigkeit;
	}
	public ArrayList<Angestellter> get_unterstellte(){
		return _unterstellte;
	}
	
	public void set_unterstellte(ArrayList<Angestellter> unterstellte) {
		_unterstellte.addAll(unterstellte);
	}
	
	public boolean addUnterstellten(Angestellter a) {
		_unterstellte.add(a);
		return true;
	}
	public boolean removeUnterstellten(Angestellter a){
		for(int i = 0; i < _unterstellte.size(); i++) {
			if(_unterstellte.get(i).get_personalnummerAsNumber() == a.get_personalnummerAsNumber()) {
				_unterstellte.remove(i);
				return true;
			}
		}
		return false;
		
	}
	public String toString() {
		StringBuffer bf = new StringBuffer(super.toString());
		bf.append("Unterstellte: "+ "\t" + _unterstellte.toString());
		return bf.toString();
	}
	
	
	

}
