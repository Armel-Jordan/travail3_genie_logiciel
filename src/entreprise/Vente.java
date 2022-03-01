 package entreprise;

import java.time.LocalDateTime;
import java.util.*;

public class Vente implements Observateur, Observable {

    private static int venteId = 1;
    private int id;
    private double montant;
    private LocalDateTime dateCreation;
    private LocalDateTime datePaiement;
    private List<Article> listeArticle;
    private ArrayList<Observateur> listeObservateur;
    private boolean paye =false;
    private Client client;
    
    public Vente (double montant, List<Article> listeArticle, Client client){
        this.id = venteId++;
        this.montant = montant;
        this.client = client;
        this.listeArticle = listeArticle;
        this.dateCreation = LocalDateTime.now();
        this.paye = false;
        for (Article art : listeArticle){
            attacher(art);
        }
    }

    @Override
    public void actualiser() {
        if (this.paye == false){
            this.setPaye(true);
            avertir();
        }        
    }

    @Override
    public void attacher(Observateur obs) {
        listeObservateur.add(obs);
        
    }

    @Override
    public void detacher(Observateur obs) {
        listeObservateur.remove(obs);
        
    }

    @Override
    public void avertir() {
        for (int i=0;i<listeObservateur.size();i++){
            Observateur obs = listeObservateur.get(i);
            obs.actualiser();
        }
        
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getId() {
        return id;
    }
    
    

    public boolean isPaye() {
        return paye;
    }

    public List<Article> getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(List<Article> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
        this.datePaiement = LocalDateTime.now();
    }
    public Client getClient() 
    {
    	return client;
    }
    public String toString() {
		return  "[montant"+ montant +"liste d aticle :"+ listeArticle+ "Client: "+ client +"]";
    	
    }

	public void setId(int id) {
		this.id = id;
	}
    
    
}