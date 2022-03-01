package entreprise;

/**
 * BuilderDirector
 */
public class BuilderDirector {

    private IPointDeVenteBuilder builder;

    public BuilderDirector(IPointDeVenteBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(IPointDeVenteBuilder builder) {
        this.builder = builder;
    }

    public void construirePointDeVente(IPointDeVenteBuilder builder) {
        builder.reset();
        builder.construireSousdirecteur();//on construit le sous directeur du nouveau point de vente
        builder.construireCommis();//on construit le commis 
        builder.construireRegistre();
        builder.construireInventaire();
        builder.construireAdresse();
        builder.construireSystemePaiement();
    }
}