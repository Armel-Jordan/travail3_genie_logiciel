package entreprise.stockagePersistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entreprise.Client;
import entreprise.Commis;
import entreprise.PointDeVente;
import entreprise.SousDirecteur;
import entreprise.Vente;
import entreprise.Directeur;

public class StockagePersistant {

    private static StockagePersistant single_instance = null;
    private static Scanner scan = new Scanner(System.in);
    private List<PointDeVente> pointDeVentes = new ArrayList<PointDeVente>();
    private List<Client> clients = new ArrayList<Client>();
    private List<SousDirecteur>sousDirecteurs = new ArrayList<SousDirecteur>();
    private List<Commis> commis = new ArrayList<Commis>();
    private Directeur directeur;
    private PointDeVente pointVente;
    private List<Vente> ventes = new ArrayList<>();
    private List<Vente> ventesArchivees = new ArrayList<>();

    public String s;
    
    
    
    private StockagePersistant()
    {
        s = "Hello I am a string part of Singleton class";
    }

    public StockagePersistant(List<PointDeVente> pointDeVentes, List<Client> clients,
        List<SousDirecteur> sousDirecteurs, List<Commis> commis,
        List<Vente> ventes, List<Vente> ventesArchivees) {
        this.pointDeVentes = pointDeVentes;
        this.clients = clients;
        this.sousDirecteurs = sousDirecteurs;
        this.commis = commis;
        this.ventes = ventes;
        this.ventesArchivees = ventesArchivees;
    }
 
    public static StockagePersistant getInstance()
    {
        if (single_instance == null)
            single_instance = new StockagePersistant();
 
        return single_instance;
    }
  

    public static Scanner getScan() {
        return scan;
    }

    public static void setScan(Scanner scan) {
        StockagePersistant.scan = scan;
    }

    public List<PointDeVente> getPointDeVentes() {
        return pointDeVentes;
    }

    public void setPointDeVentes(List<PointDeVente> pointDeVentes) {
        this.pointDeVentes = pointDeVentes;
    }
    
    public void addPointDeVente(PointDeVente pdv) {
    	pointDeVentes.add(pdv);
    }
    

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<SousDirecteur> getSousDirecteurs() {
        return sousDirecteurs;
    }

    public void setSousDirecteurs(List<SousDirecteur> sousDirecteurs) {
        this.sousDirecteurs = sousDirecteurs;
    }

    public List<Commis> getCommis() {
        return commis;
    }
    
    public void setCommis(List<Commis> commis) {
        this.commis = commis;
    }   

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
    

    public List<Vente> getVentesArchivees() {
        return ventesArchivees;
    }

    public void setVentesArchivees(List<Vente> ventesArchivees) {
        this.ventesArchivees = ventesArchivees;
    }

    public void afficherTousClients(){
        if(clients.size() == 0){System.out.println("La liste de clients est vide \n");}

        for (int i =0; i< clients.size(); i++){
            System.out.print(clients.get(i).toString() + "\n");
        }
    }

    public void afficherTousPointVente(){
    	System.out.println(pointDeVentes.size());
        if(pointDeVentes.size() == 0)
        {
        	System.out.println("La liste des point de ventes est vide \n");	
        }        
        for (int i =0; i< pointDeVentes.size(); i++){
            System.out.print(pointDeVentes.get(i).toString() + "\n");
        }
    }

    public void afficherToutesVentes(){
        if(ventes.size() == 0){System.out.println("La liste de clients est vide \n");}

        for (int i =0; i< ventes.size(); i++){
            System.out.print(ventes.get(i).toString() + "\n");
        }
    }

    public void afficherTousSousDirecteur() 
    {
    	
        if(sousDirecteurs.size() == 0){System.out.println("La liste de clients est vide \n");}

        for (int i =0; i< sousDirecteurs.size(); i++){
            System.out.print(sousDirecteurs.get(i).toString() + "\n");
        }
    	
    }
    public Vente getVenteByNumero(int numeroFacture){

        for (int i = 0; i < ventes.size(); i++) {
            if (ventes.get(i).getId() == numeroFacture) {
                return ventes.get(i);
            }
        }
        System.out.println("Aucune facture ne correspond à ce numero");
        return null;
    }

    public Client getClientByNumero(int noClient){

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNoClient() == noClient) {
                return clients.get(i);
            }
        }
        System.out.println("Aucun client ne correspond à ce numero");
        return null;
    }

    public PointDeVente selectionePointVente(int numero) {
        for (int i = 0; i < this.pointDeVentes.size(); i++) {
            if (this.pointDeVentes.get(i).getId() == numero) 
                return pointDeVentes.get(i);
            }
        System.out.println("\nAucune point de vente ne correspond à ce numero \n" );
        return null;
    
    }
    
    
    public void setDirecteur(Directeur directeur) 
    {
    	this.directeur = directeur;    	
    }
    
    public Directeur getDirecteur() 
    {
    	return directeur;    	
    }
}


