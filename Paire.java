package projet;
/**
 * Une Paire correspond aux noms et à la quantité des {@link LotPiece.Piece} nécéssaire à la construction d'un {@link Meuble}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Paire {
    // volume : correspond à la quantité nécéssaire de Piece pour permettre le montage du Meuble en question.
    private int volume;
    // type : correspond au nom de la Piece nécaissaire pour permettre la construction du Meuble en question.
    private String type;
    /**
     * Constructeur de la classe Paire.
     * @param volume correspond à la quantité de Piece nécéssaire à la constuction du {@link Meuble}.
     * @param type correspond au nom de la Piece nécéssaire à la construction du {@link Meuble}.
     */
    public Paire(int volume,String type){
        this.volume=volume;
        this.type=type;
    }

    /**
     * Fonction qui va récupérer le volume de la Paire (Getter)
     * @return return le volume de la Paire.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Fonction qui permet de modifier le volume de la Paire (Setter)
     * @param volume correspond au volume que l'on va associer à la Paire.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Fonction qui permet de récupérer le type associer à la Paire. (Getter)
     * @return return le type de la Paire.
     */
    public String getType() {
        return type;
    }

    /**
     * Fonction qui permet de modifier le type associer à la Paire (Setter)
     * @param type correspond au type que l'on va associer à la Paire.
     */
    public void setType(String type) {
        this.type = type;
    }






}
