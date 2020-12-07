package projet;

import java.util.ArrayList;
public class Meuble{
    ArrayList<paires> liste_lot_piece;
    String piece;
    int duree;
    
    public Meuble(ArrayList<paires> liste, String piece, int duree){
        this.piece=piece;
        this.duree=duree;
        liste_lot_piece=new ArrayList<paires>();
        liste_lot_piece.addAll(liste); //a tester si addAll ca marche bien

    }
public double calculprix(){return 0;}
}
//pour la construction de la liste meuble et le tableau de rangee , on mettre le nombre de fois la piece x par rapport a son volume ,cad si le volume de vis necessairre/a ranger est 3,on mettra vis 3 fois dans la liste/tableau