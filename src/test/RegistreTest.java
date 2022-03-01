package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.BuilderDirector;
import entreprise.PointDeVente;
import entreprise.PointDeVenteConcreteBuilder;
import entreprise.Registre;


public class RegistreTest {
	
	//on décrlare les variables static car l'annotation beforeAll pour la methode setup requiert cela
    private static Registre registre;
    private static PointDeVenteConcreteBuilder builder;
    private static PointDeVente pointDeVente;
    private static  BuilderDirector director;
    
    @BeforeAll
    public static void setUp() {//on doit builder un point de vente car la mehode genererapportjournalier depend de ca
    	registre = new Registre();
        builder = new PointDeVenteConcreteBuilder();
        director = new BuilderDirector(builder);
        director.construirePointDeVente(builder); 
        pointDeVente = builder.getResult();
    }

    @Test
    void testGenererRapportJournalier() {
        //arrange
         //act
         String messageActuel = registre.genererRapportJournalier(pointDeVente);
         //assert
         assertTrue(messageActuel instanceof String);//on verifie si le type retourne par la methode est le bon
    }
}
