package entreprise;
import java.util.*;


//import entreprise.stockagePersistant.StockagePersistant;


public class Inventaire {


	private ArrayList<Article> articles;
	
	public Inventaire() {
		articles = new ArrayList<Article>();
		articles.add(new Article(1,"pantalon nike", 10, 1000));
		articles.add(new Article(2,"chandail adidas", 15, 1500));
		articles.add(new Article(3,"souliers puma", 3, 2000));
	}
	
	public void addArticle(Article a) {
		articles.add(a);
		Collections.sort(articles,Article.idComparator);
	}
	
	public void removeArticle(int id) {
		articles.removeIf(obj -> obj.getID() == id);
	}
	
	public Article searchArticle(int id) {
		for (Article a : articles) {
			if(a.getID() == id)
				return a;
		}
		return null;
	}
	
	public String toString() {
		String str = "";
		for(Article a: articles) {
			str += a.toString() + "\n";
		}
		return str;
	}
	

	public ArrayList<Article> getArticles() {
		return articles;
	}

}
