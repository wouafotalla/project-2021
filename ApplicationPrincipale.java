import java.util.Scanner;

/**
 * WOUAFO TALLA JEAN GAEL
 * Travail pratique 3
 * <p>
 * Classe ApplicationPrincipale contient les m�thodes d�affichage de menus,
 * de saisies et de validations. �galement elle contient la m�thode "main".
 * Cette classe permet de tester toutes les autres classes en cr�ant des
 * objets et en appelant leurs m�thodes lors de l'application des r�gles
 * d'affaires li�es aux diff�rentes options du menu principal.
 *
 * @author JEAN GAEL
 * @version faire le 10 avril 2021
 */
public class ApplicationPrincipale {
    // D�claration des constantes

    public static final char OUI = 'O';
    public static final char OUI_1 = 'o';
    public static final char NON = 'N';

    public static final int ZERO = 0;
    public static final int CHOIX_1 = 1;
    public static final int CHOIX_4 = 4;
    public static final int DIX = 10;
    public static final int QUATRE_VINGT = 80;
    public static final String ENTREE_INVALIDE = "L'option choisie est invalide!";
    public static final String TELEPHONE_INVALIDE = "Le numéro de téléphone saisi est invalide!";
    public static final String ADRESSE_INVALIDE = "L'adresse saisie est invalide!";
    public static final String NUMERO_REPAS_INVALIDE = "Le numéro de repas est invalide!";
    public static final String NOMBRE_REPAS_INVALIDE = "Le nombre de repas est invalide!";
    public static final String SORTE_PIZZA_INVALIDE = "La sorte de pizza est invalide!";
    public static final String MODE_PAIEMENT_INVALIDE = "Le mode de paiement est invalide!";
    public static final String CHOIX_AJOUTER_REPAS_INVALIDE = "Le choix saisi est invalide!";

    // Déclaration des variables
    private static Scanner sc;

    public static final String MENU =
            "\n\n  *** Menu de choix ***\n"
                    + "  1. Facturer une commande\n"
                    + "  2. Afficher le nombre de repas vendus par type de repas \n"
                    + "     et le montant total de tous les repas vendus\n"
                    + "  3. Afficher les repas disponibles\n"
                    + "  4. Quitter le programme\n\n";

    static void afficherMessageBienvenue() {
        ligneSeparatrice();
        retourLigne();
        afficherInformation("Bienvenue dans le système de facturation de Pizza-Pour-Tous (PPT).", true);
    }

    static void afficherResumeProgramme() {
        afficherInformation("Ce programme permet de calculer la facture des commandes de repas de PPT.", false);
        retourLigne();
        ligneSeparatrice();
    }

    /* Methodes d'affichage de donnees */

    public static void retourLigne() {
        System.out.println();
    }

    public static void ligneSeparatrice() {
        for (int k = 0; k <= 100; k++) {
            afficherInformation("-", false);
        }
    }

    public static void afficherInformation(String data, boolean hasBreak) {
        System.out.print(data);
        if (hasBreak)
            retourLigne();
    }

    public static void afficherInformationAvecParametres(String format, Object... args) {
        System.out.format(format, args);
        ApplicationPrincipale.retourLigne();
    }

    /* Lecture des saisies */

    public static int demanderMenu() {
        afficherInformation("Entrez votre choix : ", false);
        //sc = new Scanner(System.in);
        int option = -1;
        try {
            option = Clavier.lireInt();
        } catch (Exception ignore) {
        }
        return option;
    }

    public static String demanderInfoClient(String message) {
        retourLigne();
        afficherInformation(message, false);
        //sc = new Scanner(System.in);
        String info;
        info = Clavier.lireString();

        return info;
    }

    public static String demanderSorteRepas(String message) {
        retourLigne();
        afficherInformation(message, false);
        //sc = new Scanner(System.in);
        String sortePizza;
        sortePizza = Clavier.lireString();
        //sc.reset();
        return sortePizza;
    }

    public static String demanderChoixNouveauRepas(String message) {
        retourLigne();
        afficherInformation(message, false);
        //sc = new Scanner(System.in);
        String nouveauRepas;
        nouveauRepas = Clavier.lireString();
        //sc.reset();
        return nouveauRepas;
    }

