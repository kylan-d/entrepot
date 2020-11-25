package projet;
import java.util.ArrayList;
public class Entrepot{
    int m;
    int n;
    double tresorerie;
    ArrayList<Chef> chef_equipe= new ArrayList<Chef>();
    Rangee ligne[];
    public Entrepot(int m,int n,double tresorerie){
        m=this.m;
        n=this.n;
        ligne=new Rangee[m];
        for(int i=0;i<m;i++){
            ligne[i]=new Rangee(n);
        }
        tresorerie=this.tresorerie;

    }
    public void faireInventaire(){
        int memid=-1;
        int placerest=0;
        String c="dans l'entrepot il y a:";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ligne[i].place[j]!=null && memid!=ligne[i].place[j].id){
                    c=c+ ligne[i].place[j].nom +" en "+ ligne[i].place[j].volume +" quantite";
                    memid=ligne[i].place[j].id;
                }
            }
            placerest=placerest+ligne[i].taille_restante;
        }
    }
    //pas tester !!


    public void payer() {
        tresorerie = tresorerie - 10 * chef_equipe.size();
        for (int i = 0; i < chef_equipe.size();i++) {
            tresorerie=tresorerie-5*chef_equipe.get(i).tailleeq;
        }
    }
    //public licencierChef(){}
}