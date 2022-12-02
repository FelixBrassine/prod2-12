public class Produit {

    private int prix;
    private String marque;
    private String nom;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        if (prix>0){
            this.prix = prix;
        }
    }

    public String getMarque() {
        return marque;
    }

    private void setMarque(String marque) {
        if (marque != null){
            this.marque = marque;
        }
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        if (nom != null){
            this.nom = nom;
        }
    }

    public Produit(int prix, String marque, String nom) {
        setPrix(prix);
        setMarque(marque);
        setNom(nom);
    }
}