import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;


/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 *
 * Classe TestAlgosResolutionLabyrinthes : classe pour exécuter et tester la résolution de labyrinthes à l'aides différents algorithmes.
 *
 * @version 2019-03-26
 * @author Solen Quiniou
 *
 */


public class Application {
    /**
     * Les noms des répertoires contenant les différents fichiers.
     * --> à adapter avec les bons noms de répertoire
     */
    public static final String repertoireLabyrinthes = "labyrinthe";
    public static final String repertoireResultats = "results";
    public static final String repertoireResultatsReference = "resultsGold";

    public static final String fichierProfondeur = repertoireResultats + "/resultatsProfondeur.csv";
    public static final String fichierLargeur = repertoireResultats + "/resultatsLargeur.csv";
    public static final String fichierAetoileEuclidienne = repertoireResultats + "/resultatsAetoileEuclidienne.csv";
    public static final String fichierAetoileManhattan = repertoireResultats + "/resultatsAetoileManhattan.csv";

    public static final String fichierProfondeurReference = repertoireResultatsReference + "/resultatsProfondeur.csv";
    public static final String fichierLargeurReference = repertoireResultatsReference + "/resultatsLargeur.csv";
    public static final String fichierAetoileEuclidienneReference = repertoireResultatsReference + "/resultatsAetoileEuclidienne.csv";
    public static final String fichierAetoileManhattanReference = repertoireResultatsReference + "/resultatsAetoileManhattan.csv";

    public static final String enTeteFichiersCsv = "#nomLabyrinthe;nbNoeuds;longueurChemin;chemin";



    /**
     * Méthode principale pour tester les algorithmes de résolution sur des labyrinthes.
     * @param args les arguments de la méthode principale.
     */
    public static void main(String[] args){
        File fileLabyrinthe;
        List<String> tabProfondeur, tabLargeur, tabAetoileEuclidienne, tabAetoileManhattan;
        Labyrinthe lab; //à adapter à votre code


        /* Initialisation des tableaux contenant les résultats des différents algorithmes */

        tabProfondeur = new LinkedList<String>();
        tabProfondeur.add(enTeteFichiersCsv);
        tabLargeur = new LinkedList<String>();
        tabLargeur.add(enTeteFichiersCsv);
        tabAetoileEuclidienne = new LinkedList<String>();
        tabAetoileEuclidienne.add(enTeteFichiersCsv);
        tabAetoileManhattan = new LinkedList<String>();
        tabAetoileManhattan.add(enTeteFichiersCsv);


        /* Parcours des fichiers du répertoire de labyrinthes */

        File repertoire = new File(repertoireLabyrinthes);
        String[] listeFichiersLabyrinthes = repertoire.list();
        Arrays.sort(listeFichiersLabyrinthes);

        if (listeFichiersLabyrinthes != null) {
            for(String fichierLabyrinthe : listeFichiersLabyrinthes) {
                fileLabyrinthe = new File(repertoireLabyrinthes+"/"+fichierLabyrinthe);
                if(fileLabyrinthe.isFile()) {
                    System.out.println("\n##### Labyrinthe à traiter : " + fichierLabyrinthe + " #####\n");

                    //Création du labyrinthe
                    lab = new Labyrinthe(); //à adapter à votre code

                    //Résolution en profondeur du labyrinthe et écriture du résultat dans le fichier csv correspondant
                    System.out.println("\tExploration en profondeur");
                    lab.explorerLaby(new Profondeur(), repertoireLabyrinthes+"/"+fichierLabyrinthe);
                    tabProfondeur.add(repertoireLabyrinthes+"/"+fichierLabyrinthe+";"+lab.getResultatCSV()); //à adapter à votre code

                    //Résolution en largeur du labyrinthe et écriture du résultat dans le fichier csv correspondant
                    System.out.println("\tExploration en largeur"); //à adapter à votre code
                    lab.explorerLaby(new Largeur(), repertoireLabyrinthes+"/"+fichierLabyrinthe);
                    tabLargeur.add(repertoireLabyrinthes+"/"+fichierLabyrinthe+";"+lab.getResultatCSV()); //à adapter à votre code

                    //Résolution A* avec l'heuristique euclidienne du labyrinthe et écriture du résultat dans le fichier csv correspondant
                    System.out.println("\tExploration A* Manhattan"); //à adapter à votre code
                    lab.explorerLaby(new Informe(new Euclidienne()), repertoireLabyrinthes+"/"+fichierLabyrinthe);
                    tabAetoileEuclidienne.add(repertoireLabyrinthes+"/"+fichierLabyrinthe+";"+lab.getResultatCSV()); //à adapter à votre code

                    //Résolution A* avec l'heuristique de Manhattan du labyrinthe et écriture du résultat dans le fichier csv correspondant
                    System.out.println("\tExploration A* Euclidienne"); //à adapter à votre code
                    lab.explorerLaby(new Informe(new Manhattan()), repertoireLabyrinthes+"/"+fichierLabyrinthe);
                    tabAetoileManhattan.add(repertoireLabyrinthes+"/"+fichierLabyrinthe+";"+lab.getResultatCSV()); //à adapter à votre code
                }
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }


        /* Ecriture des fichiers csv contenant les résultats de chacun des algorithmes */

        System.out.println("\nEcriture des fichiers de résultats");

        try {
            Files.write(Paths.get(fichierProfondeur), tabProfondeur, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            Files.write(Paths.get(fichierLargeur), tabLargeur, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            Files.write(Paths.get(fichierAetoileEuclidienne), tabAetoileEuclidienne, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            Files.write(Paths.get(fichierAetoileManhattan), tabAetoileManhattan, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}