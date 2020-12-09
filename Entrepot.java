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
    ArrayList<Chef> chef_equipe= new ArrayList<Chef>();
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
                    c=c+ ligne[i].place[j].liste.get(0).nom +" en "+ ligne[i].place[j].volume +" quantite, ";
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
        chef_equipe.add(new Chefstock(nom,prenom));
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




}