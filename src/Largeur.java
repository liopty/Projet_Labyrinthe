import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Largeur implements Algorithme {
    /**
     * Permet d'ajouter une liste de noeuds à la frontière
     * @param frontiere liste des noeuds à explorer
     * @param noeud liste des nouveaux noeuds à explorer
     * @return la nouvelle frontière
     */
    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        frontiere.addAll(noeud);
        return frontiere;
    }
}
