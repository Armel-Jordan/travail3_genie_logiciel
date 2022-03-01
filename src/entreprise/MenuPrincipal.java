package entreprise;

//import java.text.ParseException;
//import java.util.List;
import java.util.Scanner;

import entreprise.stockagePersistant.StockagePersistant;

public class MenuPrincipal implements IMenu {
    private static Scanner scan = new Scanner(System.in);

    static Registre registre = new Registre();
    static SystemePaiement systemePaiement = new SystemePaiement(null);
    static StockagePersistant stockagePersistant = StockagePersistant.getInstance();
    static GestionnaireUtilisateurs gestionnaireUtilisateurs = new GestionnaireUtilisateurs();
    static GestionnaireInventaire gestionnaireInventaire = new GestionnaireInventaire();

    public static void main(String[] args) {

        String choix;

        MenuPrincipal menu = new MenuPrincipal();

        boolean arret = false;

        do {
            menu.afficheMenu();

            choix = scan.nextLine();

            arret = menu.choixMenu(choix);

        } while (!arret);

        scan.close();
    }

    public boolean choixMenu(String entre) {
        int choix = Integer.parseInt(entre);

        switch (choix) // ce switch permet d'effectuer les actions relatives aux choix
        {
            case 1:
                // On peut passer le scanner au sous-menu s'il en a besoin.
                gestionnaireUtilisateurs.creationUtilisateur();
                break;
            case 2:
                ajouterPointDeVente();
                break;
            case 3:
                demarrerCreationVente();
                break;
            case 4:
                gestionnaireInventaire.gestionInventaire();
                break;
            case 5:
                stockagePersistant.afficherTousSousDirecteur();
                break;
            case 6:
                stockagePersistant.afficherTousClients();
                break;
            case 7:
                stockagePersistant.afficherTousPointVente();
                break;

            case 8:
                try {
                    systemePaiement.demarrerPaiement();
                    systemePaiement.choisirMoyenPaiement();
                } catch (Exception e) {
                    System.out.println("\t\tLe Format de Saisi est incorrect");
                }
                break;

            case 0:
                return true;

            default:

                System.out.println("Entrez un nombre entre 0 et 9");
                break;
        }
        return false;

    }

    private static void demarrerCreationVente() {
        System.out.println("Entrer un numero de point de vente\n");

        int numero = 0;
        do {
            System.out.println("\n\nVoici la liste de tous les points de ventes \n");
            stockagePersistant.afficherTousPointVente();
            numero = scan.nextInt();
        }while(stockagePersistant.selectionePointVente(numero) == null);

        PointDeVente pointDeVente = stockagePersistant.selectionePointVente(numero);
        pointDeVente.creerVente();
    }

    public void afficheMenu() {
        System.out.println("\t choisissez une option du menu");
        System.out.println("Option 1 : Gestionnaire utilisateur");
        System.out.println("Option 2 : Ajouter un point de vente");
        System.out.println("Option 3 : Ajouter une nouvelle vente");
        System.out.println("Option 4 : Gestion inventaire");
        System.out.println("Option 5: Afficher tous les Sous directeurs");
        System.out.println("Option 6: Afficher tous les Clients");
        System.out.println("Option 7: Afficher tous les Points de Vente");
        System.out.println("Option 8 : Payer une facture");
        System.out.println(" \n\nOption 0 : Quitter");
    }

    private static void ajouterPointDeVente() {
        PointDeVenteConcreteBuilder pointDeVenteConcreteBuilder = new PointDeVenteConcreteBuilder();
        BuilderDirector director = new BuilderDirector(pointDeVenteConcreteBuilder);
        director.construirePointDeVente(pointDeVenteConcreteBuilder);
        PointDeVente pointDeVente = pointDeVenteConcreteBuilder.getResult();
        stockagePersistant.getPointDeVentes().add(pointDeVente);
    }

}
