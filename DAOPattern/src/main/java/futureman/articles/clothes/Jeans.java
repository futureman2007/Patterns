package futureman.articles.clothes;

import futureman.articles.Farbe;
import futureman.ort.Ort;


public class Jeans extends Kleidungstueck{

	protected int schrittlaenge;
	//Constructor for parsing from DATA back to OBJECT
	protected Jeans() {
		super();
		schrittlaenge = -1;
	}


	public Jeans(int kleidergroeße, String bezeichnung, Farbe farbe, int schrittlaenge) {
		super(kleidergroeße, bezeichnung, farbe);
		this.schrittlaenge = schrittlaenge;
	}
	
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(super.toString());
		buff.append("Schrittlaenge: " + this.schrittlaenge + " ");
		return buff.toString();
	}

	public int getSchrittlaenge() {
		return this.schrittlaenge;
	}
//	public void setSchrittlaenge(int _schrittlaenge) {
//		this.schrittlaenge = _schrittlaenge;
//	}
}
