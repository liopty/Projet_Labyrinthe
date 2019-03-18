import java.util.Collection;
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
    public Noeud explore(Labyrinthe probleme, Collection<Noeud> frontiere) {
        return null;
    }


}
