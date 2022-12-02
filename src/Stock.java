import java.util.HashMap;

public class Stock <P extends Produit> extends Magasin {
    private String adresse;
    private int tailleMax;

    private Integer qttProduit;

    private String nom;

    private Class<? extends Produit> type;

    private HashMap<P, Integer> listeProduits = new HashMap<>();

    public String getAdresse() {
        return adresse;
    }

    private void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTailleMax() {
        return tailleMax;
    }

    private void setTailleMax(int tailleMax) {
        if(tailleMax>0) {
            this.tailleMax = tailleMax;
        }
    }

    public Integer getQttProduit() {
        return qttProduit;
    }

    public void setQttProduit(Integer qttProduit) {
        if(qttProduit>=0) {
            this.qttProduit = qttProduit;
        }
        else throw new RuntimeException("Le nombre de produits ne peut être négatif");
    }

    public String getNom() {
        return nom;
    }

    public HashMap<P, Integer> getListeProduits() {
        return listeProduits;
    }

    public void setListeProduits(){

    }

    public void ajouterProduit (P produit, Integer qttProduit){
        if(listeProduits.size()>0) {
            if (!listeProduits.containsValue(produit)) {
                if(produit.getClass().equals(type) ) {
                    listeProduits.put(produit, qttProduit);
                }
                else throw new RuntimeException("Il est impossible de placer des produits de types différents dans le même stock");
            }
            else throw new RuntimeException("Il est impossible d'ajouter un produit déjà existant au stock.");
        }
        else if(listeProduits.size()==tailleMax){
            throw new RuntimeException("Le stock est plein : impossible d'ajouter de nouveaux produits");
        }
        else {
            listeProduits.put(produit, qttProduit);
            type = produit.getClass();
        }
    }

    public void retirerProduit (P produit){
        if(listeProduits.containsValue(produit)) {
            listeProduits.remove(produit.getNom() + produit.getMarque());
        }
        else throw new RuntimeException("Il est impossible de retirer du stock un produit qui n'en fait pas partie.");
    }

    public Stock(String adresse, int tailleMax, String nom) {
        this.adresse = adresse;
        this.tailleMax = tailleMax;
        this.nom = nom;
    }
}