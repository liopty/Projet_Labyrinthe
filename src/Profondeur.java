
import java.util.LinkedList;


public class Profondeur implements Algorithme {

    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        for (int i = noeud.size(); i>0; i--){
            frontiere.addFirst(noeud.get(i-1));
        }
        return frontiere;
    }
}
