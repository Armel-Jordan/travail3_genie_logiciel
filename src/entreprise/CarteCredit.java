package entreprise;
/*
*@Proxy
*/
public class CarteCredit implements IPaiement{
    private Espece espece = new Espece();

    public CarteCredit(Espece espece) {
        this.espece = espece;
    }

    @Override
    public void payer(Vente vente) {
        espece.payer(vente);//d'apres le pattern proxy, on utilise la methode du service (Espece)
        System.out.print("Vous avez choisi la carte de credit comme mode de paiement");
    }
}
