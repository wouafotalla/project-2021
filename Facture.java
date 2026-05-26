import java.text.SimpleDateFormat;
import java.util.Date;

public class Facture {
    public static final float TVQ = 0.09975f;
    public static final float TPS = 0.05f;
    public static final String nomEntreprise = "Pizza-Pour-Tous";
    public static final String adresseEntreprise = "5252 rue Matata, Hakuna, QC";
    public static final String telephoneEntreprise = "(514) 848-7733";

    private static int numero;
    private Commande commande;
    private float sousTotal;
    private float montantTPS;
    private float montantTVQ;
    private float total;

    public Facture(Commande commande) {
        this.commande = commande;
        numero += 1;
    }

    public float getTotal() {
        return total;
    }

    public void calculerSousTotal() {
        Repas[] repasCommandes = this.commande.getLesRepas();
        for (Repas repas : repasCommandes) {
            if (repas != null) {
                sousTotal += repas.getNombre() * repas.getPrix();
            }
        }
    }

    public void calculerTPS() {
        montantTPS = sousTotal * TPS;
    }

    public void calculerTVQ() {
        montantTVQ = sousTotal * TVQ;
    }

    public void calculerTotal() {
        total = sousTotal + montantTPS + montantTVQ;
    }

    public void afficherFacture() {
        calculerTotal();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.ligneSeparatrice();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.afficherInformation(Facture.nomEntreprise, true);
        ApplicationPrincipale.afficherInformation(Facture.telephoneEntreprise, false);
        ApplicationPrincipale.afficherInformation("\t\t\t\t\t\t" + Facture.adresseEntreprise, true);
        ApplicationPrincipale.ligneSeparatrice();

        String dateCommande = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.afficherInformation("Facture N° " + numero, false);
        ApplicationPrincipale.afficherInformation("\t\t\tDate et heure: " + dateCommande, true);
        ApplicationPrincipale.afficherInformation("Téléphone: " + this.commande.getClient().getTelephone(), false);
        ApplicationPrincipale.afficherInformation("\t\tAdresse du client : " + this.commande.getClient().getAdresse(), true);
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.retourLigne();
        displayOrderEntries();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.afficherInformation("Le mode de paiement : " + this.commande.obtenirDescription(), true);
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.afficherInformation("Sous-total : ", false);
        ApplicationPrincipale.afficherInformationAvecParametres("\t\t\t%.2f %s", sousTotal, "$");
        ApplicationPrincipale.afficherInformation("Montant TPS : ", false);
        ApplicationPrincipale.afficherInformationAvecParametres("\t\t\t%.2f %s", montantTPS, "$");
        ApplicationPrincipale.afficherInformation("Montant TVQ : ", false);
        ApplicationPrincipale.afficherInformationAvecParametres("\t\t\t%.2f %s", montantTVQ, "$");
        ApplicationPrincipale.afficherInformation("Montant total : ", false);
        ApplicationPrincipale.afficherInformationAvecParametres("\t\t\t%.2f %s", total, "$");
        ApplicationPrincipale.ligneSeparatrice();
        ApplicationPrincipale.retourLigne();
        ApplicationPrincipale.afficherInformation("Merci pour votre confiance!", true);
        ApplicationPrincipale.retourLigne();
    }

    private void displayOrderEntries() {
        for (Repas repas : commande.getLesRepas()) {
            if (repas != null) {
                ApplicationPrincipale.afficherInformation(repas.obtenirDescription(), true);
            }
        }
    }

}
