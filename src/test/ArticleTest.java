package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//import java.util.Comparator;
import entreprise.Article;


class ArticleTest {
	
	private Article a1,a2,a3;

	@BeforeEach
	void setUp() throws Exception {
		a1 = new Article(1,"polo", 50, 10.00);
		a2 = new Article(2,"pantalon", 30, 20.00);
		a3 = new Article(1,"soulier", 10, 30.00);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		a1 = null;
		a2 = null;
		a3 = null;
	}
	
	@Test
	void testModifyQuantity() {
		//arrange
		int resultatAttendu = 0;
		int resultatAttendu2 = 20;
		int quantite = -30;
		//act
		a3.modifyQuantity(quantite);
		a2.modifyQuantity(quantite);
		a1.modifyQuantity(quantite);
		//assert
		assertEquals(a3.getQuantity(),resultatAttendu);
		assertEquals(a2.getQuantity(),resultatAttendu);
		assertEquals(a1.getQuantity(),resultatAttendu2);
	}
	
	//@Test
	

}
