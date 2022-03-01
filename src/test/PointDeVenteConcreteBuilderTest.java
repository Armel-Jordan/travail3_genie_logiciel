package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.BuilderDirector;
import entreprise.Commis;
import entreprise.Inventaire;
import entreprise.PointDeVente;
import entreprise.PointDeVenteConcreteBuilder;
import entreprise.Registre;
import entreprise.SousDirecteur;
import entreprise.SystemePaiement;

public class PointDeVenteConcreteBuilderTest {
    
	//on décrlare les variables static car l'annotation beforeAll pour la methode setup requiert cela
    private static PointDeVenteConcreteBuilder builder;
    private static PointDeVente pointDeVente;
    private  static BuilderDirector director;
    
    @BeforeAll
    public static void setUp() {
        builder = new PointDeVenteConcreteBuilder();
        director = new BuilderDirector(builder);
        director.construirePointDeVente(builder);
        pointDeVente = builder.getResult();
    }
    
    @Test
    void testConstruireAdresse() {
        //arrange
        boolean resultatAttendu = true;
        //act
        String adresseActuelle = pointDeVente.getAdresse();

        boolean resultatActuel = !adresseActuelle.isEmpty() || !adresseActuelle.equals("");
        //assert
        assertEquals(resultatActuel, resultatAttendu);
        assertTrue(adresseActuelle instanceof String);
    }
    
    @Test
    void testConstruireCommis() {
         //arrange
         //act
         Commis commisActuel = pointDeVente.getCommis();//on passe par le concrete builder puis son champ point de vente pour acceder a la methode
         //assert
         assertTrue(commisActuel instanceof Commis);//on verifie si le type retourne par la methode est le bon
    }

    @Test
    void testConstruireInventaire() {
        //arrange
         //act
         Inventaire inventaire = pointDeVente.getInventaire();
         //assert
         assertTrue(inventaire instanceof Inventaire);
    }

    @Test
    void testConstruireRegistre() {
        //arrange
        //act
        Registre registre = pointDeVente.getRegistre();
        //assert
        assertTrue(registre instanceof Registre);
    }

    @Test
    void testConstruireSousdirecteur() {
        //arrange
        //act
        SousDirecteur sousDirecteur = pointDeVente.getSousDirecteur();
        //assert
        assertTrue(sousDirecteur instanceof SousDirecteur);
    }

    @Test
    void testConstruireSystemePaiement() {
        //arrange
        //act
        SystemePaiement systemePaiement = pointDeVente.getSystemePaiement();
        //assert
        assertTrue(systemePaiement instanceof SystemePaiement);
    }

    @Test
    void testGetResult() {
        //arrange
        //act
        //assert
         assertTrue(pointDeVente instanceof PointDeVente);
    }

    @Test
    void testReset() {
        //arrange
        //act
        //asserts
        //assertTrue(builder.reset() instanceof PointDeVenteConcreteBuilder);
    }
}
