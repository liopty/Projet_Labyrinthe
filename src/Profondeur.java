
import java.util.LinkedList;


public class Profondeur implements Algorithme {

    /**
     * Permet d'ajouter une liste de noeuds à la frontière
     * @param frontiere liste des noeuds à explorer
     * @param noeud liste des nouveaux noeuds à explorer
     * @return la nouvelle frontière
     */
    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {

        for (int i = noeud.size(); i>0; i--){
            //profondeur limité
            if(noeud.get(i-1).getProfondeur() < 100){
                frontiere.addFirst(noeud.get(i-1));
            }
        }
        return frontiere;
    }
}
