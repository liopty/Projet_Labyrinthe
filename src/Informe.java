import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Informe implements Algorithme {
    private Heuristique heuristique;

    /**
     * On doit donner l'heuristique avec laquelle on résout le labyrinthe
     * @param heuristique Manhattan ou euclidienne
     */
    public Informe(Heuristique heuristique) {
        this.heuristique=heuristique;
    }

    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        





        return null;
    }

    public Map<Integer,Map<Integer,Case>> calculDist(Map<Integer,Map<Integer,Case>> lesCases, Case sortie) {
        lesCases.forEach((key, value) -> {
            int x = key;
            value.forEach((key1, value1) -> {
                int y = key1;
                lesCases.get(x).get(y).setDistance(heuristique.calculDistance(lesCases.get(x).get(y), sortie));
            });
        });
        return lesCases;
    }
}
