import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Labyrinthe {
    private Map<Integer, Map<Integer, Case>> lesCases;
    private Noeud depart;
    private int maxX;
    private int maxY;

    /**
     * Constructeur
     */
    public Labyrinthe() {
        this.lesCases = new HashMap<>();
    }

    /**
     * Ajouter une case au labyrinthe
     * @param c Case à ajouter
     */
    private void addCase(Case c) {
        if (!lesCases.containsKey(c.getX())){
            lesCases.put(c.getX(), new HashMap<>());
        }
        lesCases.get(c.getX()).put(c.getY(), c);
    }

    /**
     * Initialise le labyrinthe à partir d'un fichier
     * @param filePath path du fichier contenant le paterne du laby
     */
    public void init(String filePath){
        try{
            InputStream flux=new FileInputStream(filePath);
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            int value = 0;

            int x = 0;
            int y = 0;
            this.maxX = 0;
            this.maxY = 0;

            while ((value = buff.read()) != -1){
                char c = (char)value;
                switch (c) {
                    case '\n':
                        y += 1;
                        x = 0;
                        break;
                    case 'M':
                        this.addCase(new Case(x,y, EnumCase.MUR));
                       // System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    case 'E':
                        this.addCase(new Case(x,y, EnumCase.ENTREE));
                        depart = new Noeud(this, null,new ArrayList<>(),0,0,new Case(x,y, EnumCase.ENTREE));
                        //System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    case 'S':
                        this.addCase(new Case(x,y, EnumCase.SORTIE));
                        //System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    case '_':
                        this.addCase(new Case(x,y, EnumCase.VIDE));
                        //System.out.println(c+" "+x+" "+y);
                        x += 1;
                        break;
                    default: //System.out.println("ERR");
                        break;
                }
                if(x > maxX) maxX = x-1; //On ne compte pas la derniere incrémentation de chaque ligne
                if(y > maxY) maxY = y;
            }
            buff.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * Renvoie les coordonnées et le type de chaques cases dans la console
     */
    public void lireLaby(){

        for(Map.Entry<Integer, Map<Integer, Case>> entry : lesCases.entrySet()) {
            int x = entry.getKey();
            for (Map.Entry<Integer, Case> entry2: entry.getValue().entrySet()) {
                int y = entry2.getKey();
                System.out.println("x: "+x+" "+"y: "+y+" "+entry2.getValue().getType());
            }

        }
    }

    /**
     * Obtenir le noeud de départ
     * @return le noeud de départ
     */
    public Noeud getDepart() {
        return depart;
    }



    public void explorerLaby(Algorithme algo, String filepath) {
        //on initialise le laby
        this.init("labyrinthe/labExemple.lab");
        //on sauvegarde le labyrinthe de base
        Map<Integer, Map<Integer, Case>> saveLaby = lesCases;
        //on initialise la frontière qui contiendra les noeuds
        LinkedList<Noeud> frontiere = new LinkedList<>();
        //on y ajoute le noeud de départ
        frontiere.add(depart);
        //on initialise le nombre de noeuds créés à 1 (Le noeud de départ)
        int nbNoeudsCree = 1;

        //Tant que le premier élément de la frontière n'est pas une case de type sortie
        while (frontiere.getFirst().getLacase().getType() != EnumCase.SORTIE) {

            //on initialise la liste qui contient les noeuds à ajouter à la frontière
            LinkedList<Noeud> lesNoeuds = new LinkedList<>();

            //on récupère le noeud à développer
            Noeud noeudActuel = frontiere.getFirst();

            //on initialise les cases qui corresponderont aux 4 cases adjacentes de la case actuelle 
            Case caseHaut;
            Case caseBas;
            Case caseDroite;
            Case caseGauche;
            //on récupère la case actuelle
            Case caseActuelle = noeudActuel.getLacase();
            //on récupère le X et le Y de la case actuelle
            int caseActuelleY = caseActuelle.getY();
            int caseActuelleX = caseActuelle.getX();
            //on récupère les actions (haut bas droite gauche) pour le chemin final
            ArrayList<EnumAction> lesActions = noeudActuel.getAction();


            //on vérifie si il y a une case au dessus
            if (caseActuelleY > 0) {
                //On récupère la case du dessus à partir de la map qui contient toutes les cases du laby
                caseHaut = lesCases.get(caseActuelleX).get(caseActuelleY - 1);
                //on ajoute la nouvelle action
                lesActions.add(EnumAction.HAUT);
                //On créé un noeud et on l'ajoute à la liste des noeuds potentiels
                lesNoeuds.add(new Noeud(this, noeudActuel, lesActions, 1, noeudActuel.getProfondeur() + 1, caseHaut));
                //on retire la nouvelle action ajoutée pour qu'elle ne soit pas ajoutée aux autres sommets développés lors de ce tour de boucle
                lesActions.remove(lesActions.size()-1);
            }
            //on vérifie si il y a une case en dessous
            if (caseActuelleY < maxY) {
                //On récupère la case du dessous à partir de la map qui contient toutes les cases du laby
                caseBas = lesCases.get(caseActuelleX).get(caseActuelleY + 1);
                //on ajoute la nouvelle action
                lesActions.add(EnumAction.BAS);
                //On créé un noeud et on l'ajoute à la liste des noeuds potentiels
                lesNoeuds.add(new Noeud(this, noeudActuel, lesActions, 1, noeudActuel.getProfondeur() + 1, caseBas));
                //on retire la nouvelle action ajoutée pour qu'elle ne soit pas ajoutée aux autres sommets développés lors de ce tour de boucle
                lesActions.remove(lesActions.size()-1);
            }
            //on vérifie si il y a une case à gauche
            if (caseActuelleX > 0) {
                //On récupère la case de gauche à partir de la map qui contient toutes les cases du laby
                caseGauche = lesCases.get(caseActuelleX - 1).get(caseActuelleY);
                //on ajoute la nouvelle action
                lesActions.add(EnumAction.GAUCHE);
                //On créé un noeud et on l'ajoute à la liste des noeuds potentiels
                lesNoeuds.add(new Noeud(this, noeudActuel, lesActions, 1, noeudActuel.getProfondeur() + 1, caseGauche));
                //on retire la nouvelle action ajoutée pour qu'elle ne soit pas ajoutée aux autres sommets développés lors de ce tour de boucle
                lesActions.remove(lesActions.size()-1);

            }
            //on vérifie si il y a une case à droite
            if (caseActuelleX < maxX) {
                //On récupère la case de droite à partir de la map qui contient toutes les cases du laby
                caseDroite = lesCases.get(caseActuelleX + 1).get(caseActuelleY);
                //on ajoute la nouvelle action
                lesActions.add(EnumAction.DROITE);
                //On créé un noeud et on l'ajoute à la liste des noeuds potentiels
                lesNoeuds.add(new Noeud(this, noeudActuel, lesActions, 1, noeudActuel.getProfondeur() + 1, caseDroite));
                //on retire la nouvelle action ajoutée pour qu'elle ne soit pas ajoutée aux autres sommets développés lors de ce tour de boucle
                lesActions.remove(lesActions.size()-1);

            }



            //on retire toutes les cases adjacentes qui ne sont pas/plus visitables (Mur, case déjà dans frontiere, case déjà explorée) de la liste contenant les noeuds à ajouter à la frontière
            lesNoeuds.removeIf(monNoeud -> !lesCases.get(monNoeud.getLacase().getX()).get(monNoeud.getLacase().getY()).isVisite());
            //on incrémente le nombre total de noeuds créés
            nbNoeudsCree += lesNoeuds.size();

            //On retire le noeud que l'on vient de développer
            frontiere.removeFirst();
            //on ajoute les nouveaux noeuds à la frontière, l'ajout est différent selon l'algorithme passé en param
            frontiere = algo.add(frontiere, lesNoeuds);

            //Pour tous les noeuds de la frontière on change l'attribut des cases du laby correspondantes pour les rendre non visitables
            for (Noeud n : frontiere) {
                lesCases.get(n.getLacase().getX()).get(n.getLacase().getY()).setVisite(false);
            }


        }


        System.out.println(" ");
        System.out.println("Algorithme : "+algo.getClass());
        System.out.println("nbNoeudsCree "+nbNoeudsCree);
        System.out.println("longueur chemin "+frontiere.getFirst().getProfondeur());
        System.out.println("Actions "+frontiere.getFirst().getAction());



    }

}
