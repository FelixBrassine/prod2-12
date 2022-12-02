import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Magasin {
    private List<Stock> stockList = new ArrayList<Stock>();
    public static void affichageListeProduits (Stock s){
        for (Produit i : s.getListeProduits().values()){
            System.out.println("|--------------------------------------------------------|");
            System.out.println("| " + i.getMarque() + " > " + i.getPrix()+ "€ | ");
            }
        System.out.println("|--------------------------------------------------------|");
    }

    public void affichageListeStock (){
        if (stockList.size()>0){
            IntStream.range(1, stockList.size()).forEach(j -> {
                Stock i = stockList.get(j);
                System.out.println("|--------------------------------------------------------|");
                System.out.println("| " + j + " | adresse : " + i.getAdresse() + " | taille : " + i.getTailleMax() + " | ");
            });
            System.out.println("|--------------------------------------------------------|");
        }else {
            System.out.println("Il n'y a aucun stock disponnible !");
        }
    }

    public int selection() {
        int choix = 0;
        boolean quitter = false;
        Scanner sc = new Scanner(System.in);
        do  {
            System.out.println("**SELECTION**");
            System.out.println("1 pour ajouter un stock");
            System.out.println("2 pour créer un nouvelle article");
            System.out.println("3 pour modifier la quantité d'un article");
            System.out.println("4 pour retirer un article");
            System.out.println("5 pour afficher les articles d'un stock");
            System.out.println("6 pour fermer le programme");
            System.out.print("Votre séléction :");
            choix = Integer.parseInt(sc.nextLine());
            if (choix == 7){
                quitter =true;
            }
            runShop(choix);
        } while (!quitter);
        return choix;
    }
    public void runShop(int choix){
        Scanner sc = new Scanner(System.in);

            switch (choix){
                case 1 :
                    //ajouter un stock
                    System.out.print("Quel est l'adresse du stock ? :");
                    String adresse = sc.nextLine();
                    System.out.print("Quel est la taille maximum du stock ? :");
                    int tailleMax = Integer.parseInt(sc.nextLine());
                    Stock s = new Stock(adresse,tailleMax);
                    stockList.add(s);
                    break;
                case 2 :
                    //nouvel article
                    System.out.print("Quel est le nom de l'article ? :");
                    String nom = sc.nextLine();
                    System.out.print("Quel est la marque de l'article ? :");
                    String marque = sc.nextLine();
                    System.out.print("Quel est le prix de l'article ? :");
                    int prix = Integer.parseInt(sc.nextLine());
                    Produit p = new Produit(prix, marque, nom);
                    Stock.ajouterProduit(p);
                    break;
                case 3 :
                    //modifier quantité article
//                    Stock.deleteToArticle();
                    break;
                case 4 :
                    //supprimer article
                    System.out.print("Quel est le nom de l'article ? :");
                    String nomSupp = sc.nextLine();
                    System.out.print("Quel est la marque de l'article ? :");
                    String marqueSupp = sc.nextLine();

                    break;
                case 5 :
                    //afficher les produits d'un stock
                    affichageListeStock();
                    System.out.print("Quel stock voulez vous afficher ? :");
                    int choixStock = Integer.parseInt(sc.nextLine());
                    affichageListeProduits(stockList.get(choixStock-1));
                    break;
                case 6 :
                    System.exit(0);
                    break;
            }
        }
}
