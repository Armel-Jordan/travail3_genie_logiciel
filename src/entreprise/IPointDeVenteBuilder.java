package entreprise;

public interface IPointDeVenteBuilder {

    void reset();
    void construireSousdirecteur();
    void construireCommis();
    void construireRegistre();
    void construireSystemePaiement();
    void construireAdresse();
    void construireInventaire();
}
