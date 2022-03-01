package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entreprise.Client;

class ClientTest {

	Client client; 
	String nom = "Nom";
	String prenom = "Nom";
	String telephone = "(000)000-0000";
	String adresse = "Nom";
	int noClient = 1;
	
	@BeforeEach
	void setUp() throws Exception {
		client = new Client(nom,prenom,telephone,adresse,noClient);
	}

	@AfterEach
	void tearDown() throws Exception {
		client = null;
	}

	@Test
	void testNom() {
		String newName = "NewName";
		client.setNom(newName);
		assertTrue(client.getNom() == newName);
	}
	@Test
	void testPrenom() {
		String newFirstName = "NewFirstName";
		client.setPrenom(newFirstName);
		assertTrue(client.getPrenom() == newFirstName);
	}
	@Test
	void testGoodTelephone() {
		//Test de chaque format
		String telephoneFormat[] = {"111-111-1111","(111) 111-1111","111 111 1111","111.111.1111","+1 111 111 1111"};
		
		for(String newTelephone : telephoneFormat ) 
		{
			if(client.getTelephone() != newTelephone && !client.TrysetTelephone(newTelephone)) 
			{
				fail("format "+newTelephone+" non fonctionel");
			}
		}
	}
	@Test
	void testBadTelephone() {
		String newTelephone = "BadTelephone";
		boolean t1 = client.TrysetTelephone(newTelephone);
		assertTrue(client.getTelephone() == telephone && !t1);
	}
	@Test
	void testAdresse() {
		String newAdresse = "NewAdresse";
		client.setAdresse(newAdresse);
		assertTrue(client.getAdresse() == newAdresse);
	}
}
