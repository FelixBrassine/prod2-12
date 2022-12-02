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
            IntStream.range(0, stockList.size()).forEach(j -> {
                Stock i = stockList.get(j);
                System.out.println("|--------------------------------------------------------|");
                System.out.println("| " + (j+1) + " | adresse :" + i.getAdresse() + " | taille max :" + i.getTailleMax() + " | "+ i.getNom() + " | ");
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
            System.out.println("1 pour créer un stock");
            System.out.println("2 pour créer un nouvelle article");
            System.out.println("3 pour afficher les stocks et les articles");
            System.out.println("4 pour ajouter un article");
            System.out.println("5 pour modifier la quantité d'un article");
            System.out.println("6 pour retirer un article");
            System.out.println("7 pour fermer le programme");
            System.out.print("Votre séléction : ");
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
                    //créer un stock
                    System.out.print("Quel est l'adresse du stock ? : ");
                    String adresse = sc.nextLine();
                    System.out.print("Quel est la taille maximum du stock ? : ");
                    int tailleMax = Integer.parseInt(sc.nextLine());
                    System.out.print("Quel est le type est le stock ? 1 toxique, 2 non-toxique : ");
                    int type = Integer.parseInt(sc.nextLine());
                    switch (type){
                        case 1 :
                            System.out.print("Est-ce un stock réfrigéré ? 1 oui 2 non : ");
                            int toxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (toxiqueRefrigere == 1){
                                String toxiqueRefrigereType = "Toxique réfrigéré";
                                Stock stockToxiqueRefrigere = new Stock<RefrigereToxique>(adresse, tailleMax, toxiqueRefrigereType);
                                stockList.add(stockToxiqueRefrigere);
                                break;
                            }else{
                                String toxiqueNoRefrigereType = "Toxique non réfrigéré";
                                Stock stockToxiqueNoRefrigere = new Stock<Toxique>(adresse, tailleMax, toxiqueNoRefrigereType);
                                stockList.add(stockToxiqueNoRefrigere);
                                break;
                            }
                        case 2 :
                            System.out.print("Est-ce un stock réfrigéré ? 1 oui 2 non : ");
                            int noToxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (noToxiqueRefrigere == 1){
                                String noToxiqueRefrigereType = "Non-toxique non réfrigéré";
                                Stock stockNoToxNoRefrigere = new Stock<Produit>(adresse, tailleMax, noToxiqueRefrigereType);
                                stockList.add(stockNoToxNoRefrigere);
                                break;
                            }else{
                                String refrigereType = "Réfrigéré";
                                Stock stock3 = new Stock<Refrigere>(adresse, tailleMax, refrigereType);
                                stockList.add(stock3);
                                break;
                            }
                        default:
                            throw new RuntimeException("Mauvais choix");
                    }
                    break;
                case 2 :
                    //créer un article
                    System.out.print("Quel est le nom de l'article ? : ");
                    String nom = sc.nextLine();
                    System.out.print("Quel est la marque de l'article ? : ");
                    String marque = sc.nextLine();
                    System.out.print("Quel est le prix de l'article ? : ");
                    int prix = Integer.parseInt(sc.nextLine());
                    System.out.print("Quel est la quantité de l'article ? : ");
                    Integer quantité = Integer.parseInt(sc.nextLine());
                    System.out.print("Quel est le type de l'article ? 1 toxique etc.: ");
                    int typeArticle = Integer.parseInt(sc.nextLine());
                    switch (typeArticle){
                        case 1 :
                            System.out.print("Est-ce un article réfrigéré ? 1 oui 2 non : ");
                            int toxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (toxiqueRefrigere == 1){
                                String toxiqueRefrigereType = "Toxique réfrigéré";
                                System.out.println("Quel est la température de conservation ? : ");
                                int tempConservation = Integer.parseInt(sc.nextLine());
                                RefrigereToxique p = new RefrigereToxique(prix, marque, nom, tempConservation);

                                break;
                            }else{
                                String toxiqueNoRefrigereType = "Toxique non réfrigéré";
                                Toxique t = new Toxique(prix,marque,nom);

                                break;
                            }
                        case 2 :
                            System.out.print("Est-ce un stock réfrigéré ? 1 oui 2 non : ");
                            int noToxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (noToxiqueRefrigere == 1){
                                String noToxiqueRefrigereType = "Non-toxique non réfrigéré";
                                Produit p = new Produit(prix, marque, nom);
                                break;
                            }else{
                                String refrigereType = "Réfrigéré";
                                System.out.println("Quel est la température de conservation ? : ");
                                int tempConservation = Integer.parseInt(sc.nextLine());
                                Refrigere r = new Refrigere(prix, marque,nom, tempConservation);
                                break;
                            }
                        default:
                            throw new RuntimeException("Mauvais choix");
                    }
                    break;
                case 3 :
                    //afficher les stocks et articles
                    affichageListeStock();
                    System.out.print("Quel stock voulez vous afficher ? :");
                    int choixStock = Integer.parseInt(sc.nextLine());
                    affichageListeProduits(stockList.get(choixStock));
                    break;
                case 4 :
                    //ajouter article
                    System.out.print("Quel est le nom de l'article ? :");
                    String nomSupp = sc.nextLine();
                    System.out.print("Quel est la marque de l'article ? :");
                    String marqueSupp = sc.nextLine();

                    break;
                case 5 :
                    //modifier la quantité d'un article
                    break;
                case 6 :
                    //supprimer un article
                    break;
                case 7 :
                    System.exit(0);
                    break;
            }
        }
}
