public class Refrigere extends Produit {

    private int tempConservation;

    public Refrigere(int prix, String marque, String nom, int tempConservation) {
        super(prix, marque, nom);
        this.tempConservation = tempConservation;
    }

    public int getTempConservation() {
        return tempConservation;
    }

    private void setTempConservation(int tempConservation) {
        if (tempConservation>-273){
            this.tempConservation = tempConservation;
        }
    }
}
