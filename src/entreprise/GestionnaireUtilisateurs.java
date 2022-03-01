package entreprise;


import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entreprise.stockagePersistant.StockagePersistant;

public class GestionnaireUtilisateurs implements IMenu
{
    
	static StockagePersistant stockagePersistant = StockagePersistant.getInstance();
    private List<Client> clients = stockagePersistant.getClients();
    private List<SousDirecteur>sousDirecteurs = stockagePersistant.getSousDirecteurs();
    private Directeur directeur = stockagePersistant.getDirecteur();
    private List<Commis> commis = stockagePersistant.getCommis();
	
    public GestionnaireUtilisateurs() 
    {
    	clients.add(new Client("NomClient_1","PrenomClient_1","adress_1","111-111-1111",1));
    	clients.add(new Client("NomClient_2","PrenomClient_2","adress_2","111-111-1111",1));
    	clients.add(new Client("NomClient_3","PrenomClient_3","adress_3","111-111-1111",1));
    	
    	commis.add(new Commis("NomCommis_1","PrenomCommis_1","adress_1","111-111-1111",1));
    	commis.add(new Commis("NomCommis_2","PrenomCommis_2","adress_2","111-111-1111",1));
    	commis.add(new Commis("NomCommis_3","PrenomCommis_3","adress_3","111-111-1111",1));
    	
    	sousDirecteurs.add(new SousDirecteur("NomSD_1","PrenomSD_1","adress_1","111-111-1111",1));
    	sousDirecteurs.add(new SousDirecteur("NomSD_2","PrenomSD_2","adress_2","111-111-1111",1));
    	sousDirecteurs.add(new SousDirecteur("NomSD_3","PrenomSD_3","adress_3","111-111-1111",1));
    	
    	
    	stockagePersistant.setClients(clients);
    	stockagePersistant.setCommis(commis);
    	stockagePersistant.setSousDirecteurs(sousDirecteurs);
    	
    	
    }
    
    public void creationUtilisateur() 
	{
		Scanner sc = new Scanner(System.in);
		boolean arret = false;
		while(!arret) 
		{
			sc = new Scanner(System.in);
			afficheMenu();
			String choix = sc.next();
			arret = choixMenu(choix);
			sc = new Scanner(System.in);
		}
	}
    
	public void afficheMenu() 
	{
		System.out.println("Menue de cr�ation d'utilisateur");
		System.out.println("1- créer un client");
		System.out.println("2- créer un Commis");
		System.out.println("3- Changer un Directeur");
		System.out.println("3- créer un sous Directeur");
		System.out.println("4- supprimer un client");
		System.out.println("5- supprimer un Commis");
		System.out.println("6- supprimer un sous Directeur");
		System.out.println("0- Quitter");
	}

	public boolean choixMenu(String entre) 
	{
		int choix = Integer.parseInt(entre);
		switch(choix) 
		{
			case 1:
				creationClient(creationPersonne());
			break;
			case 2:
				creationCommis(creationPersonne());
			break;
			case 3:
				creationDirecteur(creationPersonne());
			break;
			case 4:
				supClient();
				break;
			case 5:
				supCommis();
				break;
			case 6:
				supSousDirecteur();
				break;
			case 0:
				return true;
		}
		return false;
	}

