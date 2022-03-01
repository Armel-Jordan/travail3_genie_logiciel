package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entreprise.Inventaire;
import entreprise.Article;

class InventaireTest {
	
	Inventaire inventaire;
	Article article;
	ArrayList<Article> articles;
	
	@BeforeEach
	void setUp() throws Exception {
		inventaire = new Inventaire();
		articles = inventaire.getArticles();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		inventaire = null;
	}
	
	@Test
	void testAddArticle() {
		article = new Article(4,"ski",5,200);
		inventaire.addArticle(article);
		
		assertTrue(articles.get(3) == article);
		
	}

	@Test
	void testRemoveArticle() {
		article = articles.get(0);
		inventaire.removeArticle(1);
		
		assertTrue(inventaire.searchArticle(article.getID()) == null);
	}
	
	@Test
	void testSearchArticle() {
		article = inventaire.searchArticle(1);
		assertTrue(articles.get(0) == article);	
	}
	
	@Test
	void testSearchArticleNull() {
		article = inventaire.searchArticle(5);
		assertTrue(article == null);	
	}
}
