package futureman.articles.clothes;


import futureman.articles.Farbe;
import futureman.ort.Ort;


public class Jacke extends Kleidungstueck{

	protected int wassersaeule;
	//Constructor for parsing from DATA back to OBJECT
	private Jacke() {
		super();
		this.wassersaeule = -1;
	}

	public Jacke(int kleidergroeße, String bezeichnung, Farbe farbe, int wassersaeule) {
		super(kleidergroeße, bezeichnung, farbe);
		this.wassersaeule = wassersaeule;
	}
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(super.toString());
		buff.append("Wassersaeule: " + this.wassersaeule + " ");
		return buff.toString();
	}

	public int getWassersaeule() {
		return this.wassersaeule;
	}
//	public void setWassersaeule(int _wassersaeule) {
//		this.wassersaeule = _wassersaeule;
//	}
}
