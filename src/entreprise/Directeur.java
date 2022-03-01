package entreprise;

public class Directeur extends Employe {

	private static Directeur single_instance = null;
	public Directeur(String nom, String prenom, String telephone, String adresse, int identifiant) {
		super(nom, prenom, telephone, adresse, identifiant);
	}

	//il existe un unique directeur dans l'entreprise donc on utilise le singleton
	public static Directeur getInstance()
    {
        if (single_instance == null)
            single_instance = new Directeur("ismael", "jordan", "5145145555", "new york", 1);
 
        return single_instance;
    }
  
	
}
