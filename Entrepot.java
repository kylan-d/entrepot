package projet;
import java.util.ArrayList;
public class Entrepot{
    int m;
    int n;
    double tresorerie;
    int nbinactcehefstock;
    int nbinactchefbrico;
    int nbinactouvrier;
    //pour voir le nombre de lot qu'on peut deplacer et faire gagner du temps a la simulation
    public ArrayList<Chef> chef_equipe=new ArrayList<>();
    Rangee ligne[];
    public Entrepot(int m,int n,double tresorerie){
        this.m=m;
        this.n=n;
        ligne=new Rangee[m];
        for(int i=0;i<m;i++){
            ligne[i]=new Rangee(n);
        }
        this.tresorerie=tresorerie;

    }
    public void faireInventaire(){
        int memid=-1;
        int placerest=0;
        String c="dans l'entrepot il y a:";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ligne[i].place[j]!=null && memid!=ligne[i].place[j].id){
                    c=c+ ligne[i].place[j].piece.nom +" en "+ ligne[i].place[j].volume +" quantite, ";
                    memid=ligne[i].place[j].id;
                }
            }
            placerest=placerest+ligne[i].taille_restante;
        }
        System.out.println(c);
    }



    public void payer() {
        tresorerie = tresorerie - 10 * chef_equipe.size();
        for (int i = 0; i < chef_equipe.size();i++) {
            tresorerie=tresorerie-5*chef_equipe.get(i).tailleeq;
        }
    }
    public void recruterchefbrico(String nom,String prenom){

        chef_equipe.add(new Chefbrico(nom,prenom));
    }
    public void recruterchefstock(String nom,String prenom){
        Chefstock i =new Chefstock(nom,prenom) ;
        chef_equipe.add(i);
    }
    //pour le licenciement de chef d'equipe, dans les questions-reponses il dit qu'il faut reaffecter l'equipe d'un chef licencier,
    // quand le chef ou l'ouvrier  est actif je pense qu'il faudra faire en sorte qu'il soit renvoyé dans x pas de temps, quand il redeviendra inactif, ou si on peut pas reacter les ouvriers pourquoi pas
    //renvoyer une val diff et virer des ouvriers
    //return 1 si virer -1 si pas virer
    //enfaite apres relecture du sujet virer les personnel en fonction de caracteristique(id nom..) ca me semble etre hors propos, je laisse qa au cas ou

    public int licencierChef(){
        int a=0;
        for(int i=0;i<chef_equipe.size();i++){
            a=0;
            if(chef_equipe.get(i).actif==false){
                if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                for(int j=0;j<chef_equipe.size();j++){
                    if(i!=j){
                        a=a+(4-chef_equipe.get(j).tailleeq);


                    if(a>=chef_equipe.get(i).tailleeq){
                        for(int k=0;k<chef_equipe.size();k++){

                            while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                                chef_equipe.get(k).tailleeq++;
                                chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
                                if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}

                        }
                    }}
                }
            }
        } return -1;
    }
    public int licencierChefbrico(){
        int a=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefbrico){
        a=0;
        if(chef_equipe.get(i).actif==false){
            if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
            for(int j=0;j<chef_equipe.size();j++){
                if(i!=j){
                    a=a+(4-chef_equipe.get(j).tailleeq);

                if(a>=chef_equipe.get(i).tailleeq){
                    for(int k=0;k<chef_equipe.size();k++){
                        while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                            chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                            chef_equipe.get(k).tailleeq++;
                            chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
                        if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                    }
                }}
            }
        }
    }} return -1;}
    public int licencierChefstock(){
        int a=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock){
                a=0;
                if(chef_equipe.get(i).actif==false){
                    if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a=a+(4-chef_equipe.get(j).tailleeq);

                        if(a>=chef_equipe.get(i).tailleeq){
                            for(int k=0;k<chef_equipe.size();k++){
                                while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                    chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                                    chef_equipe.get(k).tailleeq++;
                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
                                if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                            }
                        }}
                    }
                }
            }} return -1;}
    public int licencierChef(int id){
        int a=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).id==id){
                a=0;
                if(chef_equipe.get(i).actif==false){
                    if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a=a+(4-chef_equipe.get(j).tailleeq);

                        if(a>=chef_equipe.get(i).tailleeq){
                            for(int k=0;k<chef_equipe.size();k++){
                                while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                    chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                                    chef_equipe.get(k).tailleeq++;
                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
                                if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                            }
                        }}
                    }
                }
            }} return -1;}

    public int licencierChef(String nom,String prenom){
        int a=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).nom==nom && chef_equipe.get(i).prenom==prenom){
                a=0;
                if(chef_equipe.get(i).actif==false){
                    if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a=a+(4-chef_equipe.get(j).tailleeq);

                        if(a>=chef_equipe.get(i).tailleeq){
                            for(int k=0;k<chef_equipe.size();k++){
                                while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                    chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                                    chef_equipe.get(k).tailleeq++;
                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
                                if(chef_equipe.get(i).tailleeq==0){ chef_equipe.remove(i); return 1;}
                            }
                        }}
                    }
                }
            }} return -1;
    }

    public int recruterouvrier(String nom,String prenom,String specialite){
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).tailleeq<4){
                chef_equipe.get(i).recruterouv(nom,prenom,specialite);
                return 1;
            }
        }return -1;
    }
    public int licencierOuvrier(){
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<chef_equipe.get(i).tailleeq;j++){
                if(chef_equipe.get(i).liste_ouv[j].actif==false){
                    chef_equipe.get(i).licencier_ouvrier(j);
                    return 1;
                }
            }
        }return -1;
    }
    public int licencierOuvrier(String  specialite){
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<chef_equipe.get(i).tailleeq;j++){
                if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].specialite==specialite){
                    chef_equipe.get(i).licencier_ouvrier(j);
                    return 1;
                }
            }
        }return -1;
    }
    public int licencierOuvrier(int id){
        for(int i = 0; i<chef_equipe.size(); i++){
            for(int j = 0;j <chef_equipe.get(i).tailleeq; j++){
                if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].id == id){
                    chef_equipe.get(i).licencier_ouvrier(j);
                    return 1;
                }
            }
        }
        return -1;
    }
    
    //public licencierOuvrier(nom prenom){}
    //public licencierOuvrier(nom, prenom, specialite){}

