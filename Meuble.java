package projet;
import java.util.ArrayList;

/**
 * Un Meuble est un objet qui permet de le stockage de différents objets.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Meuble {
    // liste_lot_piece : correspond aux à la liste des LotPiece nécéssaire à la construction du meuble.
    private ArrayList<Paire> liste_lot_piece;
    //  piece : correspond à l'endroit (maison, appartement,...) dans lequel le meuble va être entreposer.
    private String piece;
    // duree : correspond au temps de construction du meuble.
    private int duree;
    // duree : correspond au prix du meuble (somme de tous les LotPiece)
    private double prix;
    // nom : correspond au nom du Meuble.
    private String nom;
    // id : correspond à l'identifiant du meuble.
    int id;
    // i : est un nombre qui va s'incrémenter à chaque fois qu'on crée une commande de meuble et cette valeur va être associé à l'identifiant du meuble
    static int i = 1;

    /**
     * Constructeur de la classe Meuble
     * @param nom correspond au nom du {@link Meuble}.
     * @param piece correspond à l'endroit dans lequel le {@link Meuble} va être placer.
     * @param duree correspond à la duree de construction du {@link Meuble}.
     */
    public Meuble( String nom,String piece, int duree){
        this.setNom(nom);
        this.setPiece(piece);
        this.setDuree(duree);
        this.setListe_lot_piece(new ArrayList<Paire>());

    }

    /**
     * Fonction qui va ajouter une {@link Paire} au Meuble.
     * @param p correspond à une {@link Paire} (nom du {@link LotPiece} et volume). Cette Paire va indiquer quelles sont les éléments et la quantité nécéssaire au montage du Meuble.
     */
    public void addcompo(Paire p){
        liste_lot_piece.add(p);
    }

    /**
     * Fonction qui calcule le prix du Meuble.
     * @param lp correspond à un {@link LotPiece}.
     * @return retourne le prix du Meuble.
     */
    public double calculerPrix(LotPiece lp) {
        double resultat = 0;
        for(int k = 0; k<liste_lot_piece.size(); k++) {
            if(lp.getPiece().getNom().equals(liste_lot_piece.get(k).getType())) {
                resultat += (lp.getPrix() * liste_lot_piece.get(k).getVolume());
            }
        }

        prix = resultat;
        return resultat;
    }

    /**
     * Fonction qui récupère la liste des paire du Meuble. (Getter)
     * @return return une ArrayList de paire du Meuble.
     */
    public ArrayList<Paire> getListe_lot_piece() {
        return liste_lot_piece;
    }

    /**
     * Fonction qui permet de modifier l'ArrayList de paire du Meuble. (Setter)
     * @param liste_lot_piece correspond à une ArrayList de Paire.
     */
    public void setListe_lot_piece(ArrayList<Paire> liste_lot_piece) {
        this.liste_lot_piece = liste_lot_piece;
    }

    /**
     * Fonction qui permet de récupérer la piece associer au Meuble. (Getter)
     * @return return la pièce associer au Meuble.
     */
    public String getPiece() {
        return piece;
    }

    /**
     * Fonction qui permet de modifier la piece associer au Meuble. (Setter)
     * @param piece correspond à la piece que l'on va associer au Meuble.
     */
    public void setPiece(String piece) {
        this.piece = piece;
    }

    /**
     * Fonction qui permet de récupérer la durée de construction du Meuble. (Getter)
     * @return return la durée de construction du Meuble.
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Fonction qui permet de modifier la durée de construction du Meuble. (Setter)
     * @param duree correspond à la durée de construction que l'on va associer au Meuble.
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Fonction qui permet de récuperer le prix du Meuble. (Getter)
     * @return return le prix du Meuble.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Fonction qui permet de modifier la valeur du prix de Meuble. (Setter)
     * @param prix correspond au prix que l'on va associer au Meuble.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Fonction qui permet de récuperer le nom du Meuble. (Getter)
     * @return return le nom du Meuble.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Fonction qui permet de modifier la valeur du nom du Meuble. (Setter)
     * @param nom correspond au nom du Meuble.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Fonction qui récupère l'identifiant du meuble. (Getter)
     * @return return l'identifiant du meuble.
     */
    public int getId() {
        return id;
    }

    /**
     * Fonction qui modifie la valeur de l'identifiant du meuble. (Setter)
     * @param id correspond à l'identifiant que l'on va associer au meuble.
     */
    public void setId(int id) {
        this.id = id;
    }
//    public double calculerPrix(Rangee[] ligne) {
//        double resultat = 0;
//        for(int i = 0; i<ligne.length; i++) {
//            for(int j = 0; i<ligne[i].place.length;j++) {
//                if(ligne[i].place[i].piece.nom.equals(liste_lot_piece.get(i).type)) {
//                    resultat += (ligne[i].place[i].piece.prix * liste_lot_piece.get(i).volume);
//                }
//            }
//        }
//        prix = resultat;
//        System.out.println(resultat);
//        return resultat;
//
//    }





}

