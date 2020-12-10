package projet;
public abstract class Chef extends Personne{

     int tailleeq;
     Ouvrier liste_ouv[]= new Ouvrier[4];

    public Chef(String nom, String prenom, int tailleeq, boolean actif){
        super(nom, prenom, actif);
        this.tailleeq = this.tailleeq;
        this.actif = actif; 
    }

    public void recruterouv(String nom,String prenom,String specialite){
        for(int j=0;j<4;j++){
            if(liste_ouv[j]==null){
                liste_ouv[j]=new Ouvrier(nom,prenom,specialite);
                 tailleeq++;
                 return;
    }}}

    public void licencier_ouvrier(int k){
        liste_ouv[k]=null;
        tailleeq--;
    }

   // public abstract int ajouterlot(LotPiece lp, Entrepot e2);
   // public abstract void retirerlot(Entrepot e1,int rangee,int place);

   // public abstract void deplacerlot(Entrepot e1,int idlot,int rangee1, int rangee2);

}