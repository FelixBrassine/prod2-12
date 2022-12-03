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
        else throw new NegatifOuZeroException();
    }
    public String getMarque() {
        return marque;
    }
    private void setMarque(String marque) {
        if (marque.length()>0){
            this.marque = marque;
        }
        else throw new CaractereVideException();
    }
    public String getNom() {
        return nom;
    }
    private void setNom(String nom) {
        if (nom.length()>0){
            this.nom = nom;
        }
        else throw new CaractereVideException();
    }

    public Produit(int prix, String marque, String nom) {
        setPrix(prix);
        setMarque(marque);
        setNom(nom);
    }
}