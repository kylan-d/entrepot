package projet;

public class Reservation {
    int idlot;
    int volumelot;
    int idmeuble;
    double prix;

    public Reservation(int idlot,int volumelot,int idmeuble,double prix){
        this.volumelot=volumelot;
        this.idlot=idlot;
        this.idmeuble=idmeuble;
        this.prix=prix;
    }
}
