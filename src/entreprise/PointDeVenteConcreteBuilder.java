package entreprise;

import java.util.Scanner;

public class PointDeVenteConcreteBuilder implements IPointDeVenteBuilder{

    private PointDeVente pointDeVente;
    private static Scanner scan = new Scanner(System.in);
    //on possède une classe permettant de faire les opérations de création et de suppression de personne
    public GestionnaireUtilisateurs gestionnaireUtilisateurs = new GestionnaireUtilisateurs();

    public PointDeVenteConcreteBuilder() {
       this.reset();
    }

    @Override
    public void reset() {
        this.pointDeVente = new PointDeVente();
    }

    @Override
    public void construireSousdirecteur() {
        pointDeVente.setSousDirecteur(gestionnaireUtilisateurs.creationSousDirecteur(gestionnaireUtilisateurs.creationPersonne()));
    }

    @Override
    public void construireCommis() {
        gestionnaireUtilisateurs.creationCommis(gestionnaireUtilisateurs.creationPersonne());
    }
    @Override
    public void construireRegistre() {
        pointDeVente.setRegistre(new Registre());
    }

    @Override
    public void construireSystemePaiement() {
        //pointDeVente.setSystemePaiement(new SystemePaiement());
    }


    @Override
    public void construireAdresse() {
        System.out.println("Entrer Votre adresse\n");

        String adresse;
        do {
            adresse = scan.nextLine();
        }while(adresse.isEmpty());
        pointDeVente.setAdresse(adresse);
    }


    @Override
    public void construireInventaire() {
       pointDeVente.setInventaire(new Inventaire());
    }

    //méthode retournant le point de vente une fois construit
    public PointDeVente getResult(){
        return new PointDeVente(this.pointDeVente.getSousDirecteur(),
         this.pointDeVente.getCommis(),this.pointDeVente.getRegistre(),
         this.pointDeVente.getSystemePaiement(),
         this.pointDeVente.getAdresse());
    }
}
