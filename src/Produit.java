public abstract class Produit {

    private int prix;
    private String marque;
    private String nom;

    public int getPrix() {
        return prix;
    }
    private void setPrix(int prix) {
        if (prix>0){
            this.prix = prix;
        }
        else throw new RuntimeException("Le valeure ne peut être négative ou égale à zéro");
    }
    public String getMarque() {
        return marque;
    }
    private void setMarque(String marque) {
        if (marque.length()>0){
            this.marque = marque;
        }
        else throw new RuntimeException("Il faut au moins 1 caractère");
    }
    public String getNom() {
        return nom;
    }
    private void setNom(String nom) {
        if (nom.length()>0){
            this.nom = nom;
        }
        else throw new RuntimeException("Il faut au moins 1 caractère");
    }

    public Produit(int prix, String marque, String nom) {
        setPrix(prix);
        setMarque(marque);
        setNom(nom);
    }
}