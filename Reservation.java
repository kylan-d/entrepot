package projet;

public class Reservation {
    private int idlot;
    private int volumelot;
    private int idmeuble;
    private double prix;

    /**
     * Constructeur de la classe Paire.
     * @param volumelot correspond à la quantité de Piece nécéssaire à la constuction du {@link Meuble}.
     * @param idlot correspond a l'id de la Piece nécéssaire à la construction du {@link Meuble}.
     * @param idmeuble correspond a l'id du {@link Meuble} construit.
     * @param idlot correspond au prix de la Piece nécéssaire à la construction du {@link Meuble}.
     */
    public Reservation(int idlot,int volumelot,int idmeuble,double prix){
        this.volumelot=volumelot;
        this.idlot=idlot;
        this.idmeuble=idmeuble;
        this.prix=prix;
    }
    /**
     * Fonction qui récupère l'identifiant du lot. (Getter)
     * @return return l'identifiant du lot.
     */
    public int getIdlot(){
        return idlot;
    }
    /**
     * Fonction qui modifie la valeur de l'identifiant du lot. (Setter)
     * @param newid correspond à l'identifiant que l'on va associer au lot.
     */
    public void setIdlot(int newid){
        idlot=newid;
    }
    public int getIdmeuble(){
        return idmeuble;
    }
    public void setIdmeuble(int newid){
        idmeuble=newid;
    }
    /**
     * Fonction qui permet de récupérer le volume de la Piece réservé. (Getter)
     * @return Fonction qui permet de récupérer le volume de la Piece.
     */
    public int getVolumelot(){
        return volumelot;
    }
    /**
     * Fonction qui permet de modifier la valeur du volume de la Piece. (Setter)
     * @param newvol correspond au volume pris que l'on va associer à la Piece.
     */
    public void setVolumelot(int newvol){
        volumelot=newvol;
    }
    /**
     * Fonction qui permet de récupérer le prix de la Piece. (Getter)
     * @return Fonction qui permet de récupérer le prix de la Piece.
     */
    public double getPrix(){
        return prix;
    }

    /**
     * Fonction qui permet de modifier la valeur prix de la Piece. (Setter)
     * @param newprix correspond au prix que l'on va associer à la Piece.
     */
    public void setPrix(double newprix){
        prix=newprix;
    }
}
