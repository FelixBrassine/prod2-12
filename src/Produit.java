public abstract class Produit {

    private final int prix;
    private final String marque;
    private final String nom;

    public int getPrix() {
        return prix;
    }
    public String getMarque() {
        return marque;
    }
    public String getNom() {
        return nom;
    }

    public Produit(int prix, String marque, String nom) {
        this.prix = prix;
        this.marque = marque;
        this.nom = nom;
    }
}