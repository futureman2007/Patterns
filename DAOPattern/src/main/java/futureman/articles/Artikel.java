package futureman.articles;

import futureman.ort.Ort;

public abstract class Artikel {
	private static int artikelCounter = 0;
	protected int artikelID;
	protected int breite;
	protected int hoehe;
	protected int tiefe;
//	protected Ort ort;
	
	//Constructor for parsing from DATA back to OBJECT
	protected Artikel() {
		artikelCounter++;
		this.artikelID = artikelID;
		this.breite = -1;
		this.hoehe = -1;
		this.tiefe = -1;
//		this.ort = null;
	}
	
	protected Artikel(int breite, int hoehe, int tiefe) {
		artikelCounter++;
		this.artikelID = artikelCounter;
		this.breite = breite;
		this.hoehe = hoehe;
		this.tiefe = tiefe;
//		this.ort = ort;
	}
	
	public int getArtikelID() {
		return this.artikelID;
	}
	public int getBreite() {
		return this.breite;
	}
	public int getHoehe() {
		return this.hoehe;
	}
	public int getTiefe() {
		return this.tiefe;
	}
//	public Ort getOrt() {
//		return this.ort;
//	}

//	public void setOrt(Ort ort) {
//		this.ort = ort;
//	}
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("Artikelnummer: " + this.artikelID + ",");
		buff.append(" Abmessungen: breite=" + this.breite + "," );
		buff.append(" hoehe=" + this.hoehe + ",");
		buff.append(" tiefe=" + this.tiefe + " ");
//		if(this.ort != null) {
//			buff.append("Eingelagert bei: " + this.ort.get_ortsId());
//		}else {
//			buff.append("Nicht eingelagert ");
//		}
		
		return buff.toString();
	}
	
//	public static void setArtikelCounter(int artikelCounter) {
//		Artikel.artikelCounter = artikelCounter;
//	}
//	public void setArtikelID(int _artikelID) {
//		this.artikelID = _artikelID;
//	}
//	public void setBreite(int _breite) {
//		this.breite = _breite;
//	}
//	public void setHoehe(int _hoehe) {
//		this.hoehe = _hoehe;
//	}
//	public void setTiefe(int _tiefe) {
//		this.tiefe = _tiefe;
//	}
//	public void setOrt(Ort _ort) {
//		this.ort = _ort;
//	}
}
