package futureman.business;

import futureman.dataAccessObjektInterface.OrteDAO;
import futureman.ort.Ort;

public class Lagersteuerung {
	
	public Ort ermittleEinenFreienOrt(OrteDAO odao) {
		return odao.findfreeOrt();
	}

}
