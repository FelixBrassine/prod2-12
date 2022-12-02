import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Affichage {


    public static void affichageStock (HashMap<String, Produit> listeProduits){
        for (Produit i : listeProduits.values()){
            System.out.println("|--------------------------------------------------------|");
            System.out.println("| " + i.getNom() + " > " + i.getMarque() + " > " + i.getPrix()+ "€ | ");
            }
        System.out.println("|--------------------------------------------------------|");
    }

    public static void affichageListeStock (List<Stock> stockList){
        for (Stock i : stockList){
            System.out.println("|--------------------------------------------------------|");
            System.out.println("| " + i + " > " + i.getAdresse() + " > " + i.getTailleMax() + "€ | ");
        }
        System.out.println("|--------------------------------------------------------|");
    }


    public static int selection() {
        int choix = 0;
        boolean quitter = false;
        Scanner sc = new Scanner(System.in);
        do  {
            System.out.println("**SELECTION**");
            System.out.println("1 pour ajouter un stock");
            System.out.println("2 pour créer un nouvelle article");
            System.out.println("3 pour modifier un article");
            System.out.println("4 pour retirer un article");
            System.out.println("5 pour afficher les articles du magasin");
            System.out.println("6 pour afficher votre panier");
            System.out.println("7 pour fermer le programme");
            System.out.print("Votre séléction :");
            choix = Integer.parseInt(sc.nextLine());
            if (choix == 7){
                quitter =true;
            }
            runShop(choix);
        } while (!quitter);
        return choix;
    }
    public static void runShop(int choix){
        Scanner sc = new Scanner(System.in);
        List<Stock> stockList = new ArrayList<Stock>();
            switch (choix){
                case 1 :
                    System.out.print("Quel est l'adresse du stock ? :");
                    String adresse = sc.nextLine();
                    System.out.print("Quel est la taille maximum du stock ? :");
                    int tailleMax = Integer.parseInt(sc.nextLine());
                    Stock s = new Stock(adresse,tailleMax);
                    stockList.add(s);
                    break;
                case 2 :
                    System.out.print("Quel est le nom de l'article ? :");
                    String nom = sc.nextLine();
                    System.out.print("Quel est la marque de l'article ? :");
                    String marque = sc.nextLine();
                    System.out.print("Quel est le prix de l'article ? :");
                    int prix = Integer.parseInt(sc.nextLine());
                    Produit p = new Produit(prix, marque, nom);
                    break;
                case 3 :
//                    Stock.deleteToArticle();
                    break;
                case 4 :
//                    Stock.printAll();
                    break;
                case 5 :
                    System.out.print("Quel stock voulez vous afficher ? Entrez le numéro du stock :");
                    int choixStock = Integer.parseInt(sc.nextLine());
                    affichageStock(stockList.get(choixStock).getListeProduits());
                    break;
                case 6 :
                    break;
                case 7 :
                    System.exit(0);
                    break;
            }
        }
}
