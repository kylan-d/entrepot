package projet;

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
//pour la construction de la liste meuble et le tableau de rangee , on mettre le nombre de fois la piece x par rapport a son volume ,cad si le volume de vis necessairre/a ranger est 3,on mettra vis 3 fois dans la liste/tablea