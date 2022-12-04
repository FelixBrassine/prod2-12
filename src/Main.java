import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Magasin miniMarket = new Magasin();
        miniMarket.menuPrincipal();

        RefrigereToxique r = new RefrigereToxique(5,"ldfdsfs","sfsf",5);
        Stock<Refrigere> t = new Stock<>("gffg",50,"dgqfsgg");
        t.ajouterProduit(r, 20);
    }
}