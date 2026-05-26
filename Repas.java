public class Repas {

    public static final char[] SORTES_PIZZA = new char[]{'v', 'f', 't', 'e', 'm'};
    public static final String[] DESCRIPTIONS_PIZZA = new String[]{"Végétarienne", "Fromage", "Toute garnie", "Épinards", "Fruits de mer"};
    private int numero;
    private String nom;
    private char sorte;
    private int nombre;
    private float prix;

    public Repas(int numero, String nom, float prix) {
        this.numero = numero;
        this.nom = nom;
        this.prix = prix;
    }

    public Repas(int numero, String nom, char sorte, int nombre, float prix) {
        this.numero = numero;
        this.nom = nom;
        this.sorte = sorte;
        this.nombre = nombre;
        this.prix = prix;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getSorte() {
        return sorte;
    }

    public void setSorte(char sorte) {
        this.sorte = sorte;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String obtenirDescription() {
        String description = "";
        for (int i = 0; i < SORTES_PIZZA.length; i++) {
            if (SORTES_PIZZA[i] == this.sorte) {
                description = DESCRIPTIONS_PIZZA[i];
                break;
            }
        }
        return this.nom + " (" + description + ") " + this.nombre + " " + prix;
    }

    public String obtenirDescriptionPizza() {
        String description = "";
        for (int i = 0; i < SORTES_PIZZA.length; i++) {
            if (SORTES_PIZZA[i] == this.sorte) {
                description = DESCRIPTIONS_PIZZA[i];
                break;
            }
        }
        return description;
    }
}
