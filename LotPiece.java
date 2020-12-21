package projet;
import java.util.ArrayList;

public class LotPiece {
    Piece piece;
    int id;
    int volume;
    double prix;
    static int i = 1;

    public LotPiece(int volume, String nom, double poids, double prix) {
        this.volume = volume;
        this.prix = prix;
        this.id = i++;
        addPiece(nom,poids,prix);
    }

    public void addPiece(String nom, double poids, double prix) {
        this.piece = new Piece(nom, poids, prix);
    }

    public String toString() {
        String informations = "";
        informations += "{type:"+piece.nom + "} \n" ;
        informations += "{poids:"+piece.poids + "} \n" ;
        informations += "{prix:"+piece.prix + "} \n" ;
        return " { ID du lot : "+ this.id +" | Volume : " + this.volume + " } \n" + " pièce : \n"+ informations;
    }


    public class Piece{
        String nom;
        double poids;
        double prix;

        public Piece(String nom, double poids, double prix) {
            this.nom = nom;
            this.poids = poids;
            this.prix = prix;
        }

        public String toString() {
            return "Informations : [ Nom : "+ this.nom + " | Poids : " + this.poids + " | Prix : " + this.prix + " ]";
        }
    }



}
