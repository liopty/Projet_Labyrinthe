import java.util.Collection;
import java.util.List;

public interface Algorithme {
    Noeud explore(Labyrinthe probleme, Collection<Noeud> frontiere);
}
