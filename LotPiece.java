package projet;

/**
 * Un LotPiece correspond à un ensemble de {@link LotPiece.Piece}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */

public class LotPiece {
    // piece : correspond à la piece présent dans le lot.
    private Piece piece;
    // id : correspond à l'identifiant du lot.
    private int id;
    // volume : correspond au volume du lot.
    private int volume;
    // prix : correspond au prix du lot. Le prix correspond à la somme des prix des pieces qui compose le lot.
    private double prix;
    // i : est un nombre qui va s'incrémenter à chaque fois qu'on crée un lot et cette valeur va être associé à l'identifiant du lot.
    private static int i = 1;


    /**
     * Constructeur de la classe LotPiece.
     * @param volume correspond au volume du lot.
     * @param nom correspond au nom du lot.
     * @param poids correspond au poids du lot.
     * @param prix correspond au prix du lot.
     */
    public LotPiece(int volume, String nom, double poids, double prix) {
        this.setVolume(volume);
        this.setPrix(prix);
        this.setId(i++);
        addPiece(nom,poids,prix);
    }

    /**
     * Fonction qui récupère la piece associe au lot.
     * @return return la piece associer au lot.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Fonction qui permet de modifier la piece associer au lot.
     * @param piece correspond à la piece que l'on va associer au lot.
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Fonction qui récupère l'identifiant du lot. (Getter)
     * @return return l'identifiant du lot.
     */
    public int getId() {
        return id;
    }

    /**
     * Fonction qui modifie la valeur de l'identifiant du lot. (Setter)
     * @param id correspond à l'identifiant que l'on va associer au lot.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Fonciton qui permet de récupérer le volume du lot. (Getter)
     * @return return le volume du lot.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Fonction qui permet de modifier la valeur du volume du lot. (Setter)
     * @param volume correspond au volume que l'on va associer au lot.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Fonction qui récupère le prix du lot. (Getter)
     * @return return le prix du lot.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Fonction qui permet de modifier la valeur du prix du lot. (Setter).
     * @param prix correspond au prix que l'on va associer au lot.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Fonction qui récupère la valeur i. (Getter)
     * @return return la valeur i (valeur qui s'incrémente à chaque fois que l'on créer un nouvel objet de type LotPiece).
     */
    public static int getI() {
        return i;
    }

    /**
     * Fonction qui permet de modifier la valeur de i et que l'on va associer en suite à l'identifiant du lot. (Setter)
     * @param i correspond à la valeur que l'on va associer à i et qui sera ensuite asocier à l'identifiant.
     */
    public static void setI(int i) {
        LotPiece.i = i;
    }

















    /**
     * Fonction qui permet d'ajouter une piece dans un lot.
     * @param nom correspond au nom de la {@link Piece} à ajouter.
     * @param poids correspond au poids de la {@link Piece} à ajouter.
     * @param prix correspond au prix de la {@link Piece} à ajouter.
     */
    public void addPiece(String nom, double poids, double prix) {
        this.setPiece(new Piece(nom,poids,prix));
    }

    /**
     * Fonction qui permet d'afficher les informations du LotPiece.
     */
    public String toString() {
        String informations = "";
        informations += "{type:"+piece.nom + "} \n" ;
        informations += "{poids:"+piece.poids + "} \n" ;
        informations += "{prix:"+piece.prix + "} \n" ;
        return " { ID du lot : "+ this.id +" | Volume : " + this.volume + " } \n" + " pièce : \n"+ informations;
    }

    /**
     * Une Piece est un objet qui va permettre le montage d'un {@link Meuble}.
     * @author Abdesamad - Kylan
     * @version 1.0
     */
    public class Piece{
        // nom : correspond au nom de la piece.
        private String nom;
        // poids : correspond au poids de la piece.
        private double poids;
        // prix : correspond au prix de la piece.
        private double prix;

        /**
         * Constructeur de la classe Piece.
         * @param nom correspond au nom de la piece.
         * @param poids correspond au poids de la piece.
         * @param prix correspond au prix de la piece.
         */
        public Piece(String nom, double poids, double prix) {
            this.nom = nom;
            this.poids = poids;
            this.prix = prix;
        }

        /**
         * Fonction qui permet d'afficher les informations d'une Piece.
         */
        public String toString() {
            return "Informations : [ Nom : "+ this.nom + " | Poids : " + this.poids + " | Prix : " + this.prix + " ]";
        }

        /**
         * Fonction qui récupère le nom de la Piece. (Getter)
         * @return return le nom de la Piece.
         */
        public String getNom() {
            return nom;
        }

        /**
         * Fonction qui permet de modifier la valeur nom de la Piece. (Setter)
         * @param nom correspond au nom que l'on va associer à la Piece.
         */
        public void setNom(String nom) {
            this.nom = nom;
        }

        /**
         * Fonction qui récupère le poids de la Piece. (Getter)
         * @return return le poids de la Piece.
         */
        public double getPoids() {
            return poids;
        }

        /**
         * Fonction qui permet de récupère le poids de la Piece. (Setter)
         * @param poids correspond au poids que l'on va associer à la Piece.
         */
        public void setPoids(double poids) {
            this.poids = poids;
        }

        /**
         * Fonction qui permet de récupérer le prix de la Piece. (Getter)
         * @return Fonction qui permet de récupérer le prix de la Piece.
         */
        public double getPrix() {
            return prix;
        }

        /**
         * Fonction qui permet de modifier la valeur prix de la Piece. (Setter)
         * @param prix correspond au prix que l'on va associer à la Piece.
         */
        public void setPrix(double prix) {
            this.prix = prix;
        }





    }





}
