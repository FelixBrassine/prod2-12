import java.util.HashMap;

public class Stock <P extends Produit> extends Magasin {
    private String adresse;
    private int tailleMax;
    private String nom;
    private Integer qttProduit;
    private final HashMap<P, Integer> listeProduits = new HashMap<>();

    //getter-setter
    public String getAdresse() {
        return adresse;
    }
    private void setAdresse(String adresse) {
        if (adresse.length()>5){
            this.adresse = adresse;
        }
        else throw new RuntimeException("Il faut au moins 1 caractère");
    }
    public int getTailleMax() {
        return tailleMax;
    }
    private void setTailleMax(int tailleMax) {
        if(tailleMax>0) {
            this.tailleMax = tailleMax;
        }
        else throw new RuntimeException("Le valeure ne peut être négative ou égale à zéro");
    }
    public String getNom() {
        return nom;
    }
    private void setNom(String nom) {
        if (nom.length()>0){
            this.nom = nom;
        }
        else throw new RuntimeException("Il faut au moins 1 caractère pour un nom valide");
    }
    public Integer getQttProduit() {
        return qttProduit;
    }
    private void setQttProduit(Integer qttProduit) {
        if(qttProduit>0) {
            this.qttProduit = qttProduit;
        }
        else throw new RuntimeException("Le nombre de produits ne peut être négatif");
    }
    public HashMap<P, Integer> getListeProduits() {
        return new HashMap<>(listeProduits);
    }

    //Méthodes
    public void ajouterProduit (P produit, Integer qttProduit){
        if(listeProduits.size()!=tailleMax){
            if (!listeProduits.containsValue(produit)) {
                if((produit instanceof Refrigere && this.nom.equals("Réfrigéré"))||(produit instanceof Toxique && this.nom.equals("Toxique non réfrigéré"))
                        ||(produit instanceof RefrigereToxique && this.nom.equals("Toxique réfrigéré"))
                        ||(produit instanceof ProduitNormal && this.nom.equals("Non-toxique non réfrigéré")))
                {
                    listeProduits.put(produit, qttProduit);
                }
                else throw new RuntimeException("Il est impossible de placer des produits de types différents dans le même stock");
            }
            else throw new RuntimeException("Il est impossible d'ajouter un produit déjà existant au stock.");
        }
        else {
            throw new RuntimeException("Le stock est plein : impossible d'ajouter de nouveaux produits");
        }
    }

    public void retirerProduit (P produit){
        if(listeProduits.containsValue(produit)) {
            listeProduits.remove(produit.getNom() + produit.getMarque());
        }
        else throw new RuntimeException("Il est impossible de retirer du stock un produit qui n'en fait pas partie.");
    }

    //constructeur
    public Stock(String adresse, int tailleMax, String nom) {
        setAdresse(adresse);
        setTailleMax(tailleMax);
        setNom(nom);
    }
}