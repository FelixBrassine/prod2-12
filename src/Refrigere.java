public class Refrigere extends Produit {

    private int tempConservation;

    private void setTempConservation(int tempConservation) {
        if (tempConservation>-273){
            this.tempConservation = tempConservation;
        }
        else throw new RuntimeException("Une température ne peut être en dessous du zéro absolu");
    }

    public Refrigere(int prix, String marque, String nom, int tempConservation) {
        super(prix, marque, nom);
        setTempConservation(tempConservation);
    }
}
