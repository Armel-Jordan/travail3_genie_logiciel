package entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entreprise.stockagePersistant.StockagePersistant;

public final class PointDeVente {
	private static Scanner scan = new Scanner(System.in);
    private SousDirecteur sousDirecteur;
    private Commis commis;
    private Registre registre;
    private SystemePaiement systemePaiement;
    private String  adresse;
    private Inventaire inventaire;
    private int id;

      public PointDeVente() {
		
	}
    PointDeVente(SousDirecteur sousDirecteur, Commis commis, Registre registre, SystemePaiement systemePaiement,
     String  adresse){
        this.sousDirecteur = sousDirecteur;
        this.commis = commis;
        this.registre = registre;
        this.systemePaiement = systemePaiement;
        this.adresse = adresse;
        inventaire = new Inventaire();
        id = idCreator();
    }

    public SousDirecteur getSousDirecteur() {
        return sousDirecteur;
    }

    public void setSousDirecteur(SousDirecteur sousDirecteur) {
        this.sousDirecteur = sousDirecteur;
    }

    public Commis getCommis() {
        return commis;
    }

    public void setCommis(Commis commis) {
        this.commis = commis;
    }

    public Registre getRegistre() {
        return registre;
    }

    public void setRegistre(Registre registre) {
        this.registre = registre;
    }

    public SystemePaiement getSystemePaiement() {
        return systemePaiement;
    }

    public void setSystemePaiement(SystemePaiement systemePaiement) {
        this.systemePaiement = systemePaiement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }
    
    private static int idCreator() {
    	int i = 0;
    	i++;
    	return i;
    }
    
    public int getId() {
    	return id;
    }
    
    public String toString() {
		return "[ Sous-directeur: " +sousDirecteur+ " Comis :" + commis+ "Registre : " +registre+"Systeme de paiement :"+systemePaiement+
				     "Adresse :" +adresse+ "ID :" +id+ "Inventaire :" +inventaire+ "]";
    	
    }
    
    public void creerVente(){
		
		int id_client = 0;
		boolean arret = false;
		while(!arret)
		{
			System.out.println("Entrer le numéro client");
			try {
				
			id_client = scan.nextInt();	
			
			
			if(StockagePersistant.getInstance().getClientByNumero(id_client) != null) 
			{
			arret = true;	
			}
			}catch(Exception e)
			{
			}
		}
		
		
		
		StockagePersistant stockagePersistant = StockagePersistant.getInstance();

		Client client = stockagePersistant.getClientByNumero(id_client);
		
		int codeL;
		List<Article> panierClient = new ArrayList<>();
		try {
			do{
				
			System.out.println(inventaire.getArticles().toString());
			System.out.println("Entrer le code de l'article que vous voulez (différent de 0)");
			System.out.println("Option 0: Finir la sélection");
			
			codeL = scan.nextInt();	
			Article article = inventaire.searchArticle(codeL);
			if(article!=null) {
				panierClient.add(article);
			}else {
				System.out.println("article n'existe pas");
			}

		}while(codeL == 0);
		}catch(Exception e)
		{
			
			double montantTotal = calculerMontantTotal(panierClient);
			Vente vente = new Vente(montantTotal, panierClient, client);
			stockagePersistant.getVentes().add(vente);
			System.out.println(vente.toString());
	}		
		
}


	private double calculerMontantTotal(List<Article> panierClient) {
		double total = 0;
		for(Article article: panierClient) { 
			total += article.getPrice();
		}
		
		return total;
	}
		
	
 
}
