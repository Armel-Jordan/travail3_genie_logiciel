package entreprise;
/*
*@Service
*/

import entreprise.stockagePersistant.StockagePersistant;

public class Espece implements IPaiement {
    StockagePersistant stockagePersistant = StockagePersistant.getInstance();

    public void payer(Vente vente) {
        vente.setPaye(true);
        stockagePersistant.getVentes().remove(vente);//on enleve la vente qui vient d'etre payee de la liste des ventes en cours
        stockagePersistant.getVentesArchivees().add(vente);// on l'ajoute dans les ventes archivees
    }

    
}
