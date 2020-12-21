package projet;

public class Rangee {
    int taille;
    int taille_restante;
    LotPiece place[];
    public Rangee(int n){
        taille=n;
        taille_restante=n;
        place= new LotPiece[n];
    }

}
