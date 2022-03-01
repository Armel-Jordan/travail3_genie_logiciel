package entreprise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected String adresse;
	
	//Constructeur
	public Personne(String nom, String prenom, String telephone, String adresse) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	//Get-Set
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	
	public String getTelephone() {return telephone;}
	public boolean TrysetTelephone(String telephone) 
	{
		Pattern pattern = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(telephone);
		
		boolean matchFound = matcher.find();
		
		if(matchFound) 
		{
			this.telephone = telephone; 
			return true;
		}
		
		return false;
	}
	
	public String getAdresse() {return adresse;}
	public void setAdresse(String adresse) {this.adresse = adresse;}
	

}
