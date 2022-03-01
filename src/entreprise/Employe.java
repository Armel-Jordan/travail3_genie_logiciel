package entreprise;

public class Employe extends Personne {
	
	protected int identifiant;
	public int getIdentifiant() {return identifiant;}
	public void setIdentifiant(int identifiant) {this.identifiant = identifiant;}

	public Employe(String nom, String prenom, String telephone, String adresse, int identifiant) {
		super(nom, prenom, telephone, adresse);
		this.identifiant = identifiant;
	}
}
