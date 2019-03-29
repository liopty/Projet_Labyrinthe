public class Euclidienne implements Heuristique {
    @Override
    public Double calculDistance(Case recherche, Case sortie) {
        return Math.sqrt(Math.pow(recherche.getX()-sortie.getX(),2)+Math.pow(recherche.getY()-sortie.getY(),2));
    }
}
