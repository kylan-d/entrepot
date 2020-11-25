package projet;
public class LotPiece{
    String nom;
    double poids;
    double prix;
    int volume;
    int id;
    static int i;
    public LotPiece(String nom,double poids,double prix,int volume){
        this.nom=nom;
        this.poids=poids;
        this.prix=prix;
        this.volume=volume;
        id=i;
        i++;
    }
}