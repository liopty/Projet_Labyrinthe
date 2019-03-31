
import java.util.LinkedList;


public interface Algorithme {
    //ajout d'une liste de nouveaux noeuds à visiter à la frontière
    LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud);
}
