import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Informe implements Algorithme {
    private EnumHeuristique heuristique;

    /**
     * On doit donner l'heuristique avec laquelle on résout le labyrinthe
     * @param heuristique Manhattan ou euclidienne
     */
    public Informe(EnumHeuristique heuristique) {
        this.heuristique=heuristique;
    }

    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        return null;
    }
}
