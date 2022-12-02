import java.util.HashMap;

public class Stock<P extends Produit> {
    private String adresse = new String();
    private int tailleMax;

    private HashMap<String, P> listeProduits;

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

    public HashMap<String, ? extends Produit> getListeProduits() {
        return listeProduits;
    }

    private void setListeProduits(String type) {
        if (type.equals("toxique réfrigéré")){
            listeProduits = (HashMap<String, P>) new HashMap<String,RefrigereToxique>();
        }
        else if (type.equals("toxique")){
            listeProduits = (HashMap<String, P>) new HashMap<String,Toxique>();
        }
        else if (type.equals("réfrigéré")){
            listeProduits = (HashMap<String, P>) new HashMap<String,Refrigere>();
        }
        else{
            listeProduits = (HashMap<String, P>) new HashMap<String,Produit>();
        }
    }

    public void ajouterProduit (P produit){
        if(!listeProduits.containsValue(produit)) {
            listeProduits.put(produit.getNom() + produit.getMarque(), produit);
        }
        else throw new RuntimeException("Il est impossible d'ajouter un produit déjà existant au stock.");
    }

    public void retirerProduit (P produit){
        if(listeProduits.containsValue(produit)) {
            listeProduits.remove(produit.getNom() + produit.getMarque());
        }
        else throw new RuntimeException("Il est impossible de retirer du stock un produit qui n'en fait pas partie.");
    }

    public Stock(String adresse, int tailleMax, String type){
        setListeProduits(type);
        setAdresse(adresse);
        setTailleMax(tailleMax);
    }
}