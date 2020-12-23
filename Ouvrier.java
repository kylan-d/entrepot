package projet;

public class Ouvrier extends Personne {
    String specialite;
    int pas_restantmeuble=0;

    public Ouvrier(String nom, String prenom, String specialite) {
        super(nom, prenom, false);
        this.specialite = specialite;
    }



    //je pense qu'il  faudrait set l'ouvrier en actif quand il recoit un truc a faire mais j'ai des sur ou le faire et comment le eemettre en inactif

    //attention a ce que ce soit la premiere place de lot et qui vol soit inferieur au volume totale du lot
    public void retirerlot(Entrepot e1,int rangee,int place,int vol){
        for(int j=0;j<vol;j++) {
            e1.ligne[rangee].place[place+j].volume--;
            e1.ligne[rangee].place[place+j]=null;
        }
        // e1.ligne[rangee].place[place].liste.remove(0);
        actif=true;
        //on prendra d'abord le lot le plus a droite
    }
    public void retirerlot(Entrepot e1,int idlot){
        for(int i=0;i<e1.m;i++){
            for(int j=0;j<e1.n;j++){
                if(e1.ligne[i].place[j]!=null) {
                    if (e1.ligne[i].place[j].id == idlot) {
                        e1.ligne[i].place[j].volume--;
                        e1.ligne[i].place[j]=null;
                    }
                }
            }
        }
    }
    public void retirerlot(Entrepot e1,String nom){
        int memid=-1;
        for(int i=0;i<e1.m;i++){
            for(int j=0;j<e1.n;j++){
                if(e1.ligne[i].place[j]!=null) {
                    if (e1.ligne[i].place[j].piece.nom.equals(nom)) {
                        if(memid==-1) {
                            memid=e1.ligne[i].place[j].id;
                            e1.ligne[i].place[j].volume--;
                            e1.ligne[i].place[j] = null;
                        }
                        else if(memid==e1.ligne[i].place[j].id){
                            e1.ligne[i].place[j].volume--;
                            e1.ligne[i].place[j] = null;
                        }
                    }
                }
            }
        }
    }
    //j'ai fait deplacerlot d'une rangee donner a une autre rangee donner qu'on devra surement chercher dans une autre fonction de sorte a ce qu'elle convienne
    public int deplacerlot(Entrepot e1, int idlot, int rangee1, int rangee2) {
        int vol=-1;
        int verifpossible=0;

        int res=-1;
        LotPiece lotdep = null;

        for(int i2 =0; i2<e1.n; i2++) {
            if(e1.ligne[rangee1].place[i2]!=null) {
                if(e1.ligne[rangee1].place[i2].id==idlot) {
                    vol=e1.ligne[rangee1].place[i2].volume;
                    lotdep=e1.ligne[rangee1].place[i2];
                    //e1.ligne[rangee1].place[i]=null;
                }
            }
        }

        int a2=0;
        for(int j2 = 0; j2<e1.n ; j2++) {
            if(e1.ligne[rangee2].place[j2]== null) {
                a2++;
            }
            else {
                a2=0;
            }
            if(a2==vol) {
                verifpossible=1;
            }
        }
        if(verifpossible==1){
            for(int i=0;i<e1.n;i++){
                if(e1.ligne[rangee1].place[i]!=null){
                    if(e1.ligne[rangee1].place[i].id==idlot){
                        vol=e1.ligne[rangee1].place[i].volume;
                        lotdep=e1.ligne[rangee1].place[i];
                        e1.ligne[rangee1].place[i]=null;}
                }
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
                    res=1;
                    break;
                }
            }
        }
        return res;
    }

    public int ajouterlot(LotPiece lot,Entrepot e1){
        int a;
        int res = -1;
        recherche:
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
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }

    public void monterMeuble(Meuble m){
        actif = true;
        pas_restantmeuble=m.duree;
    }


}
