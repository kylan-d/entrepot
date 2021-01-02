package projet;

/**
 * Une Rangee correspond à un emplacement dans l'{@link Entrepot} qui permet le stockage de {@link LotPiece}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Rangee {
    // taille : correspond à la taille de la Rangee.
    private int taille;
    // taille_restante : correspond à la taille restante dans la Rangee.
    private int taille_restante;
    // place[] : correspond au contenue présent dans la Rangee.
    private LotPiece place[];
    /**
     * Constructeur de la classe Rangee.
     * @param n correspond à la taille de la Rangee.
     */
    public Rangee(int n){
        taille=n;
        taille_restante=n;
        place= new LotPiece[n];
    }

    /**
     * Fonction qui récupère la taille de la Rangee. (Getter)
     * @return return la taille de la Rangee.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Fonction qui permet de modifier la taille de la Rangee. (Setter)
     * @param taille correspond à la taille que l'on va associer à la Rangee.
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * Fonction qui return la taille restante de la Rangee. (Getter)
     * @return return la taille restante de la Rangee.
     */
    public int getTaille_restante() {
        return taille_restante;
    }

    /**
     * Fonction qui permet de modifier la taille restante de la Rangee. (Setter)
     * @param taille_restante correspond à la taille restante que l'on va associer à la Rangee.
     */
    public void setTaille_restante(int taille_restante) {
        this.taille_restante = taille_restante;
    }

    /**
     * Fonction qui va récupère le contenu de la Rangee. (Getter)
     * @return return un tableau qui contient le contenu de la Rangee.
     */
    public LotPiece[] getPlace() {
        return place;
    }

    /**
     * Fonction qui va modifier le contenu de la Rangee.
     * @param place correspond au contenu que l'on va associer à la Rangee.
     */
    public void setPlace(LotPiece[] place) {
        this.place = place;
    }

    /**
     * Fonction qui permet de récupère un certain {@link LotPiece} (Getter)
     * @param k correspond au kème {@link LotPiece} que l'on recherche.
     * @return return un {@link LotPiece}
     */
    public LotPiece getPlace(int k) {
        LotPiece resultat = null;
        for(int i = 0; i<this.place.length; i++) {
            if(i == k) {
                resultat = this.place[i];
            }
        }
        return resultat;
    }

    /**
     * Fonction qui modifier un {@link LotPiece} (Setter)
     * @param k correspond à l'emplacement k de la {@link Rangee}
     * @param lp correspond au {@link LotPiece} que l'on souhaite ajoutée.
     */
    public void setPlace(int k, LotPiece lp) {
        for(int i = 0; i<this.getPlace().length; i++) {
            if(i == k ) {
                this.place[k] = lp;
            }
        }
    }



}

