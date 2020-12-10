package projet;

public class Chefstock extends Chef{
    public Chefstock(String nom,String prenom){
        super(nom, prenom, 0, false);
    }

    public void retirerlot(Entrepot e1,int rangee,int place){
        e1.ligne[rangee].place[place].volume--;
       // e1.ligne[rangee].place[place].liste.remove(0);
        actif=true;
        //on prendra d'abord le lot le plus a droite
    }

    //j'ai fait deplacerlot d'une rangee donner a une autre rangee donner qu'on devra surement chercher dans une autre fonction de sorte a ce qu'elle convienne
    public void deplacerlot(Entrepot e1,int idlot,int rangee1, int rangee2){
        int vol=0;
        LotPiece lotdep=null;
        for(int i=0;i<e1.n;i++){
            if(e1.ligne[rangee1].place[i]!=null){
                if(e1.ligne[rangee1].place[i].id==idlot){
                    vol=e1.ligne[rangee1].place[i].volume;
                    lotdep=e1.ligne[rangee1].place[i];
                    e1.ligne[rangee1].place[i]=null;

                }}
        }
        int a=0;
        for(int j=0;j<e1.n;j++){
            if(e1.ligne[rangee2].place[j]==null){
                a++;
            }
            else{
                a=0;
            }
            if(a==vol){
                for(int k=0;k<a;k++){
                    e1.ligne[rangee2].place[j-k]=lotdep;
                }
                actif=true;
                return;
            }
        }
    }

    public int ajouterlot(LotPiece lot,Entrepot e1){
        int a;
        for(int i=0;i<e1.m;i++){
            if(e1.ligne[i].taille_restante>=lot.volume){
                a=0;
                for(int j=0;j<e1.n;j++){
                    if(e1.ligne[i].place[j]==null){
                        a++;
                    }
                    else{
                        a=0;
                    }
                    if(a==lot.volume){
                        for(int k=0;k<a;k++){
                            e1.ligne[i].place[j-k]=lot;
                        }
                        actif=true;
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}