    public static String demanderModePaiement(String message) {
        retourLigne();
        afficherInformation(message, false);
        //sc = new Scanner(System.in);
        String mode;
        mode = Clavier.lireString();
        //sc.reset();
        return mode;
    }

    public static int demanderNumeroRepas(String message) {
        retourLigne();
        afficherInformation(message, false);
        //sc = new Scanner(System.in);
        int numero = -1;
        try {
            numero = Clavier.lireInt();
        } catch (Exception ignore) {
        }
        //sc.reset();
        return numero;
    }

    public static int demanderNombreRepas(String message) {
        retourLigne();
        afficherInformation(message, false);
        //sc = new Scanner(System.in);
        int nombre = -1;
        try {
            nombre = Clavier.lireInt();
        } catch (Exception ignore) {
        }
        //sc.reset();
        return nombre;
    }

    /* Validation des saisies */

    public static boolean validerNumeroRepas(int numeroRepas) {
        for (int repas : new int[]{3, 4, 8, 9, 13, 14}) {
            if (repas == numeroRepas)
                return true;
        }
        return false;
    }

    public static boolean validerSortePizza(char sortePizza) {
        for (char sorte : new char[]{'v', 'f', 't', 'e', 'm'}) {
            if (sorte == sortePizza)
                return true;
        }
        return false;
    }

    public static boolean validerReponseRepas(char reponseRepas) {
        for (char reponse : new char[]{'o', 'n'}) {
            if (reponse == reponseRepas)
                return true;
        }
        return false;
    }

    public static boolean validerModePaiement(char modePaiement) {
        for (char mode : new char[]{'C', 'D', 'R'}) {
            if (mode == modePaiement)
                return true;
        }
        return false;
    }

    /* Lecture et validation des saisies*/

    public static char lireEtValiderModePaiement() {
        String reponse = demanderModePaiement("Entrez le mode de paiement (C pour Comptant, D pour Débit, et R pour Crédit): ");
        while (reponse.length() != 1 || !validerModePaiement(reponse.charAt(0))) {
            retourLigne();
            afficherInformation(MODE_PAIEMENT_INVALIDE, false);
            reponse = demanderSorteRepas("Entrez le mode de paiement (C pour Comptant, D pour Débit, et R pour Crédit): ");
        }
        return reponse.charAt(0);
    }

    public static int lireEtValiderNumeroRepas() {
        int numeroRepas = demanderNumeroRepas("Entrez le numéro de repas (3, 4, 8, 9, 13, 14) : ");
        while (!validerNumeroRepas(numeroRepas)) {
            retourLigne();
            afficherInformation(NUMERO_REPAS_INVALIDE, false);
            numeroRepas = demanderNumeroRepas("Entrez le numéro de repas (3, 4, 8, 9, 13, 14) : ");
        }
        return numeroRepas;
    }

    public static int lireEtValiderNombreRepas() {
        int numbreRepas = demanderNombreRepas("Entrez le nombre de repas (supérieur à 0) : ");
        while (numbreRepas < 1) {
            retourLigne();
            afficherInformation(NOMBRE_REPAS_INVALIDE, false);
            numbreRepas = demanderNombreRepas("Entrez le nombre de repas (supérieur à 0) : ");
        }
        return numbreRepas;
    }

    public static char lireEtValiderSortePizza() {
        String sortePizza = demanderSorteRepas("Entrez la sorte de pizza (v ou V, f ou F, t ou T, e ou E, m ou M) : ").toLowerCase();
        while (sortePizza.length() != 1 || !validerSortePizza(sortePizza.charAt(0))) {
            retourLigne();
            afficherInformation(SORTE_PIZZA_INVALIDE, false);
            sortePizza = demanderSorteRepas("Entrez la sorte de pizza (v ou V, f ou F, t ou T, e ou E, m ou M) : ").toLowerCase();
        }
        return sortePizza.charAt(0);
    }

    public static char lireEtValiderChoixNouveauRepas() {
        String reponse = demanderChoixNouveauRepas("Désirez-vous ajouter un autre repas (O ou o = OUI, N ou n = NON)? : ").toLowerCase();
        while (reponse.length() != 1 || !validerReponseRepas(reponse.charAt(0))) {
            retourLigne();
            afficherInformation(CHOIX_AJOUTER_REPAS_INVALIDE, false);
            reponse = demanderChoixNouveauRepas("Désirez-vous ajouter un autre repas (O ou o = OUI, N ou n = NON)? : ").toLowerCase();
        }
        return reponse.charAt(0);
    }

