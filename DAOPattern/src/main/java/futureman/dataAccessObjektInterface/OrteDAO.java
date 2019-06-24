package futureman.dataAccessObjektInterface;

import futureman.articles.Artikel;
import futureman.ort.Ort;

public interface OrteDAO {

	public void saveNewOrt(Ort ort);
	public Ort loadOrt(int ortsId);
	public Ort findfreeOrt();
	public void deleteOrt(int ortsId);
}
