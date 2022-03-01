package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entreprise.BuilderDirector;
import entreprise.Commis;
import entreprise.IPaiement;
import entreprise.Inventaire;
import entreprise.PointDeVente;
import entreprise.PointDeVenteConcreteBuilder;
import entreprise.Registre;
import entreprise.SousDirecteur;
import entreprise.SystemePaiement;

public class PointDeVenteTest {

	//on décrlare les variables static car l'annotation beforeAll pour la methode setup requiert cela
    private static PointDeVenteConcreteBuilder builder;
    private static PointDeVente pointDeVente;
    private IPaiement paiement;
    private  static BuilderDirector director;
    
    @BeforeAll
    public static void setUp() {
        builder = new PointDeVenteConcreteBuilder();
        builder = new PointDeVenteConcreteBuilder();
        director = new BuilderDirector(builder);
        director.construirePointDeVente(builder);
        pointDeVente = builder.getResult();
    }
    @Test
    void testGetAdresse() {
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
    void testGetCommis() {
        //arrange
        //act
        Commis commisActuel = pointDeVente.getCommis();//on passe par le concrete builder puis son champ point de vente pour acceder a la methode
        //assert
        assertTrue(commisActuel instanceof Commis);//on verifie si le type retourne par la methode est le bon
    }
    

    @Test
    void testGetInventaire() {
        //arrange
        //act
        Registre registre = pointDeVente.getRegistre();
        //assert
        assertTrue(registre instanceof Registre);
    }

    @Test
    void testGetRegistre() {
        //arrange
        //act
        Registre registre = pointDeVente.getRegistre();
        //assert
        assertTrue(registre instanceof Registre);
    }

    @Test
    void testGetSousDirecteur() {
        //arrange
        //act
        SousDirecteur sousDirecteur = pointDeVente.getSousDirecteur();
        //assert
        assertTrue(sousDirecteur instanceof SousDirecteur);
    }

    @Test
    void testGetSystemePaiement() {
        //arrange
        //act
        SystemePaiement systemePaiement = pointDeVente.getSystemePaiement();
        //assert
        assertTrue(systemePaiement instanceof SystemePaiement);
    }

    @Test
    void testSetAdresse() {
         //arrange
         String resultatAttendu = "montreal";
         //act
         pointDeVente.setAdresse("montreal");
 
         //assert
         assertEquals(pointDeVente.getAdresse(), resultatAttendu);
    }

    @Test
    void testSetCommis() {
        //arrange
        Commis commis = new Commis("co", "is", "5142232455", "montreal", 2);
        //act
        pointDeVente.setCommis(commis);
        //assert
        assertEquals(pointDeVente.getCommis(), commis);
    }


    @Test
    void testSetInventaire() {
        //arrange
        Inventaire inventaire = new Inventaire();
        //act
        pointDeVente.setInventaire(inventaire);
        //assert
        assertEquals(pointDeVente.getInventaire(), inventaire);
    }

    @Test
    void testSetRegistre() {
        //arrange
        Registre registre = new Registre();
        //act
        pointDeVente.setRegistre(registre);
        //assert
        assertEquals(pointDeVente.getRegistre(), registre);
    }

    @Test
    void testSetSousDirecteur() {
         //arrange
         SousDirecteur sousDirecteur = new SousDirecteur("co", "is", "5142232455", "montreal", 2);
         //act
         pointDeVente.setSousDirecteur(sousDirecteur);
         //assert
         assertEquals(pointDeVente.getSousDirecteur(), sousDirecteur);
    }

    @Test
    void testSetSystemePaiement() {
        //arrange
        SystemePaiement systemePaiement = new SystemePaiement(paiement);
        //act
        pointDeVente.setSystemePaiement(systemePaiement);
        //assert
        assertEquals(pointDeVente.getSystemePaiement(), systemePaiement);
    }
}
