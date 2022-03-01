package entreprise;

public class Client extends Personne{

	private int noClient;
	public int getNoClient() {return noClient;}
	public void setNoClient(int noClient) {this.noClient = noClient;}
	
	//Constructeur de Client
	public Client(String nom, String prenom, String telephone, String adresse, int noClient) {
		super(nom, prenom, telephone, adresse);
		this.noClient = noClient;
	}
	
	
	@Override
	public String toString() 
	{
		return "No client: "+noClient+"\nPrenom: "+prenom+"\nNom: "+nom+"\nTelephone: "+telephone+"\nAdresse: "+adresse;
	}
}
