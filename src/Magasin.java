import java.util.*;
import java.util.stream.IntStream;

public class Magasin {
    private final List<Stock> stockList = new ArrayList<Stock>();

    public static void afficheHashMap(HashMap<Produit,Integer> liste) {
        int i = 0;
        for (Map.Entry<Produit, Integer> entry : liste.entrySet()) {
            Produit key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("|-------------------------------------------------------------------------------------------------------|");
            System.out.println("|\033[0;36m         " + (i+1) + " =>  nom : " + key.getNom() + "   marque : " + key.getMarque() + "   prix : " + key.getPrix() + "€   type : " + value.toString() + " \033[0m|");
            i++;
        }
        System.out.println("|-------------------------------------------------------------------------------------------------------|");
    }

    public void affichageListeStock (){
        if (stockList.size()>0){
            IntStream.range(0, stockList.size()).forEach(j -> {
                Stock i = stockList.get(j);
                System.out.println("|-------------------------------------------------------------------------------------------------------|");
                System.out.println("\033[0;34m   " + (j+1) + " =>  adresse : " + i.getAdresse() + "    taille max : " + i.getTailleMax() + "   type : "+ i.getNom() + " \033[0m");
            });
            System.out.println("|-------------------------------------------------------------------------------------------------------|");
        }else {
            System.out.println("Il n'y a aucun stock disponnible !");
        }
    }

    public void afficherStockArticle (){
        if (stockList.size()>0){
            IntStream.range(0, stockList.size()).forEach(j -> {
                Stock i = stockList.get(j);
                System.out.println("|-------------------------------------------------------------------------------------------------------|");
                System.out.println("\033[0;34m   " + (j+1) + " =>  adresse : " + i.getAdresse() + "    taille max : " + i.getTailleMax() + "   type : "+ i.getNom() + " \033[0m");
                afficheHashMap(i.getListeProduits());
            });
            System.out.println("|-------------------------------------------------------------------------------------------------------|");
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
            System.out.println("4 pour modifier la quantité d'un article");
            System.out.println("5 pour retirer un article");
            System.out.println("6 pour fermer le programme");
            System.out.print("Votre séléction : ");
            choix = Integer.parseInt(sc.nextLine());
            if (choix == 6){
                quitter =true;
            }
            runShop(choix);
        } while (!quitter);
        return choix;
    }