	public Personne creationPersonne() 
	{
		String nom = "";
		String prenom = "";
		String adresse = "";
		String telephone = "";
		boolean arret = false;
		Scanner sc = new Scanner(System.in);
		
		while(!arret) 
		{
			System.out.println("Quelle est le prenom");
		    prenom = sc.next();
		    if(prenom == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else {arret = true;}
		}
	    
		arret = false;
	    while(!arret) 
	    {
			System.out.println("Quelle est le nom");
		    
		    nom = sc.next();
		    if(nom == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else {arret = true;}
	    }
	    
		arret = false;
	    while(!arret) 
	    {
			System.out.println("Quelle est l'adresse");
		   
		    adresse = sc.next();
		    if(adresse == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else {arret = true;}
	    }
	    
	    arret = false;
	    while(!arret) 
	    {
	    	System.out.println("Quelle est le num�ro de telephone");
		    
		    telephone = sc.next();
		    
		    Pattern pattern = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", Pattern.CASE_INSENSITIVE);
			
			Matcher matcher = pattern.matcher(telephone);
			boolean matchFound = matcher.find();
			
			String telephoneFormats[] = {"111-111-1111","(111) 111-1111","111 111 1111","111.111.1111","+1 111 111 1111"};
			if(!matchFound) 
			{
				System.out.println("Le format est invalide");
				System.out.println("Les format valide sont:");
				for(String format: telephoneFormats) 
				{
					System.out.println("\t" + format);					
				}
			}
			else if(telephone != null) 
			{
				arret = true;
			}else {System.out.println("Veuiller entrer une valeur");}
			
	    	
	    }
		return new Personne(nom,prenom,telephone,adresse);		
	}
	public void creationClient(Personne start) 
	{
		String entre ="";
		boolean arret = false;
		Scanner sc = new Scanner(System.in);
		while(!arret) 
		{
			System.out.println("Quelle est le num�ro de client");
			
		    entre = sc.next();
		    
		    if(entre == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else if(tryParseInt(entre) == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur num�rique");
		    }
		    else{arret = true;}
		}
		
		clients.add(new Client(start.nom,start.prenom,start.telephone,start.adresse,Integer.parseInt(entre)));
		
		stockagePersistant.setClients(clients);
	}
	public void creationDirecteur(Personne start) 
	{
		String entre ="";
		boolean arret = false;
		Scanner sc = new Scanner(System.in);
		while(!arret) 
		{
			System.out.println("Quelle est l'identifiant du directeur");
		    
		    entre = sc.next();
		    if(entre == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else if(tryParseInt(entre) == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur num�rique");
		    }
		    else{arret = true;}
		}
		stockagePersistant.setDirecteur(new Directeur(start.nom,start.prenom,start.telephone,start.adresse,Integer.parseInt(entre)));
	}
	public SousDirecteur creationSousDirecteur(Personne start) 
	{
		String entre ="";
		boolean arret = false;
		Scanner sc = new Scanner(System.in);
		while(!arret) 
		{
			System.out.println("Quelle est ll'identifiant du commis");
		    entre = sc.next();
		    if(entre == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else if(tryParseInt(entre) == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur num�rique");
		    }
		    else{arret = true;}
		}
		return new SousDirecteur("","","","",Integer.parseInt(entre));
	}
	public void creationCommis(Personne start) 
	{
		String entre ="";
		boolean arret = false;
		Scanner sc = new Scanner(System.in);
		while(!arret) 
		{
			System.out.println("Quelle est ll'identifiant du commis");
		   
		    entre = sc.next();
		    if(entre == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur");
		    }else if(tryParseInt(entre) == null) 
		    {
		    	System.out.println("Veuiller entrer une valeur num�rique");
		    }
		    else{arret = true;}
		}
		commis.add(new Commis(start.nom,start.prenom,start.telephone,start.adresse,Integer.parseInt(entre)));
		
		stockagePersistant.setCommis(commis);;
	}
	
	public void supClient() {
		Scanner sc = new Scanner(System.in);
		String entre;
		sc = new Scanner(System.in);
		Integer choix;
		int index = 1;
		boolean arret = false;
		boolean arretYN = false;
		
		while(!arret) 
		{
			index = 1;
			for (Client client : clients) 
			{
				System.out.println(index+"-" +client.prenom+" "+client.nom);	
				index++;
			}
			System.out.println("\n0-Quitter");
			System.out.println("Entrer le numéro du client a supprmier");
			entre = sc.next();
			
			choix = tryParseInt(entre);
			boolean paye = true;
			if(choix != null) 
			{
				if(choix != 0)
				{
					System.out.println("Voulez vous vraiment supprimer:");	
					System.out.println(clients.get(choix-1).toString());
				
					List<Vente> ventes = stockagePersistant.getVentes();
					
					for(Vente vente: ventes) 
					{
						if(vente.getClient().getNoClient() == clients.get(choix-1).getNoClient()) 
						{
							if(!vente.isPaye()) {
								System.out.println("Une vente du client n'est pas payer");
								paye =false;
							}
							
						}
					}
					if(paye) 
					{
						while(!arretYN)
						{
							System.out.println("O pour oui\nN pour non");	
							entre = sc.next();
							if(entre.equals("O")||entre.equals("o"))
							{
								arret = true;
								arretYN = true;
								
								clients.remove(choix-1);
							}
							else if(entre.equals("N")||entre.equals("n"))
							{
								arretYN = true;
							}
							else 
							{
								System.out.println("Entrer O ou N");	
							}
						}
					}else {arret = true;}
				}
			}
		}
	}
	public void supCommis() 
	{
		Scanner sc = new Scanner(System.in);
		String entre;
		sc = new Scanner(System.in);
		Integer choix;
		int index = 1;
		boolean arret = false;
		boolean arretYN = false;
		
		while(!arret) 
		{
			index = 1;
			for (Commis c : commis) 
			{
				System.out.println(index+"-" +c.prenom+" "+c.nom);	
				index++;
			}
			System.out.println("\n0-Quitter");
			System.out.println("Entrer le numéro du commis a supprmier");
			entre = sc.next();
			
			choix = tryParseInt(entre);
			
			if(choix != null) 
			{
				if(choix != 0)
				{
					System.out.println("Voulez vous vraiment supprimer:");	
					System.out.println(commis.get(choix-1).toString());
				
					while(!arretYN)
					{
						System.out.println("O pour oui\nN pour non");	
						entre = sc.next();
						if(entre.equals("O")||entre.equals("o"))
						{
							arret = true;
							arretYN = true;
							
							commis.remove(choix-1);
						}
						else if(entre.equals("N")||entre.equals("n"))
						{
							arretYN = true;
						}
						else 
						{
							System.out.println("Entrer O ou N");	
						}
					}
				}
				
				
				
			}else {arret = true;}
		}
	}
	public void supSousDirecteur() 
	{
		Scanner sc = new Scanner(System.in);
		String entre;
		sc = new Scanner(System.in);
		Integer choix;
		int index = 1;
		boolean arret = false;
		boolean arretYN = false;
		
		while(!arret) 
		{
			index = 1;
			for (SousDirecteur c : sousDirecteurs) 
			{
				System.out.println(index+"-" +c.prenom+" "+c.nom);	
				index++;
			}
			System.out.println("\n0-Quitter");
			System.out.println("Entrer le numéro du commis a supprmier");
			entre = sc.next();
			
			choix = tryParseInt(entre);
			
			if(choix != null) 
			{
				if(choix != 0)
				{
					System.out.println("Voulez vous vraiment supprimer:");	
					System.out.println(sousDirecteurs.get(choix-1).toString());
				
					while(!arretYN)
					{
						System.out.println("O pour oui\nN pour non");	
						entre = sc.next();
						if(entre.equals("O")||entre.equals("o"))
						{
							arret = true;
							arretYN = true;
							
							sousDirecteurs.remove(choix-1);
						}
						else if(entre.equals("N")||entre.equals("n"))
						{
							arretYN = true;
						}
						else 
						{
							System.out.println("Entrer O ou N");	
						}
					}
				}
			}else {arret = true;}
		}		
	}
	
	public static Integer tryParseInt(String someText) {
		   try {
		      return Integer.parseInt(someText);
		   } catch (NumberFormatException ex) {
		      return null;
		   }
		}
	
}
