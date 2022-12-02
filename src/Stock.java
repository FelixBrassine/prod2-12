import java.util.HashMap;

public class Stock {
    private String adresse = new String();
    private int tailleMax;

    private Class<? extends Produit> type;

    private HashMap<String, Produit> listeProduits = new HashMap<>();

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

    public HashMap<String, Produit> getListeProduits() {
        return listeProduits;
    }

    public void ajouterProduit (Produit produit){
        if(listeProduits.size()>0) {
            if (!listeProduits.containsValue(produit)) {
                if(produit.getClass().equals(type) ) {
                    listeProduits.put(produit.getNom() + produit.getMarque(), produit);
                }
                else throw new RuntimeException("Il est impossible de placer des produits de types différents dans le même stock");
            }
            else throw new RuntimeException("Il est impossible d'ajouter un produit déjà existant au stock.");
        } else {
            listeProduits.put(produit.getNom() + produit.getMarque(), produit);
            type = produit.getClass();
        }
    }

    public void retirerProduit (Produit produit){
        if(listeProduits.containsValue(produit)) {
            listeProduits.remove(produit.getNom() + produit.getMarque());
        }
        else throw new RuntimeException("Il est impossible de retirer du stock un produit qui n'en fait pas partie.");
    }

    public Stock(String adresse, int tailleMax){
        setAdresse(adresse);
        setTailleMax(tailleMax);
    }
}