    public static int lireEtValiderMenu() {
        afficherInformation(MENU, true);
        int choix = demanderMenu();
        while (choix < 1 || choix > 4) {
            afficherInformation(ENTREE_INVALIDE, true);
            retourLigne();
            choix = demanderMenu();
        }
        return choix;
    }

    public static String lireEtValiderTelephoneClient() {
        String telephone = demanderInfoClient("Entrez le numéro de téléphone du client (format : NNN NNN-NNNN): ");
        while (telephone.length() != 12 || telephone.charAt(3) != ' ' || telephone.charAt(7) != '-') {
            retourLigne();
            afficherInformation(TELEPHONE_INVALIDE, false);
            telephone = demanderInfoClient("Entrez le numéro de téléphone du client (format : NNN NNN-NNNN): ");
        }
        return telephone;
    }

    public static String lireEtValiderAdresseClient() {
        String adresse = demanderInfoClient("Entrez l'adresse du client (entre 10 et 80 caractères inclusivement): ");
        while (adresse.length() < 10 || adresse.length() > 80) {
            retourLigne();
            afficherInformation(ADRESSE_INVALIDE, false);
            adresse = demanderInfoClient("Entrez l'adresse du client (entre 10 et 80 caractères inclusivement): ");
        }
        return adresse;
    }

    public static void main(String[] args) {

        // D�claration des variables
        boolean sortie = false;

        int choixMenu;
        int numeroRepasSaisi;
        int nombreRepasSaisi;
        char sortePizza;
        char modePaiement;
        char reponse;
        String nomRepas;
        float prixRepas;

        String numeroTelephoneClient;
        String adresseClient;

        // Les objets � cr�er
        Client unClient;
        Repas unRepas;
        Commande uneCommande;
        Facture uneFacture;

        afficherMessageBienvenue();

        afficherResumeProgramme();

        ListeDesRepasDisponibles.lire();

        do {
            choixMenu = lireEtValiderMenu();
            switch (choixMenu) {

                case 1:
                    numeroTelephoneClient = lireEtValiderTelephoneClient();
                    adresseClient = lireEtValiderAdresseClient();
                    unClient = new Client(adresseClient, numeroTelephoneClient);
                    uneCommande = new Commande(unClient);
                    do {
                        numeroRepasSaisi = lireEtValiderNumeroRepas();
                        sortePizza = lireEtValiderSortePizza();
                        nombreRepasSaisi = lireEtValiderNombreRepas();
                        nomRepas = ListeDesRepasDisponibles.obtenirNomRepas(numeroRepasSaisi);
                        prixRepas = ListeDesRepasDisponibles.obtenirPrixRepas(numeroRepasSaisi);
                        unRepas = new Repas(numeroRepasSaisi, nomRepas, sortePizza, nombreRepasSaisi, prixRepas);
                        uneCommande.ajouterRepas(unRepas);
                        reponse = lireEtValiderChoixNouveauRepas();
                    } while (reponse == OUI || reponse == OUI_1);
                    modePaiement = lireEtValiderModePaiement();
                    uneCommande.setModePaiement(modePaiement);
                    uneFacture = new Facture(uneCommande);
                    uneFacture.calculerSousTotal();
                    uneFacture.calculerTPS();
                    uneFacture.calculerTVQ();
                    uneFacture.afficherFacture();
                    ListeDesRepasVendus.ajouterLesRepasVendus(uneCommande.getLesRepas());
                    ListeDesRepasVendus.calculerLeMontantTotalTousLesRepasVendus(uneFacture.getTotal());
                    break;

                case 2:
                    ListeDesRepasVendus.afficherTousLesRepasVendus();
                    break;

                case 3:
                    ListeDesRepasDisponibles.afficherLesRepasDisponibles();
                    break;

                case 4:
                    ListeDesRepasVendus.ecrire();
                    System.out.println("Merci et à la prochaine !");
                    sortie = true;
            }

        } while (!sortie);

    }

}
