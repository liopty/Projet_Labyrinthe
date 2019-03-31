public class Manhattan implements Heuristique {
    @Override
    public Double calculDistance(Case recherche, Case sortie) {
        //calcul de la distance de Manhattan entre une case et la sortie
        return Math.abs(recherche.getX()-sortie.getX())+Math.abs(recherche.getY()-sortie.getY())*1.0;
    }
}
