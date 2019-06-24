package futureman.dataAccessObjektInterface;

import futureman.articles.Artikel;;

public interface ArticlesDAO {

	public void saveArticle(Artikel art);
	
	public void deleteArticle(int artikelID);
	
	public Artikel loadArticle(int artikelID);

}