    public void ajouterProduitStock (Produit p, int quantiteProd){
        affichageListeStock();
        Scanner sc = new Scanner(System.in);
        System.out.print("  Dans quel stock voulez-vous l'ajouter ? :");
        int choixStock = Integer.parseInt(sc.nextLine());
        stockList.get(choixStock-1).ajouterProduit(p,quantiteProd);
    }
    public void runShop(int choix){
        Scanner sc = new Scanner(System.in);
            switch (choix){
                case 1 :
                    //créer un stock
                    System.out.print("  Quel est l'adresse du stock ? : ");
                    String adresse = sc.nextLine();
                    System.out.print("  Quel est la taille maximum du stock ? : ");
                    int tailleMax = Integer.parseInt(sc.nextLine());
                    System.out.print("  De quel type est le stock ? 1 toxique, 2 non-toxique : ");
                    int type = Integer.parseInt(sc.nextLine());
                    switch (type){
                        case 1 :
                            System.out.print("  Est-ce un stock réfrigéré ? 1 oui 2 non : ");
                            int toxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (toxiqueRefrigere == 1){
                                String toxiqueRefrigereType = "Toxique réfrigéré";
                                Stock stockToxiqueRefrigere = new Stock<RefrigereToxique>(adresse, tailleMax, toxiqueRefrigereType);
                                stockList.add(stockToxiqueRefrigere);
                            }else{
                                String toxiqueNoRefrigereType = "Toxique non réfrigéré";
                                Stock stockToxiqueNoRefrigere = new Stock<Toxique>(adresse, tailleMax, toxiqueNoRefrigereType);
                                stockList.add(stockToxiqueNoRefrigere);
                            }
                            break;
                        case 2 :
                            System.out.print("  Est-ce un stock réfrigéré ? 1 oui 2 non : ");
                            int noToxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (noToxiqueRefrigere == 1){
                                String refrigereType = "Réfrigéré";
                                Stock stock3 = new Stock<Refrigere>(adresse, tailleMax, refrigereType);
                                stockList.add(stock3);
                            }else{
                                String noToxiqueRefrigereType = "Non-toxique non réfrigéré";
                                Stock stockNoToxNoRefrigere = new Stock<ProduitNormal>(adresse, tailleMax, noToxiqueRefrigereType);
                                stockList.add(stockNoToxNoRefrigere);
                            }
                            break;
                        default:
                            throw new RuntimeException("  Mauvais choix");
                    }
                    break;
                case 2 :
                    //créer-ajouter un article
                    System.out.print("  Quel est le nom de l'article ? : ");
                    String nom = sc.nextLine();
                    System.out.print("  Quel est la marque de l'article ? : ");
                    String marque = sc.nextLine();
                    System.out.print("  Quel est le prix de l'article ? : ");
                    int prix = Integer.parseInt(sc.nextLine());
                    System.out.print("  Quel est la quantité de l'article ? : ");
                    Integer quantite = Integer.parseInt(sc.nextLine());
                    System.out.print("  Quel est le type de l'article ? 1 toxique, 2 non-toxique : ");
                    int typeArticle = Integer.parseInt(sc.nextLine());
                    switch (typeArticle){
                        case 1 :
                            System.out.print("  Est-ce un article réfrigéré ? 1 oui 2 non : ");
                            int toxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (toxiqueRefrigere == 1){
                                String toxiqueRefrigereType = "Toxique réfrigéré";
                                System.out.print("  Quel est la température de conservation ? : ");
                                int tempConservation = Integer.parseInt(sc.nextLine());
                                RefrigereToxique rt = new RefrigereToxique(prix, marque, nom, tempConservation);
                                ajouterProduitStock(rt,quantite);
                            }else{
                                String toxiqueNoRefrigereType = "Toxique non réfrigéré";
                                Toxique t = new Toxique(prix,marque,nom);
                                ajouterProduitStock(t,quantite);
                            }
                            break;
                        case 2 :
                            System.out.print("  Est-ce un article réfrigéré ? 1 oui 2 non : ");
                            int noToxiqueRefrigere = Integer.parseInt(sc.nextLine());
                            if (noToxiqueRefrigere == 1){
                                String refrigereType = "Réfrigéré";
                                System.out.print("  Quel est la température de conservation ? : ");
                                int tempConservation = Integer.parseInt(sc.nextLine());
                                Refrigere r = new Refrigere(prix, marque,nom, tempConservation);
                                ajouterProduitStock(r,quantite);
                            }else{
                                String noToxiqueRefrigereType = "Non-toxique non réfrigéré";
                                ProduitNormal p = new ProduitNormal(prix, marque, nom);
                                ajouterProduitStock(p,quantite);
                            }
                            break;
                        default:
                            throw new RuntimeException("  Mauvais choix");
                    }
                    break;
                case 3 :
                    afficherStockArticle();
                    break;
                case 4 :
                    //modifier la quantité d'un article
                    affichageListeStock();
                    System.out.print("  Dans quel stock se trouve l'article ? :");
                    int choixStockArticle = Integer.parseInt(sc.nextLine());
                    afficheHashMap(stockList.get(choixStockArticle-1).getListeProduits());
                    System.out.print("  Quel article voulez vous modifier ? :");
                    int choixArticle = Integer.parseInt(sc.nextLine());
                    //ajouter modif a ce stock
//                    stockList.get(choixStockArticle-1).getListeProduits().
                    break;
                case 5 :
                    //supprimer un article
                    affichageListeStock();
                    System.out.print("  Dans quel stock se trouve l'article ? :");
                    int choixStockSupp = Integer.parseInt(sc.nextLine());
                    afficheHashMap(stockList.get(choixStockSupp-1).getListeProduits());
                    System.out.print("  Quel article voulez vous supprimer ? :");
                    int choixSupp = Integer.parseInt(sc.nextLine());
                    //ajouter supp a ce stok
//                    stockList.get(choixStockArticle-1).getListeProduits().
                    break;
                case  6:
                    System.exit(0);
                    break;
            }
        }
}
