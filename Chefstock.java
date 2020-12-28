package projet;

public class Chefstock extends Chef{

    public Chefstock(String nom, String prenom) {
        super(nom,prenom,0,false);
    }

    public void retirerlot(Entrepot e1, int rangee, int place, int vol) {
        for(int i = 0; i<vol; i++) {
            e1.ligne[rangee].place[place+i].volume--;
            e1.ligne[rangee].place[place+i]=null;
            actif=true;
        }

    }

    public void retirerlot(Entrepot e1,int idlot){
        for(int i=0;i<e1.m;i++){
            for(int j=0;j<e1.n;j++){
                if(e1.ligne[i].place[j]!=null) {

                    if (e1.ligne[i].place[j].id == idlot) {
                        actif=true;
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
                            actif=true;
                            memid=e1.ligne[i].place[j].id;
                            e1.ligne[i].place[j].volume--;
                            e1.ligne[i].place[j] = null;
                        }
                        else if(memid==e1.ligne[i].place[j].id){
                            actif=true;
                            e1.ligne[i].place[j].volume--;
                            e1.ligne[i].place[j] = null;
                        }
                    }
                }
            }
        }

    }
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
            if(e1.ligne[rangee2].place[j2]== null || (a2!=0 &&e1.ligne[rangee2].place[j2].id==idlot)) {
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

    public int ajouterlot(LotPiece lot, Entrepot e1) {
        int a;
        int res = -1;
        recherche:
        for(int i=0; i<e1.m; i++) {
            if(e1.ligne[i].taille_restante>=lot.volume) {
                a=0;
                for(int j=0; j<e1.n;j++) {
                    if(e1.ligne[i].place[j]==null) {
                        a++;
                    }
                    else {
                        a=0;
                    }
                    if(a==lot.volume) {
                        for(int k=0;k<a;k++) {
                            e1.ligne[i].place[j-k]=lot;
                        }
                        actif = true;
                        res =  1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }













}

