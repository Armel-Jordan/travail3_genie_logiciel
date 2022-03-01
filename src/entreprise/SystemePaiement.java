package entreprise;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import entreprise.stockagePersistant.StockagePersistant;

public class SystemePaiement implements Observable {
    private static Scanner scan = new Scanner(System.in);
    protected IPaiement paiement;
    private ArrayList<Observateur> listeObservateur;
    Vente vente;
    public SystemePaiement(IPaiement paiement) {
        this.paiement = paiement;
    }

    public void demarrerPaiement() throws ParseException{
        
        //Registre registre = new Registre();
        //pattern singleton pour stockagepersistant
        StockagePersistant stockagePersistant = StockagePersistant.getInstance();
        String choixMenu;
        
        //boolean arret = false;
        try {
            do{
                System.out.println("\tPAIEMENT\n");
                System.out.println("\t -- VEUILLEZ SELECTIONNER entrer un numéro de Vente --  \n");
                stockagePersistant.afficherToutesVentes();
                choixMenu = scan.nextLine();
                vente = stockagePersistant.getVenteByNumero( Integer.parseInt(choixMenu));
                attacher(vente);
                
            }while(vente == null);
        }catch(NumberFormatException e){
            System.out.println("\t\tLe Format de Saisi est incorrect");
            System.out.println("   Pour le bon fonctionnement, Veuillez Rédemarrer l'Application");
        }
        scan.close();
    }

    public void choisirMoyenPaiement(){
       int choix;
        boolean arret = false;
        
        Espece serviceEspece = new Espece();
        CarteCredit carteCredit = new CarteCredit(serviceEspece);
        Cheque cheque = new Cheque(serviceEspece);
        do{
            afficheChoixPaiement();
            choix = Integer.parseInt(scan.nextLine());

            switch (choix) // ce switch permet d'effectuer les actions relatives aux choix
            {
            case 1:
                serviceEspece.payer(this.vente);
                break;
            case 2:
               cheque.payer(this.vente);
                break;
            case 3:
               carteCredit.payer(this.vente);
                break;

        }
        }while(choix!=1 || choix!=2 || choix!=3 );
    	    	
        avertir();
        detacher(listeObservateur.get(0));
        scan.close();
    }

    private void afficheChoixPaiement() {
        System.out.println("\t choisissez une option de paiement du menu");
        System.out.println("Option 1 : Espece");
        System.out.println("Option 2 : Cheque");
        System.out.println("Option 3:  Carte de credit");
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
    
}
