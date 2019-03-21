import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Largeur implements Algorithme {

    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        frontiere.addAll(noeud);
        return frontiere;
    }
}
