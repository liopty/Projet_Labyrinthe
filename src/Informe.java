import java.text.Collator;
import java.util.*;

public class Informe implements Algorithme {
    private Heuristique heuristique;

    /**
     * On doit donner l'heuristique avec laquelle on résout le labyrinthe
     * @param heuristique Manhattan ou euclidienne
     */
    public Informe(Heuristique heuristique) {
        this.heuristique=heuristique;
    }

    public Heuristique getHeuristique() {
        return heuristique;
    }

    public void setHeuristique(Heuristique heuristique) {
        this.heuristique = heuristique;
    }

    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        int index;
        for (Noeud aNoeud : noeud) {
            index = 0;
            aNoeud.getLacase().setDistance(aNoeud.getLacase().getDistance() + aNoeud.getProfondeur());
            //on parcours la frontière en comparant la distance du noeud à ajouter avec celles de la frontière
            for (int i = 0; i < frontiere.size() && aNoeud.getLacase().getDistance() > frontiere.get(i).getLacase().getDistance(); i++ ) index++;
            //on ajoute le noeud au bon endroit dans la frontiere pour qu'elle soit ordonnée
            frontiere.add(index, aNoeud);
        }
        return frontiere;
    }

    public Map<Integer,Map<Integer,Case>> calculDist(Map<Integer,Map<Integer,Case>> lesCases, Case sortie) {
        lesCases.forEach((key, value) -> {
            int x = key;
            value.forEach((key1, value1) -> {
                int y = key1;
                lesCases.get(x).get(y).setDistance(this.heuristique.calculDistance(lesCases.get(x).get(y), sortie));
            });
        });
        return lesCases;
    }
}
