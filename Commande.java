public class Commande {

    public static final char[] MODE_PAIEMENT = new char[]{'C', 'D', 'R'};
    public static final String[] DESCRIPTIONS_MODE_PAIEMENT = new String[]{"Comptant", "Débit", "Crédit"};

    public static final int TAILLE = 30;

    private Client client;
    private Repas[] lesRepas;
    private char modePaiement;

    public Commande(Client client) {
        this.client = client;
        lesRepas = new Repas[TAILLE];
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Repas[] getLesRepas() {
        return lesRepas;
    }

    public void setLesRepas(Repas[] lesRepas) {
        this.lesRepas = lesRepas;
    }

    public char getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(char modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void ajouterRepas(Repas repas) {
        for (int i = 0; i < lesRepas.length; i++) {
            if (lesRepas[i] != null) {
                if (lesRepas[i].getNumero() == repas.getNumero() && lesRepas[i].getSorte() == repas.getSorte()) {
                    // Aussitot qu'un repas du tableau trouvé est
                    // identique à celui que je souhaite inserer, je mets
                    // à jour le nombre de ce repas et je quitte
                    // la boucle
                    lesRepas[i].setNombre(lesRepas[i].getNombre() + 1);
                    break;
                }
            } else {
                // Aussitot qu'un repas du tableau trouvé est null,
                // j'insere le repas a sa position et je quitte
                // la boucle
                lesRepas[i] = repas;
                break;
            }
        }
    }

    public String obtenirDescription() {
        String description = "";
        for (int i = 0; i < MODE_PAIEMENT.length; i++) {
            if (MODE_PAIEMENT[i] == this.modePaiement) {
                description = DESCRIPTIONS_MODE_PAIEMENT[i];
                break;
            }
        }
        return description;
    }
}
