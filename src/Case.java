public class Case {
    private int x;
    private int y;
    private boolean visitable;
    private int distance;
    private EnumCase type;

    /**
     * Constructeur
     * @param x position x
     * @param y position y
     * @param type type de la case (Mur, Entree, Sortie, Vide)
     */
    public Case(int x, int y, EnumCase type) {
        this.x = x;
        this.y = y;
        if (type == EnumCase.MUR || type == EnumCase.ENTREE){
            this.visitable = false;
        } else {
            this.visitable = true;
        }
        this.type = type;
        this.distance = 0;
    }

    /**
     * Obtenir la position X
     * @return la position X
     */
    public int getX() {
        return x;
    }

    /**
     * Obtenir la position Y
     * @return la position Y
     */
    public int getY() {
        return y;
    }

    /**
     * Savoir si la case est visitable (une case Mur ou déjà visitée n'est pas visitable)
     * @return si la case est visitable
     */
    public boolean isVisite() {
        return visitable;
    }

    /**
     * Permet de rendre une case visitable ou non visitable
     * @param visitable visitable ou non visitable
     */
    public void setVisite(boolean visitable) {
        this.visitable = visitable;
    }

    /**
     * Obtenir la distance, la distance est calculée par une autre classe selon l'heuristique
     * @return la distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Modifier la distance, la distance est calculée par une autre classe selon l'heuristique
     * @param distance la distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Obtenir le type de la case (Mur, Entree, Sortie, Vide)
     * @return le type de la case
     */
    public EnumCase getType() {
        return type;
    }



}
