package futureman.articles.shoes;

import futureman.articles.Artikel;
import futureman.articles.Farbe;
import futureman.ort.Ort;

public class Schuhe extends Artikel{
	
	protected int schuhgroesse;
	protected String obermaterial; //!?
	protected String absatzform;
	protected Farbe farbe;
	
	//Constructor for parsing from DATA back to OBJECT
	protected Schuhe() {
		super();
		this.schuhgroesse = -1;
		this.obermaterial = null;
		this.farbe = null;
		this.absatzform = null;
	}
	
	public Schuhe(int schuhgroesse, String obermaterial, Farbe farbe, String absatzorm) {
		super(40, 30, 100);
		this.schuhgroesse = schuhgroesse;
		this.obermaterial = obermaterial;
		this.farbe = farbe;
		this.absatzform = absatzorm;
	}
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(super.toString() + "\n");
		buff.append("Schuhgroesse: " + this.schuhgroesse + ",");
		buff.append("Obermaterial: " + this.obermaterial + ",");
		buff.append("Farbe: " + this.farbe + ",");
		buff.append("Absatzform: " + this.absatzform + " ");
		
		return buff.toString();
	}
	public int getSchuhgroesse() {
		return this.schuhgroesse;
	}
	public String getObermaterial() {
		return this.obermaterial;
	}
	public String getAbsatzform() {
		return this.absatzform;
	}
	public Farbe getFarbe() {
		return this.farbe;
	}
	
//	public void setSchuhgroesse(int schuhgroesse) {
//		this.schuhgroesse = schuhgroesse;
//	}
//
//	public void setObermaterial(String obermaterial) {
//		this.obermaterial = obermaterial;
//	}
//
//	public void setAbsatzform(String absatzform) {
//		this.absatzform = absatzform;
//	}
//
//	public void setFarbe(Farbe farbe) {
//		this.farbe = farbe;
//	}

	
}
