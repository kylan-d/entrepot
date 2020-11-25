public class Rangee{
    int Taille;
    int taille_restante;
    LotPiece place[];
    public Rangee(int n){
        Taille=n;
        taille_restante=n;
        place= new LotPiece[n];
    }
}