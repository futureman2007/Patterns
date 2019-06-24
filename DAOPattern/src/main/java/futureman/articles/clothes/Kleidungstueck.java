package futureman.articles.clothes;

import futureman.articles.Artikel;
import futureman.articles.Farbe;
import futureman.ort.Ort;

public class Kleidungstueck extends Artikel{
	
	protected int kleidergroese;
	protected String bezeichnung;
	protected Farbe farbe;
	
	//Constructor for parsing from DB back to OBJECT
	protected Kleidungstueck() {
		super(-1, -1, -1);
		this.kleidergroese = -1;
		this.bezeichnung = "ERROR";
		this.farbe = null;
	}

	public Kleidungstueck(int kleidergroeße, String bezeichnung, Farbe farbe) {
		super(60, 200, 60);
		this.kleidergroese = kleidergroeße;
		this.bezeichnung = bezeichnung;
		this.farbe = farbe;
	}
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(super.toString() + "\n");
		buff.append("Kleidergroesse: " + this.kleidergroese + ",");
		buff.append("Bezeichnung: " + this.bezeichnung + ",");
		buff.append("Farbe: " + this.farbe + " ");
		return buff.toString();
	}

	public int getKleidergroese() {
		return this.kleidergroese;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public Farbe getFarbe() {
		return this.farbe;
	}
//	public void setKleidergroese(int kleidergroese) {
//		this.kleidergroese = kleidergroese;
//	}
//
//	public void setBezeichnung(String bezeichnung) {
//		this.bezeichnung = bezeichnung;
//	}
//
//	public void setFarbe(Farbe farbe) {
//		this.farbe = farbe;
//	}
	
}
