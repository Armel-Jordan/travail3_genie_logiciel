package entreprise;

import java.util.List;
import java.util.Scanner;
import entreprise.stockagePersistant.StockagePersistant;


public class GestionnaireInventaire implements IMenu {
	
	private static Scanner scan = new Scanner(System.in);
	static StockagePersistant stockagePersistant = StockagePersistant.getInstance();
	List<PointDeVente> listePointDeVente = stockagePersistant.getPointDeVentes();
	
	public GestionnaireInventaire() {	
	}
	
	public void gestionInventaire() 
	{
		Scanner sc = new Scanner(System.in);
		boolean arret = false;
		while(!arret) 
		{
			sc = new Scanner(System.in);
			afficheMenu();
			String choix = sc.next();
			arret = choixMenu(choix);
			sc = new Scanner(System.in);
		}
	}
	
	public void afficheMenu() 
	{
		System.out.println("Menu gestion inventaire");
		System.out.println("1- Ajouter nouvel article");
		System.out.println("2- Supprimer article");
		System.out.println("3- Afficher inventaire");
		System.out.println("0- Quitter");
	}
	
	public boolean choixMenu(String entre) 
	{
		int choix = Integer.parseInt(entre);
		switch(choix) 
		{
			case 1:
				saisirNouvelArticle();
			break;
			case 2:
				retirerArticle();
			break;
			case 3:
				afficherInventaire();
			break;
			case 0:
				return true;
		}
		return false;
	}
	
	public PointDeVente searchPointDeVente(int id) {
		for (PointDeVente pdv : listePointDeVente) {
			if(pdv.getId() == id)
				return pdv;
		}
		return null;
	}
	
	
	public void saisirNouvelArticle() {
		
		
		System.out.println("Saisir l'id du point de vente");
		int idPointDeVente = scan.nextInt();
		PointDeVente pdv = searchPointDeVente(idPointDeVente);
		
		if(pdv == null)
			System.out.println("point de vente non-existant");
		else 
		{
			int id;
			String nom;
			double price;
			int quantity;
			Inventaire inv = pdv.getInventaire();
			
			System.out.println("Saisir l'id de l'article");
			id = scan.nextInt();
			
			Article nouvelArticle = inv.searchArticle(id);
			
			if(nouvelArticle == null) {
				System.out.println("Identifiant valide");
				System.out.println("Saissir nom de l'article");
				nom = scan.next(); 
				
				System.out.println("Saisir quantite");
				quantity = scan.nextInt();
				
				System.out.println("Saisir prix");
				price = scan.nextDouble();
				
				nouvelArticle = new Article(id,nom,quantity,price);
				inv.addArticle(nouvelArticle);
			}
			else {
				System.out.println("Cet identifiant est deja utilise, reesaye");
			}
		}
		

			
		
		
	}

	public void retirerArticle() {
		
		
		System.out.println("Saissir l'id du point de vente");
		int idPointDeVente = scan.nextInt();
		PointDeVente pdv = searchPointDeVente(idPointDeVente);
		if(pdv == null)
			System.out.println("point de vente non-existant");
		else 
		{
			int id;
			Inventaire inv = pdv.getInventaire();
			
			System.out.println("Saissir l'id de l'article");
			id = scan.nextInt();
			
			Article withdrawnArticle = inv.searchArticle(id);
			
			if(withdrawnArticle == null) {
				System.out.println("Identifiant invalide, reesaye");
			}
			else {
				inv.removeArticle(id);
				System.out.println("Article supprime");
			}
		}
		
		
	}
	
	public void afficherInventaire() {
		
		System.out.println("Saisir l'id du point de vente");
		int idPointDeVente = scan.nextInt();
		PointDeVente pdv = searchPointDeVente(idPointDeVente);
		if(pdv == null)
			System.out.println("point de vente non-existant");
		else 
		{
			Inventaire inv = pdv.getInventaire();
			
			System.out.println(inv);
		}
		
	}
}
