package futureman.ort;
// es reicht, wenn der ORt sich nur die ArtikelID specihert. (auch in json) sonst redundanz!
// du musst einfach ein artikel objekt übergeben und desser ID speichern.
// kein setter dafür!
//getter returned einfach nur die ID;
import futureman.articles.Artikel;

public class Ort {
	protected static int ortsCounter = 0;
	protected int _ortsId;
	protected int[] _coordinates = new int[3]; // x , y , z 
	protected Artikel _artikel = null;

	protected Ort() {
		_ortsId = ortsCounter;
		_coordinates = null;
		_artikel = null;
	}

	public Ort(int x, int y, int z) {
		ortsCounter++;
		_ortsId = ortsCounter;
		_coordinates[0] = x;
		_coordinates[1] = y;
		_coordinates[2] = z;
		_artikel = null;
	}

	public int get_ortsId() {
		return _ortsId;
	}

	public int[] get_coordinates() {
		return _coordinates;
	}
	public Artikel get_artikel() {
		return this._artikel;
	}

	public void set_artikel(Artikel _artikel) {
		einlagern(_artikel);
	}
	
	public void einlagern(Artikel art) {
		if(this._artikel == null) {
			this._artikel = art;
		}else {
			auslagern(art.getArtikelID());
			einlagern(art);
		}
	}
	public void auslagern(int artikelId) {
		if(this._artikel == null) {
			return;
		}
		this._artikel = null;
	}

	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("Ort " + _ortsId);
		buff.append("   x: " + _coordinates[0]);
		buff.append("   y: " + _coordinates[1]);
		buff.append("   z: " + _coordinates[2]);
		if(this._artikel == null) {
			buff.append("   kein artikel eingelagert");
		}else {
			buff.append(" ArtikelNR: " + _artikel.getArtikelID() + " eingelagert");
		}
		return buff.toString();
		
	}
}
