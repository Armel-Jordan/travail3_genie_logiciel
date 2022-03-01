package entreprise;
import java.util.Comparator;

public class Article implements Observateur{
	
	private int id;
	private String nom;
	private int quantite;
	private double prix;
	
	public Article(int code, String name, int qnt, double price) {
		id = code;
		nom = name;
		quantite = qnt;
		prix = price;
	}
	
	public int getID() {return id;}
	
	public int getQuantity() {return quantite;}
	
	public String getNAme() {return nom;}
	
	public double getPrice() {return prix;}
	
	
	public static Comparator<Article> idComparator = new Comparator<Article>() {
		public int compare(Article a1, Article a2) {
			int id1 = a1.getID();
			int id2 = a2.getID();
			
			return id1-id2;
		}	
	};
	
	
	public String toString() {
		return "[Article: "+ nom + " #"+ id + " qty: " + quantite + " prix: " + prix +"$]";
	}
	
	
	public void modifyQuantity(int x) {
		if((-x)>quantite)
			quantite = 0;
		else
			quantite += x;
	}

	@Override
	public void actualiser() {
		this.modifyQuantity(-1);
		
	}	
}
