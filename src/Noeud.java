/**
 * Classe qui va être utilisée afin de generer l'arbre de recherche
 */
public class Noeud {
    private Labyrinthe etat;
    private Noeud noeudParent;
    private EnumAction action;
    private int coutDuChemin;
    private int profondeur;
    private Case lacase;

    public Noeud(Labyrinthe etat, Noeud noeudParent, EnumAction action, int coutDuChemin, int profondeur, Case lacase) {
        this.etat = etat;
        this.noeudParent = noeudParent;
        this.action = action;
        this.coutDuChemin = coutDuChemin;
        this.profondeur = profondeur;
        this.lacase = lacase;
    }
}
