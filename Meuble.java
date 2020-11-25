package projet;
import java.util.ArrayList;
public class Meuble{
    double prix;
    ArrayList<LotPiece> liste_lot_piece;
    public Meuble(ArrayList<LotPiece> liste){
        liste_lot_piece=new ArrayList<LotPiece>();
        liste_lot_piece.addAll(liste); //a tester si addAll ca marche bien
        prix=0d;
        for(int i = 0; i<liste.size(); i++){
            prix=prix+liste.get(i).prix;
        }
    }

}
//pour la construction de la liste meuble et le tableau de rangee , on mettre le nombre de fois la piece x par rapport a son volume ,cad si le volume de vis necessairre/a ranger est 3,on mettra vis 3 fois dans la liste/tableau