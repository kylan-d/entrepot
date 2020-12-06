package projet;

import java.util.ArrayList;
public class Meuble{
    double prix;  // Je pense qu'il est inutile de rajoute cette variable. Etant donné Qu'une liste de piece est composé de piece. Il suffirait de faire un fonction qui fait la somme des prix des pieces pour le prix d'un lots. Puis pour un meuble Si il a besoins de plusieurs lot, on fait la somme du prix de chaques lots.
    ArrayList<LotPiece> liste_lot_piece;
    String piece;
    int duree;
    
    public Meuble(ArrayList<LotPiece> liste, String piece, int duree){
        this.piece=piece;
        this.duree=duree;
        liste_lot_piece=new ArrayList<LotPiece>();
        liste_lot_piece.addAll(liste); //a tester si addAll ca marche bien
        prix=0d;
        for(int i = 0; i<liste.size(); i++){
            prix=prix+liste.get(i).prix;
        }
    }

}
//pour la construction de la liste meuble et le tableau de rangee , on mettre le nombre de fois la piece x par rapport a son volume ,cad si le volume de vis necessairre/a ranger est 3,on mettra vis 3 fois dans la liste/tableau