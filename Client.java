
/**

 */
public class Client
{
    private String adresse;
    private String telephone;

    public Client(String adresse, String telephone) {
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
