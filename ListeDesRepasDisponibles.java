
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Universit� du Qu�bec � Montr�al (UQAM)
 * Cours : INF1120 - 010 - Hiver 2021
 * Travail pratique 3
 * <p>
 * ListeDesRepasDisponibles : Cette classe contient les donn�es des diff�rents repas
 * offerts par le restaurant Pizza-Pour-Tous, et les m�thodes pour modifier
 * ou acc�der aux donn�es.
 *
 * @author Votre Nom
 * @version 10 avril 2021
 */
public class ListeDesRepasDisponibles {

    // D�claration des constantes
    private static final int TAILLE = 6;
    private static final String NOM_FICHIER = "listeDesRepasDisponibles.txt";


    // D�claration des variables
    private static Repas tableauDesRepasDisponibles[] = new Repas[TAILLE];


    /**
     * Lire les diff�rents repas offerts par le restaurant � partir
     * du fichier "listeDesRepasDisponibles.txt" et les mettre dans
     * le tableau des repas disponibles.
     */
    public static void lire() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(NOM_FICHIER));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String[] lignes = sb.toString().split("\n");
            for (int i = 0; i < lignes.length; i++) {
                String[] parts = lignes[i].split("\\|");
                Repas repas = new Repas(Integer.parseInt(parts[0]), parts[1], Float.parseFloat(parts[2]));
                tableauDesRepasDisponibles[i] = repas;
            }
            br.close();
        } catch (IOException ex1) {
            System.out.println(ex1.toString());
        }
    }

    /**
     * Obtenir le nom de repas � partir du num�ro de repas.
     *
     * @param numeroRepas le num�ro de repas
     * @return le nom de repas
     */
    public static String obtenirNomRepas(int numeroRepas) {
        String nomRepas = "";

        for (Repas repas : tableauDesRepasDisponibles) {
            if (repas.getNumero() == numeroRepas) {
                nomRepas = repas.getNom();
                break;
            }
        }
        return nomRepas;
    }


    /**
     * Obtenir le prix de repas � partir du num�ro de repas.
     *
     * @param numeroRepas le num�ro de repas
     * @return le prix de repas
     */
    public static float obtenirPrixRepas(int numeroRepas) {
        float prixRepas = 0;
        for (Repas repas : tableauDesRepasDisponibles) {
            if (repas.getNumero() == numeroRepas) {
                prixRepas = repas.getPrix();
                break;
            }
        }
        return prixRepas;
    }

    /**
     * Affiche les repas disponibles.
     */
    public static void afficherLesRepasDisponibles() {
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.ligneSeparatrice();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.afficherInformation(Facture.nomEntreprise, false);
        ApplicationPrincipale.afficherInformation("\t\t\t", false);
        ApplicationPrincipale.afficherInformation(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()), true);
        ApplicationPrincipale.afficherInformation(Facture.telephoneEntreprise, false);
        ApplicationPrincipale.afficherInformation("\t\t\t", false);
        ApplicationPrincipale.afficherInformation(Facture.adresseEntreprise, true);

        ApplicationPrincipale.ligneSeparatrice();
        ApplicationPrincipale.retourLigne();

        for (Repas repas : tableauDesRepasDisponibles) {
            System.out.println(repas.getNumero() + "\t" + repas.getNom() + "\t" + repas.getPrix());
        }
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.ligneSeparatrice();
        ApplicationPrincipale.retourLigne();
    }
}
