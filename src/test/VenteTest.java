package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.Article;
import entreprise.BuilderDirector;
import entreprise.Client;
import entreprise.IPaiement;
import entreprise.Observateur;
import entreprise.PointDeVente;
import entreprise.PointDeVenteConcreteBuilder;
import entreprise.Registre;
import entreprise.Vente;
import java.util.ArrayList;

public class VenteTest {

	//on d�crlare les variables static car l'annotation beforeAll pour la methode setup requiert cela
	private static Vente vente;
	private static ArrayList<Article> articles = new ArrayList<>();
	private LocalDateTime dateCreation;
    private LocalDateTime datePaiement;
    private boolean paye =false;
    private int id;
    private static Client client;
	

	@BeforeAll
	public static void setUp() {
		articles.add(new Article(98, "shors", 20, 100));
		client = new Client("jord", "kuibia","111-111-1111","quebec",237);
		vente = new Vente(100.0, articles,client);
		} 
	
	@Test
	public void actualiser() {
		//arrange
		boolean attendu = true;
		//act
		vente.actualiser();
		//assert
	}
	
	@Test
	public void getMontant() {
		 //arrange
        double attendu = 100.0;
        //act
        vente.setMontant(100.0);
        //assert
        assertEquals(vente.getMontant(), attendu);
	}
	
	@Test
	public void getId() {
		//arrange
		int attendu = 237 ;
		//act
		vente.setId(237);
		//assert
		assertTrue(vente.getId() == attendu);
	}

	
	@Test
	public void ispaye() {
		//arrange
        boolean resultatAttendu = true;
        //act
        vente.setPaye(true);

        //assert
        assertEquals(vente.isPaye(), resultatAttendu);
	}
	
	
	@Test
	public void getDateCreation() {

		//arrange
        LocalDateTime resultatAttendu = vente.getDateCreation();
        //act
        //assert
        assertTrue( resultatAttendu instanceof LocalDateTime);
	}
	
	@Test
	public void getClient() {
		//arrange
        //act
        Client client = vente.getClient();
        //assert
        assertTrue(client instanceof Client);
		
	}
	
	
	
	
	
}
