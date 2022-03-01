package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.Article;
import entreprise.Client;
import entreprise.Espece;
import entreprise.Vente;

public class EspeceTest {

	//on décrlare les variables static car l'annotation beforeAll pour la methode setup requiert cela
    private static Espece espece;
    private static Vente vente;
    private static double montant = 12000;
    private static List<Article> listeArticle = new ArrayList<>();
    private static Client client; 
    
    @BeforeAll
    public static void setUp(){
        espece = new Espece();
        client = new Client("co", "is", "51423422222", "montreaL", 99);
        vente = new Vente(montant, listeArticle, client);
    }
    @Test
    void testPayer() {
        //arrange
        //act
        espece.payer(vente);
        //assert
        assertEquals(true, vente.isPaye());
        //

    }
}
