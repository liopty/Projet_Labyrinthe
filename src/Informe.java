import java.text.Collator;
import java.util.*;

public class Informe implements Algorithme {
    private Heuristique heuristique;

    /**
     * On doit donner l'heuristique avec laquelle on résout le labyrinthe
     * @param heuristique dans notre cas Manhattan ou euclidienne
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

    /**
     * Permet d'ajouter une liste de noeuds à la frontière
     * @param frontiere liste des noeuds à explorer
     * @param noeud liste des nouveaux noeuds à explorer
     * @return la nouvelle frontière
     */
    @Override
    public LinkedList<Noeud> add(LinkedList<Noeud> frontiere, LinkedList<Noeud> noeud) {
        // l'endroit dans la liste où ajouter le noeud
        int index;
        //Pour tous les noeuds à ajouter
        for (Noeud aNoeud : noeud) {
            //on initialise l'index
            index = 0;
            //on actualise la distance contenue dans la case en ajoutant le nombre de pas parcourus
            aNoeud.getLacase().setDistance(aNoeud.getLacase().getDistance() + aNoeud.getProfondeur());
            //on parcours la frontière en comparant la distance du noeud à ajouter avec celles de la frontière
            for (int i = 0; i < frontiere.size() && aNoeud.getLacase().getDistance() > frontiere.get(i).getLacase().getDistance(); i++ ) index++;
            //on ajoute le noeud au bon endroit dans la frontiere pour qu'elle soit ordonnée
            frontiere.add(index, aNoeud);
        }
        return frontiere;
    }

    /**
     * Calcul la distance entre chaque case et la sortie
     * @param lesCases toutes les cases du labyrinthe
     * @param sortie la case de sortie
     * @return les cases du labyrinthe avec leur distance modifiée
     */
    public Map<Integer,Map<Integer,Case>> calculDist(Map<Integer,Map<Integer,Case>> lesCases, Case sortie) {
        //parcours de toutes les case
        lesCases.forEach((key, value) -> {
            int x = key;
            value.forEach((key1, value1) -> {
                int y = key1;
                //on modifie la distance selon une heuristique
                lesCases.get(x).get(y).setDistance(this.heuristique.calculDistance(lesCases.get(x).get(y), sortie));
            });
        });
        return lesCases;
    }
}