//a chaque fois je retourne -1 si ca a pas pu se faire, 1 sinon
    //j'ai pas testé
public int ajoutlot(LotPiece lot){
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                int b=a.ajouterlot(lot,this);
                return b;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        return chef_equipe.get(i).liste_ouv[j].ajouterlot(lot,this);

                    }
                }
            }
        }
        return -1;
}
    public int retirerlot(int m, int n, int vol){
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,m,n,vol);
                return 1;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        chef_equipe.get(i).liste_ouv[j].retirerlot(this,m,n,vol);
                        return 1;

                    }
                }
            }
        }
       return -1;
    }

//le seul proble c'est que si y'a pas assez d'ouvrier pour tout deplacer bah on le fais pas alors qu'on est censé demander au non actif de deplacer les lots restant dans les pas suivants
    //mais je me suis dis que c'etait pas le plus urgent, enfin si je le fait mais je sais pas si c'est le mieux
public int  montermeuble(Meuble m){
      ArrayList<Integer>  pm=new ArrayList<Integer>();
    ArrayList<Integer>  pn=new ArrayList<Integer>();
        int a=1;
        int pierest=0;
    for(int i=0;i<m.liste_lot_piece.size();i++){
        System.out.println(a);
        if(a!=1){pierest++;}
        a=0;
        for(int im=0;im<this.m;im++){
            for(int in=0;in<this.n;in++){
                if(ligne[im].place[in]!=null){
                    if(ligne[im].place[in].piece.nom.equals(m.liste_lot_piece.get(i).type)){
                        if(ligne[im].place[in].volume>=m.liste_lot_piece.get(i).volume){
                            double pr=ligne[im].place[in].piece.prix;
                            int b=retirerlot(im,in,m.liste_lot_piece.get(i).volume);
                            if(b==-1){return -1;}
                            m.prix=m.prix+(m.liste_lot_piece.get(i).volume*pr);
                            m.liste_lot_piece.get(i).volume=0;
                            a=1;

                        }
                        else{
                            double pr2=ligne[im].place[in].piece.prix;
                            int volret=ligne[im].place[in].volume;
                            int b2=retirerlot(im,in,ligne[im].place[in].volume);

                            if(b2==-1){return -1;}
                            m.prix=m.prix+(m.liste_lot_piece.get(i).volume*pr2);
                            m.liste_lot_piece.get(i).volume=m.liste_lot_piece.get(i).volume-volret;
                        }
                    }
                }
            }
            if(a==1){break;}
        }

    }
    if(pierest!=0){return -1;}
    for(int i=0;i<chef_equipe.size();i++){
        if(chef_equipe.get(i) instanceof Chefbrico && chef_equipe.get(i).actif==false){
            Chefbrico c= (Chefbrico)chef_equipe.get(i);
            c.monterMeuble(m);
            tresorerie=tresorerie+m.prix;
            return 1;
        }
        for(int j=0;j<4;j++){
            if(chef_equipe.get(i).liste_ouv[j]!=null){
                if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].specialite.equals(m.piece)){
                    chef_equipe.get(i).liste_ouv[j].monterMeuble(m);
                    tresorerie=tresorerie+m.prix;
                    return 1;
                }
            }
        }
    }
    return -1;
}

public void rendreactif(){
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefbrico){
                if(((Chefbrico) chef_equipe.get(i)).pas_restantmeuble>0){
                    ((Chefbrico) chef_equipe.get(i)).pas_restantmeuble--;
                    if(((Chefbrico) chef_equipe.get(i)).pas_restantmeuble==0){
                        chef_equipe.get(i).actif=false;
                    }
                }

           }
            else{
                chef_equipe.get(i).actif=false;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].pas_restantmeuble>0){
                        chef_equipe.get(i).liste_ouv[j].pas_restantmeuble--;
                        if(chef_equipe.get(i).liste_ouv[j].pas_restantmeuble==0){
                            chef_equipe.get(i).liste_ouv[j].actif=false;
                        }
                    }
                }
            }
        }
}
}