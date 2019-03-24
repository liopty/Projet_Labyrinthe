import java.util.ArrayList;

/**
 * Classe qui va être utilisée afin de generer l'arbre de recherche
 */
public class Noeud {
    private Labyrinthe etat;
    private Noeud noeudParent;
    private ArrayList<EnumAction> action = new ArrayList<>();
    private int coutDuChemin;
    private int profondeur;
    private Case lacase;

    public Noeud(Labyrinthe etat, Noeud noeudParent, ArrayList<EnumAction> action, int coutDuChemin, int profondeur, Case lacase) {
        this.etat = etat;
        this.noeudParent = noeudParent;
        this.action.addAll(action);
        this.coutDuChemin = coutDuChemin;
        this.profondeur = profondeur;
        this.lacase = lacase;
    }

    public Labyrinthe getEtat() {
        return etat;
    }

    public void setEtat(Labyrinthe etat) {
        this.etat = etat;
    }

    public Noeud getNoeudParent() {
        return noeudParent;
    }

    public void setNoeudParent(Noeud noeudParent) {
        this.noeudParent = noeudParent;
    }

    public ArrayList<EnumAction> getAction() {
        return action;
    }

    public void setAction(ArrayList action) {
        this.action = action;
    }

    public int getCoutDuChemin() {
        return coutDuChemin;
    }

    public void setCoutDuChemin(int coutDuChemin) {
        this.coutDuChemin = coutDuChemin;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public Case getLacase() {
        return lacase;
    }

    public void setLacase(Case lacase) {
        this.lacase = lacase;
    }
}
