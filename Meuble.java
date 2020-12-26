package projet;
import java.util.ArrayList;

public class Meuble {
    ArrayList<Paire> liste_lot_piece;
    String piece;
    int duree;
    double prix;
    String nom;

    public Meuble( String nom,String piece, int duree){
        this.nom=nom;
        this.piece=piece;
        this.duree=duree;
        liste_lot_piece=new ArrayList<Paire>();

    }

    public void addcompo(Paire p){
        liste_lot_piece.add(p);
    }

    public double calculerPrix(Rangee[] ligne) {
        double resultat = 0;
        for(int i = 0; i<ligne.length; i++) {
            for(int j = 0; i<ligne[i].place.length;j++) {
                if(ligne[i].place[i].piece.nom.equals(liste_lot_piece.get(i).type)) {
                    resultat += (ligne[i].place[i].piece.prix * liste_lot_piece.get(i).volume);
                }
            }
        }
        prix = resultat;
        System.out.println(resultat);
        return resultat;

    }
    public double calculerPrix(LotPiece lp) {
        double resultat = 0;
        for(int k = 0; k<liste_lot_piece.size(); k++) {
            if(lp.piece.nom.equals(liste_lot_piece.get(k).type)) {
                resultat += (lp.prix * liste_lot_piece.get(k).volume);
            }
        }

        prix = resultat;
        return resultat;
    }

}

