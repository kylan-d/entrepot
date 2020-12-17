package projet;

import java.util.ArrayList;
public class Meuble{
    ArrayList<paires> liste_lot_piece;
    String piece;
    int duree;
    double prix;
    String nom;
    
    public Meuble( String nom,String piece, int duree){
        this.nom=nom;
        this.piece=piece;
        this.duree=duree;
        //this.prix=0;
        liste_lot_piece=new ArrayList<paires>();
        //liste_lot_piece.addAll(liste); //a tester si addAll ca marche bien

    }

    public void addcompo(paires p){
        liste_lot_piece.add(p);
    }
public double calculprix(){return 0;}
}
//pour la construction de la liste meuble et le tableau de rangee , on mettre le nombre de fois la piece x par rapport a son volume ,cad si le volume de vis necessairre/a ranger est 3,on mettra vis 3 fois dans la liste/tableau