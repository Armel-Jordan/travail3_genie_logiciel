package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.Article;
import entreprise.CarteCredit;
import entreprise.Client;
import entreprise.Espece;
import entreprise.Vente;

public class CarteCreditTest {

    
    private static Espece serviceEspece;
    private static Vente vente;
    private static double montant = 12000;
    private static List<Article> listeArticle = new ArrayList<>();
    private static Client client; 
    private static CarteCredit carteCredit;

    @BeforeAll
    public static void setUp(){
        serviceEspece = new Espece();
        client = new Client("co", "is", "51423422222", "montreaL", 99);
        vente = new Vente(montant, listeArticle, client);
        carteCredit = new CarteCredit(serviceEspece);
    }
    @Test
    void testPayer() {
        //arrange
        
        //act
        carteCredit.payer(vente);
        //assert
        assertEquals(true, vente.isPaye());
    }
}
