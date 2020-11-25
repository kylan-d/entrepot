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
    //public faireInventaire(){}
    //public payerOuvrier(){}
    //public payerChef(){}
    //public licencierChef(){}
}