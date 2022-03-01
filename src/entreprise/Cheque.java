package entreprise;

/*
*@Proxy
*/
public class Cheque implements IPaiement{

    private Espece espece = new Espece();

    public Cheque(Espece espece) {
        this.espece = espece;
    }

    @Override
    public void payer(Vente vente) {
        espece.payer(vente);  
        System.out.print("Vous avez choisi le cheque comme mode de paiement");
    }
    
}
