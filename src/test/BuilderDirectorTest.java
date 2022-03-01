package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.BuilderDirector;
import entreprise.IPaiement;
import entreprise.PointDeVente;
import entreprise.PointDeVenteConcreteBuilder;

public class BuilderDirectorTest {
	
	//on d�crlare les variables static car l'annotation beforeAll pour la methode setup requiert cela
    private static PointDeVenteConcreteBuilder builder;
    private static PointDeVente pointDeVente;
    private  static BuilderDirector director;
    
    @BeforeAll
    public static void setUp() {
        builder = new PointDeVenteConcreteBuilder();
        director = new BuilderDirector(builder);
        
        pointDeVente = builder.getResult();
    }
    @Test
    void testConstruirePointDeVente() {
    	//arrange
    	//act
    	director.construirePointDeVente(builder);
    	//assert
    	assertTrue(builder.getResult() instanceof PointDeVente);
    }

}
