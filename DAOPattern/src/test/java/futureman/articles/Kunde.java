package futureman.articles;

public class Kunde {
	private static int idCounter = 0;
	private int _id = 0;
	private String vorname;
	private String nachname;
	
	public Kunde(String vorname, String nachname){
		idCounter++;
		this._id = idCounter;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	private Kunde() {
		this.vorname = "ROGAN";
		this.nachname = "WOLOLO";
		this.idCounter = 0;
		this.idCounter++;
		this._id = this.idCounter;
	}

	public int get_id() {
		return this._id;
	}

	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	

	
	public String toString() {
		return this._id + " " + this.nachname + " " + this.vorname;
	}



	
	
	
}
