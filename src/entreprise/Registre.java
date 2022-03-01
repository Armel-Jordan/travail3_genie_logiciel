package entreprise;

import java.util.Scanner;

import entreprise.stockagePersistant.StockagePersistant;
import entreprise.Inventaire;


public class Registre {
	private static Scanner scan = new Scanner(System.in);
    public String genererRapportJournalier(PointDeVente pointDeVente){
        return "\n\n voici votre rapport journalier :" + pointDeVente.toString();
    }
  

    
}
