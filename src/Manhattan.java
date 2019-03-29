public class Manhattan implements Heuristique {
    @Override
    public Double calculDistance(Case recherche, Case sortie) {
        return Math.abs(recherche.getX()-sortie.getX())+Math.abs(recherche.getY()-sortie.getY())*1.0;
    }
}
