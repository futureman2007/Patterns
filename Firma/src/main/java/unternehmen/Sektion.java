package unternehmen;

import java.util.ArrayList;
import java.util.List;
//MANAGEMENT,
//MEDIEN,
//SPIELWAREN,
//SCHREIBWAREN,
//SPIELWAREN_EINKAUF,
//SPIELWAREN_VERKAUF,
//SCHREIBWAREN_EINKAUF,
//SCHREIBWAREN_VERKAUF,
//MARKETING,
//RECHTS,
//MEDIEN_EINKAUF,
//MEDIEN_VERKAUF,

public abstract class Sektion {

	protected String _abteilungsname;
	protected Sektion _untergeordnet;
	protected Sektion _uebergeordnet;
	protected ArrayList<Angestellter> _angestellte;
	protected ArrayList<Angestellter> _leiter;

}
