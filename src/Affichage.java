import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Affichage {



    public static void affichageStock (HashMap<String, Produit> listeProduits){
        for (Produit i : listeProduits.values()){

            System.out.println("|--------------------------------------------------------|");
            System.out.println("| " + i.getNom() + " > " + i.getMarque() + " > " + i.getPrix()+ "€ | ");
            }
        System.out.println("|--------------------------------------------------------|");
    }

    public static int selection() {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        while (choix < 1 || choix > 6) {
            System.out.println("**SELECTION**");
            System.out.println("1 pour ajouter un nouvelle article");
            System.out.println("2 pour modifier un article");
            System.out.println("3 pour retirer un article");
            System.out.println("4 pour afficher les articles du magasin");
            System.out.println("5 pour afficher votre panier");
            System.out.println("6 pour fermer le programme");
            System.out.print("Votre séléction :");
            choix = Integer.parseInt(sc.nextLine());
        }
        return choix;
    }
    public void runShop(int choix){
            switch (choix){
                case 1 :
//                    Stock.addToArticle();
                    break;
                case 2 :
//                    Stock.modifToArticle();
                    break;
                case 3 :
//                    Stock.deleteToArticle();
                    break;
                case 4 :
//                    Stock.printAll();
                    break;
                case 5 :
//                    Stock.result();
                    break;
                case 6 :
                    System.exit(0);
                    break;
            }
        }
}
