import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Universit� du Qu�bec � Montr�al (UQAM)
 * Cours : INF1120 - 010 - Hiver 2021
 * Travail pratique 3
 * <p>
 * ListeDesRepasVendus : Cette classe contient les donn�es des repas vendus,
 * et les m�thodes pour modifier ou acc�der aux donn�es.
 *
 * @author Votre Nom
 * @version 10 avril 2021
 */
public class ListeDesRepasVendus {

    // D�claration des constantes
    private static final int TAILLE = 30;
    private static final String NOM_FICHIER = "listeDesRepasVendus.txt";

    // D�claration des variables
    private static Repas[] lesRepasVendus = new Repas[TAILLE];
    private static float totalDesMontantsTtaux = 0;

    /**
     * Ajouter les repas vendus dans le tableau des repas vendus. Si le repas � ajouter existe
     * d�j� dans le tableau des repas (c'est-�-dire le m�me num�ro et la m�me sorte de pizza),
     * on ajoute le nombre de repas au nombre du repas existant. Sinon on ajoute le repas dans
     * le tableau des repas vendus en le pla�ant � la prochaine position vide de ce dernier.
     *
     * @param lesRepas le tableau des repas � ajouter
     */
    public static void ajouterLesRepasVendus(Repas[] lesRepas) {
        for (Repas repas : lesRepas) {
            if (repas != null) {
                for (int j = 0; j < lesRepasVendus.length; j++) {
                    if (lesRepasVendus[j] != null) {
                        if (repas.getNumero() == lesRepasVendus[j].getNumero() && repas.getSorte() == lesRepasVendus[j].getSorte()) {
                            lesRepasVendus[j].setNombre(lesRepasVendus[j].getNombre() + 1);
                            break;
                        }
                    } else {
                        lesRepasVendus[j] = repas;
                        break;
                    }
                }
            }
        }
    }

    public static void calculerLeMontantTotalTousLesRepasVendus(float montantTotal) {
        totalDesMontantsTtaux += montantTotal;
    }

    public static void afficherTousLesRepasVendus() {
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

        boolean repasVendu = false;
        for (Repas repas : lesRepasVendus) {
            if (repas != null) {
                repasVendu = true;
                System.out.println(repas.getNom() + "\t" + repas.getNombre());
            }
        }
        if(repasVendu) {
            ApplicationPrincipale.retourLigne();
            ApplicationPrincipale.afficherInformation("Le montant total des ventes", false);
            ApplicationPrincipale.afficherInformation("\t\t\t", false);
            ApplicationPrincipale.afficherInformation("" + totalDesMontantsTtaux, true);
        } else {
            ApplicationPrincipale.afficherInformation("Aucun repas vendu !", true);
        }
        ApplicationPrincipale.ligneSeparatrice();
        ApplicationPrincipale.retourLigne();
    }

    public static void ecrire() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(NOM_FICHIER, "UTF-8");
            for (Repas repas : lesRepasVendus) {
                if (repas != null) {
                    writer.println(repas.getNom() + "\t" + "(" + repas.obtenirDescriptionPizza() + ")" + "\t\t" + repas.getNombre());
                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex1) {
            System.exit(0);
        }
        writer.close();
    }


}
