package projet;

public class Chefbrico extends Chef{
    int pas_restantmeuble=0;
    public Chefbrico(String nom,String prenom){
        super(nom,prenom,0,false);
    }

    // public monterMeuble(){

    // }

    public int ajouterlot(LotPiece lp, Entrepot e2){return -1;}
    public void retirerlot(Entrepot e1,int rangee,int place){return ;}

    public void deplacerlot(Entrepot e1,int idlot,int rangee1, int rangee2){return ;}
}