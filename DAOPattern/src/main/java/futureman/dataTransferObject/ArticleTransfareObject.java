package futureman.dataTransferObject;

import futureman.articles.Artikel;
import futureman.dataAccessObjektInterface.ArticlesDAO;

public class ArticleTransfareObject {

	
	public Artikel getArtikel(int artikelID, ArticlesDAO dao) {
		return dao.loadArticle(artikelID);
	}
	public boolean saveNewArtikel(Artikel art, ArticlesDAO dao) {
		try{
			dao.saveArticle(art);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean deleteArtikle(int artikleID, ArticlesDAO dao) {
		try {
			dao.deleteArticle(artikleID);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
