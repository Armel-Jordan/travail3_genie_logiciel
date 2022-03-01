package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.Article;
import entreprise.Cheque;
import entreprise.Client;
import entreprise.Espece;
import entreprise.Vente;

public class ChequeTest {

    private static Espece serviceEspece;
    private static Vente vente;
    private static double montant = 12000;
    private static List<Article> listeArticle = new ArrayList<>();
    private static Client client; 
    private static Cheque cheque;

    @BeforeAll
    public static void setUp(){
        serviceEspece = new Espece();
        client = new Client("co", "is", "51423422222", "montreaL", 99);
        vente = new Vente(montant, listeArticle, client);
        cheque = new Cheque(serviceEspece);
    }
    @Test
    void testPayer() {
        //arranges
        //act
        cheque.payer(vente);
        //assert
        assertEquals(true, vente.isPaye());
    }
}
