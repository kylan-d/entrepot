package projet;
import java.util.ArrayList;

public class Entrepot {
    int m;
    int n;
    double tresorerie;
    int nbactchefstock;
    int nbactchefbrico;
    int nbactouvrier;
    static String[] nomspe = {"salon", "salledebain", "cuisine", "chambre", "toilette", "salleamanger"};

    static String nompiece[] = {"porte", "charniere", "tiroir", "poignee", "cheville", "vis", "planche", "tasseau", "equerre", "boulon", "clou"};
    static double prixpiece[] = {2000, 400, 1300, 400, 200, 600, 1000, 900, 400, 800, 500};
    static String nommeuble[] = {"commode", "lit", "etagere", "placard", "bureau", "table", "meubletv"};
    ArrayList<Meuble> meublepasfini = new ArrayList<Meuble>();
    ArrayList<Chef> chef_equipe = new ArrayList<Chef>();
    Rangee[] ligne;

    public Entrepot(int m, int n, double tresorerie) {
        this.m = m;
        this.n = n;
        this.tresorerie = tresorerie;
        ligne = new Rangee[m];
        for(int i=0; i<m; i++) {
            ligne[i] = new Rangee(n);
        }
    }

    public String faireInventaire(){
        int memid=-1;
        int placerest=0;
        String c="Dans l'entrepot il y a : ";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ligne[i].place[j]!=null && memid!=ligne[i].place[j].id){
                    c=c+ ligne[i].place[j].piece.nom +" en "+ ligne[i].place[j].volume +" quantité. \n";
                    memid=ligne[i].place[j].id;
                }
            }
            placerest=placerest+ligne[i].taille_restante;
        }
        return c;
    }

    public void meubleAFinir() {
        System.out.println("\nLes meubles à finir sont : \n ");
        for(int i = 0; i<meublepasfini.size(); i++) {
            System.out.println("Meuble n° "+i+ " : [ Nom :  "+ meublepasfini.get(i).nom + " | Pièce :  "+ meublepasfini.get(i).piece+" | Durée : "+ meublepasfini.get(i).duree + " ] \n");
        }
    }



    public void payer() {
        tresorerie -=  (10 * chef_equipe.size());
        for (int i = 0; i<chef_equipe.size();i++) {
            tresorerie -= (5*chef_equipe.get(i).tailleeq);
        }
    }

    public void recruterchefbrico(String nom,String prenom){
        chef_equipe.add(new Chefbrico(nom,prenom));
    }

    public void recruterchefbrico(Chefbrico c) {
        if(c instanceof Chefbrico) {
            chef_equipe.add(c);
        }
        else { System.out.println("Désolé, ce n'est pas un Chef brico.");}
    }

    public void recruterchefstock(String nom,String prenom){
        chef_equipe.add(new Chefstock(nom,prenom));
    }

    public void recruterchefstock(Chefstock c) {
        if(c instanceof Chefstock) {
            chef_equipe.add(c);
        }
        else { System.out.println("Désolé, ce n'est pas un Chef stock.");}
    }


    //pour le licenciement de chef d'equipe, dans les questions-reponses il dit qu'il faut reaffecter l'equipe d'un chef licencier,
    // quand le chef ou l'ouvrier  est actif je pense qu'il faudra faire en sorte qu'il soit renvoyé dans x pas de temps, quand il redeviendra inactif, ou si on peut pas reacter les ouvriers pourquoi pas
    //renvoyer une val diff et virer des ouvriers
    //return 1 si virer -1 si pas virer
    //enfaite apres relecture du sujet virer les personnel en fonction de caracteristique(id nom..) ca me semble etre hors propos, je laisse qa au cas ou

    public int licencierChef(){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            a=0;
            if(chef_equipe.get(i).actif==false){
                if(chef_equipe.get(i).tailleeq==0){
                    chef_equipe.remove(i);
                    res = 1;
                    break;
                }
                for(int j=0;j<chef_equipe.size();j++){
                    if(i!=j){
                        a+= (4-chef_equipe.get(j).tailleeq);
                        if(a>=chef_equipe.get(i).tailleeq){
                            for(int k=0;k<chef_equipe.size();k++){
                                if(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                    for(int chgt2=0;chgt2<4;chgt2++){
                                        for(int chgt=0;chgt<4;chgt++){
                                            if(chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null){
                                                chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];

                                                chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                chef_equipe.get(k).tailleeq++;
                                                chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                            }}}}
                                if(chef_equipe.get(i).tailleeq == 0){
                                    chef_equipe.remove(i);
                                    res = 1;
                                    break recherche;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public int licencierChefbrico(){
        int a = 0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefbrico){
                a=0;
                if(chef_equipe.get(i).actif == false){
                    if(chef_equipe.get(i).tailleeq == 0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+= (4-chef_equipe.get(j).tailleeq);

                            if(a>=chef_equipe.get(i).tailleeq){
                                for(int k=0;k<chef_equipe.size();k++){

                                    if(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                            if(chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null){
                                        chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];

                                        chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                        chef_equipe.get(k).tailleeq++;
                                        chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                    }}}}
                                    if(chef_equipe.get(i).tailleeq==0){
                                        chef_equipe.remove(i);
                                        res =  1;
                                        break recherche;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }



    public int licencierChefstock(){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock){
                a=0;
                if(chef_equipe.get(i).actif==false){
                    if(chef_equipe.get(i).tailleeq==0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+= (4-chef_equipe.get(j).tailleeq);
                            if(a>=chef_equipe.get(i).tailleeq){
                                for(int k=0;k<chef_equipe.size();k++){
                                    if(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null){
                                                    chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];

                                                    chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).tailleeq++;
                                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).tailleeq==0){
                                        chef_equipe.remove(i);
                                        res = 1;
                                        break recherche;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }



    public int licencierChef(int id){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).id==id){
                a=0;
                if(chef_equipe.get(i).actif==false){
                    if(chef_equipe.get(i).tailleeq==0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+=(4-chef_equipe.get(j).tailleeq);
                            if(a>=chef_equipe.get(i).tailleeq){
                                for(int k=0;k<chef_equipe.size();k++){
                                    if(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null){
                                                    chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];
                                                    System.out.println(chgt);
                                                    chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).tailleeq++;
                                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).tailleeq==0){
                                        chef_equipe.remove(i);
                                        res = 1;
                                        break recherche;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }




    public int licencierChef(String nom,String prenom){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).nom==nom && chef_equipe.get(i).prenom==prenom){
                a=0;
                if(chef_equipe.get(i).actif==false){
                    if(chef_equipe.get(i).tailleeq==0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+=(4-chef_equipe.get(j).tailleeq);
                            if(a>=chef_equipe.get(i).tailleeq){
                                for(int k=0;k<chef_equipe.size();k++){
                                    if(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null){
                                                    chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];
                                                    System.out.println(chgt);
                                                    chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).tailleeq++;
                                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).tailleeq==0){
                                        chef_equipe.remove(i);
                                        res = 1;
                                        break recherche;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public int recruterouvrier(String nom,String prenom,String specialite){
        int res =-1;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) != null) {
                if(chef_equipe.get(i).tailleeq<4){
                    chef_equipe.get(i).recruterOuv(nom,prenom,specialite);
                    res = 1;
                    break;
                }
            }
        }
        return res;
    }

    public int recruterouvrier(Ouvrier o) {
        int res = -1;
        for(int i=0; i<chef_equipe.size();i++) {
            if(chef_equipe.get(i) != null) {
                if(chef_equipe.get(i).tailleeq<4) {
                    chef_equipe.get(i).recruterOuv(o);
                    res = 1;
                    break;
                }
            }
        }
        return res;
    }


    public int licencierOuvrier(){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//                    if(res == 1) break;
            }
        }return res;
    }


    public int licencierOuvrier(String  specialite){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].specialite==specialite){
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//                    if(res==1) break;
            }
        }
        return res;
    }

    public int licencierOuvrier(int id){
        int res = -1;
        recherche:
        for(int i = 0; i<chef_equipe.size(); i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].id == id){
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//                    if(res==1) break;
            }
        }
        return res;
    }

    public int licencierOuvrier(String nom, String prenom){
        int res = -1;
        recherche:
        for(int i = 0; i<chef_equipe.size(); i++) {
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].nom==nom && chef_equipe.get(i).liste_ouv[j].prenom==prenom) {
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//        			if(res==1) break;
            }
        }
        return res;
    }



    public int licencierOuvrier(String nom, String prenom, String specialite){
        int res = -1;
        recherche:
        for(int i = 0; i<chef_equipe.size(); i++) {
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].nom == nom && chef_equipe.get(i).liste_ouv[j].prenom == prenom && chef_equipe.get(i).liste_ouv[j].specialite == specialite) {
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res =1;
                        break recherche;
                    }}
//        			if(res==1) break;
            }
        }
        return res;

    }

    public int licencierOuvrier(Ouvrier o) {
        int res = -1;
        recherche:
        for(int i=0; i<chef_equipe.size(); i++) {
            System.out.println(chef_equipe.get(i));
            if(chef_equipe.get(i) != null) {
                System.out.println(chef_equipe.get(i).nom);
                for(int j=0;j<4;j++){
                    if(chef_equipe.get(i).liste_ouv[j]!=null){
                        if(chef_equipe.get(i).liste_ouv[j] != null) {
//	        				System.out.println(chef_equipe.get(i).liste_ouv[j].nom);
                            System.out.println(chef_equipe.get(i).liste_ouv[j].actif);
                            if(chef_equipe.get(i).liste_ouv[j].actif == false && chef_equipe.get(i).liste_ouv[j].equals(o)) {
                                System.out.println(chef_equipe.get(i).liste_ouv[j].nom);
                                chef_equipe.get(i).licencier_ouvrier(j);
                                res = 1;
                                break recherche;
                            }}
                    }
                }
            }
        }
        return res;
    }


    //a chaque fois je retourne -1 si ca a pas pu se faire, 1 sinon
    //j'ai pas testé

    public int ajoutlot(LotPiece lot){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a = (Chefstock)chef_equipe.get(i);
                int b= a.ajouterlot(lot,this);
                res = b;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        res = chef_equipe.get(i).liste_ouv[j].ajouterlot(lot,this);
                        break recherche;
                    }
                }
            }
        }
        return res;
    }


    public int retirerlot(int m, int n, int vol){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,m,n,vol);
                res = 1;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        chef_equipe.get(i).liste_ouv[j].retirerlot(this,m,n,vol);
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }
    public int retirerlot(int id){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,id);
                res = 1;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        chef_equipe.get(i).liste_ouv[j].retirerlot(this,id);
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }
    public int retirerlot(String nom){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,nom);
                res = 1;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        chef_equipe.get(i).liste_ouv[j].retirerlot(this,nom);
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }
    public int deplacerlot(int m1, int m2, int idlot){
        int res=-1;
        int test=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).actif==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                res=a.deplacerlot(this,idlot,m1,m2);
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        res = chef_equipe.get(i).liste_ouv[j].deplacerlot(this,idlot,m1,m2);
                        test=1;
                        break;

                    }
                }
            }if(test!=0){break;}
        }
        return res;
    }

    //le seul proble c'est que si y'a pas assez d'ouvrier pour tout deplacer bah on le fais pas alors qu'on est censé demander au non actif de deplacer les lots restant dans les pas suivants
    //mais je me suis dis que c'etait pas le plus urgent, enfin si je le fait mais je sais pas si c'est le mieux
//si on retourne 1 c'est bon, si 0 on a de quoi le faire mais l'ouvrier est occupé, si -1 on refuse la commande du meuble
    public int  montermeuble(Meuble m){
        ArrayList<Integer> pm =new ArrayList<Integer>();
        ArrayList<Integer> pn =new ArrayList<Integer>();
        ArrayList<Integer> lvol =new ArrayList<Integer>();
        int res = 1;
        int a=1;
        int pierest=0;
       // speci:
 //       for(int ce=0;ce<chef_equipe.size();ce++){
   //         if(chef_equipe.get(ce) instanceof Chefbrico){
     //           res=0;
         //       break speci;
           // }
//            for(int ouv=0;ouv<4;ouv++){
  //              if(chef_equipe.get(ce).liste_ouv[ouv]!=null){
    //                if(chef_equipe.get(ce).liste_ouv[ouv].specialite.equals(m.piece)){
      //                  res=0;
        //                break speci;
          //          }
            //    }
            //}
//        }
//        if(res==-1){return -1;}

  //      for(int i=0;i<m.liste_lot_piece.size();i++){
            //System.out.println(a);
    //        if(a!=1){pierest++;}
      //      a=0;

        //    for(int im=0;im<this.m;im++){
          //      for(int in=0;in<this.n;in++){
            //        if(ligne[im].place[in]!=null){
              //          if(ligne[im].place[in].piece.nom.equals(m.liste_lot_piece.get(i).type)){
                //                pm.add(im);
                  //              pn.add(in);
                    //            m.liste_lot_piece.get(i).volume--;
                      //          if(m.liste_lot_piece.get(i).volume==0){a=1;}

 //                       }if(a==1){break;}
   //                 }
     //           }
       //         if(a==1){break;}
         //   }
           // if(a!=1){pierest++;}
   //     }
     //   if(pierest!=0){
       //     return -1;
        //}

        for(int i=0;i<m.liste_lot_piece.size();i++){

            //System.out.println(a);
            if(a!=1){pierest++;}
            a=0;
            recherche:
            for(int im=0;im<this.m;im++){
                for(int in=0;in<this.n;in++){
                    if(ligne[im].place[in]!=null){
                        if(ligne[im].place[in].piece.nom.equals(m.liste_lot_piece.get(i).type)){
                            if(ligne[im].place[in].volume>=m.liste_lot_piece.get(i).volume){
                                double pr=ligne[im].place[in].piece.prix;
                                int b=retirerlot(im,in,m.liste_lot_piece.get(i).volume);
                               if(b==-1){res = -1; break recherche;}
                                m.prix=m.prix+(m.liste_lot_piece.get(i).volume*pr);
                                m.liste_lot_piece.get(i).volume=0;
                                a=1;

                            }
                            else{
                                double pr2=ligne[im].place[in].piece.prix;
                                int volret=ligne[im].place[in].volume;
                                int b2=retirerlot(im,in,ligne[im].place[in].volume);

                                if(b2==-1){
                                    res = -1;
                                    break recherche;
                                }
                                m.prix=m.prix+(m.liste_lot_piece.get(i).volume*pr2);
                                m.liste_lot_piece.get(i).volume=m.liste_lot_piece.get(i).volume-volret;
                            }
                        }if(a==1){break;}
                    }
                }
                if(a==1){break;}
            }
            if(a!=1){pierest++;}
        }
        if(pierest!=0){
            res =-1;
        }
        int parc=0;
        while(parc<m.liste_lot_piece.size()){
            if(m.liste_lot_piece.get(parc).volume==0){
                m.liste_lot_piece.remove(parc);
            }
            else{
                parc++;
            }

        }
        System.out.println(pierest+" piecerestante");
        if(res==-1){return -1;}
        res=-1;
        sortie:
        for(int i=0;i<chef_equipe.size();i++){

            if(chef_equipe.get(i) instanceof Chefbrico && chef_equipe.get(i).actif==false){
                Chefbrico c= (Chefbrico)chef_equipe.get(i);
                c.monterMeuble(m);
                System.out.println("on termine un meuble");
              tresorerie += m.prix;
//                tempo += m.calculerPrix(ligne);
                res = 1;
                System.out.println("llaaa");
                break sortie;
            }

            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false && chef_equipe.get(i).liste_ouv[j].specialite.equals(m.piece)){
                        chef_equipe.get(i).liste_ouv[j].monterMeuble(m);
                        System.out.println("on termine un meuble");
                      tresorerie += m.prix;
//                        tempo += m.calculerPrix(ligne);
                        res = 1;
                        break sortie;
                    }
                }
            }
        }
        return res;
    }

    public void rendreactif(){
        System.out.println("actifff");
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefbrico){
                if(((Chefbrico) chef_equipe.get(i)).pas_restantmeuble>0){
                    ((Chefbrico) chef_equipe.get(i)).pas_restantmeuble--;}
                if(((Chefbrico) chef_equipe.get(i)).pas_restantmeuble==0){
                    chef_equipe.get(i).actif=false;
                }


            }
            else{
                chef_equipe.get(i).actif=false;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].pas_restantmeuble>0){
                        chef_equipe.get(i).liste_ouv[j].pas_restantmeuble--;}
                    if(chef_equipe.get(i).liste_ouv[j].pas_restantmeuble==0){
                        chef_equipe.get(i).liste_ouv[j].actif=false;
                    }
                }

            }
        }
    }

    public String afficherEquipe() {
        String res = "";
        int cid = -1;
        for(int i=0; i<this.chef_equipe.size(); i++) {
            if(this.chef_equipe.get(i) != null && cid != this.chef_equipe.get(i).id) {
                res += "{ Chef d'équipe : ID : " + this.chef_equipe.get(i).id + " | Nom : " + this.chef_equipe.get(i).nom + " | Prenom : " + this.chef_equipe.get(i).prenom + " | Actif : "+ this.chef_equipe.get(i).actif+ " } \nListe ouvrier :  \n" + this.chef_equipe.get(i).afficherOuvrier();
                cid = this.chef_equipe.get(i).id;
            }
        }
        return res;
    }


    public int compteinactif(){
        int nbinact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).actif==false){
                nbinact++;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        nbinact++;
                    }
                }
            }
        }
        return nbinact;
    }
    public int compteinactifbr(){
        int nbinact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).actif==false && chef_equipe.get(i) instanceof Chefbrico){
                nbinact++;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        nbinact++;
                    }
                }
            }
        }
        return nbinact;
    }
    public int compteinactifst(){
        int nbinact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).actif==false && chef_equipe.get(i) instanceof Chefstock){
                nbinact++;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==false){
                        nbinact++;
                    }
                }
            }
        }
        return nbinact;
    }

    public int compteactif(){
        int nbact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).actif==true){
                nbact++;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].actif==true){
                        nbact++;
                    }
                }
            }
        }
        return nbact;
    }

    public void optirangementstrat1(){
        int remp=0;
        int remp2=0;
        for(int i=0;i<m;i++){
            remp=0;
            remp2=0;
            for(int j=0;j<n;j++){
                if(ligne[i].place[j]!=null){
                    remp++;
                }
            }
            if(remp!=n){
                while(ligne[i].place[remp2]!=null){
                    remp2++;
                }
                if(remp2!=remp){
                    for(int k=remp2;k<n;k++){
                        if(ligne[i].place[k]!=null){
                            this.deplacerlot(i,i,ligne[i].place[k].id);
                        }
                    }
                }
            }
        }
    }
    public void stratrangement2(){
        int remp=0;
        int remp2=0;
        int memidlot=-1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(ligne[i].place[j]!=null){
                    int k=0;
                    int test=-1;
                    while(test==-1){

                        if(k==i){break;}
                        test=deplacerlot(i,k,ligne[i].place[j].id);
                        k++;
                        if(k==i){break;}


                    }
                }

            }
        }
    }
public void strat1(int i,int xpasdetemps,int inactmin,int inactmax){
         if(xpasdetemps!=0){
             if (i % xpasdetemps == 0) {//ici on fais la division euclidienne du pas te temps ou l'on se trouve symbolise par i par xpasdetemps et on garde le reste, donc si xpasdetemps =10 on fera la methode tout les 10 pas de temps
           optirangementstrat1();
      }}

          if (compteinactif() <= inactmin) {
        //    if (meublepasfini.size() != 0) {
      //        int spec = i % meublepasfini.size();
    //comme ca on recrute une specialite qui a besoin d'un ouvrier et la division euclidienne pour changer a chaque fois
    //String specrec = meublepasfini.get(spec).piece;
          //String nomrec = "Paul" + i;
        //int testrec = recruterouvrier(nomrec, nomrec, specrec);
      //if (testrec == -1) {
       // recruterchefbrico(nomrec, nomrec);
            //   }
          //   }
            //else {
                   String nomrec = "Paul" + i;
    // la on pourrai utiliser un tableau de specialite pour en tirer une au sort et la donner a l'ouvrier
              ArrayList<Integer> nbspe=new ArrayList<Integer>();
              for(int j=0;j<nomspe.length;j++){
                  nbspe.add(comptespe(nomspe[j]));
              }
              int nbmin=nbspe.get(0);
              int placemin=0;
              for(int k=0;k<nomspe.length;k++){
                  if(nbmin>nbspe.get(k)){
                      placemin=k;
                  }
              }
      int testrec = recruterouvrier(nomrec, nomrec, nomspe[placemin]);
        if (testrec == -1) {
              recruterchefbrico(nomrec, nomrec);
            }
          //}
        } else if (compteinactif() >= inactmax) {
              int testlic = licencierChefstock();
            if (testlic == -1) {
        testlic = licencierOuvrier();
          if (testlic == -1) {
                licencierChefbrico();
              }
            }
          }
}
    public void strat2(){

        if(compteinactif()==0){
                  int recru=recruterouvrier("John","Doe",nomspe[(int)Math.random()*nomspe.length]);
                  if(recru==-1){
                    double pileouface=Math.random();
                  if(pileouface<0.5){
                    recruterchefbrico("John","Doe");
                }
              else{
                recruterchefstock("John","Doe");
          }}
              }
               else if(compteinactifst()==0){
            int recru=recruterouvrier("John","Doe",nomspe[(int)Math.random()*nomspe.length]);
            if(recru==-1){
                    recruterchefstock("John","Doe");

            }
        }       else if(compteinactifbr()==0){
                    recruterchefbrico("John","Doe");

            }

           else{

             stratrangement2();
        }


    }
    public int comptespe(String spe){
        int nb=0;
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).liste_ouv[j]!=null){
                    if(chef_equipe.get(i).liste_ouv[j].specialite.equals(spe)){
                        nb++;
                    }
                }
            }
        }
        return nb;
    }

    public void stratretirerlot1(int nbpasdetemps,int nbconservationlot){
        int idplusancienlot=-1;
        int idplusrecentlot=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ligne[i].place[j]!=null){
                    if(idplusancienlot==-1){
                        idplusancienlot=ligne[i].place[j].id;
                    }
                    if(idplusrecentlot==-1){
                        idplusrecentlot=ligne[i].place[j].id;
                    }
                    if(ligne[i].place[j].id<idplusancienlot){
                        idplusancienlot=ligne[i].place[j].id;
                    }
                    if(ligne[i].place[j].id>idplusrecentlot){
                        idplusrecentlot=ligne[i].place[j].id;
                    }
                }
            }
        }
        if(idplusrecentlot-idplusancienlot>nbconservationlot){
            retirerlot(idplusancienlot);
            System.out.println("on supp un lot");
        }


    }
    public void stratretirerlot2(int pourcent){
        ArrayList<Paire> piece=new ArrayList<Paire>();
        int r=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if (ligne[i].place[j] != null) {
                    r=0;
                    for(int k=0;k<piece.size();k++){
                        if(ligne[i].place[j].piece.nom.equals(piece.get(k).type)){
                            piece.get(k).volume++;
                            r++;
                            break;
                        }
                        if(r==0){piece.add(new Paire(1,ligne[i].place[j].piece.nom));}
                    }
                }
            }
        }
        int max=0;
        int place=0;
        for(int l=0;l<piece.size();l++){
            if(piece.get(l).volume>max){
                place=l;
            }
        }
        if(piece.size()!=0){
        if((m*n*pourcent)/100<piece.get(place).volume) {
            retirerlot(piece.get(place).type);
            System.out.println("on supp un lot");
        }
    }}

    public int  montermeuble2(Meuble m){
        int res = -1;
        recherche:
        for(int lg=0;lg<this.m;lg++){
            if(ligne[lg] !=null){ // On parcours les rangée
                for(int pl=0;pl<this.n;pl++){  // On parcours les lots dans la rangée
                    if(ligne[lg].place[pl] != null){ // Si dans la rangée, il y a des lots
                        for(int i=0;i<m.liste_lot_piece.size();i++){ // On parcours la liste des pièces nécéssaire au montage du meuble que l'on a passer en paramettre
                            if(ligne[lg].place[pl].piece.nom.equals(m.liste_lot_piece.get(i).type)){ // Si on a la pièce dispo en entrepot
                                if(ligne[lg].place[pl].volume>=m.liste_lot_piece.get(i).volume){ // On check si il y a une qté suffisante

                                    for(int j = 0; j<chef_equipe.size(); j++) {
                                        System.out.println(chef_equipe.get(j).prenom);
                                        if(chef_equipe.get(j) instanceof Chefbrico && chef_equipe.get(j).actif == false) {
                                            double prix = m.calculerPrix(ligne[lg].place[pl]);
                                            int b = retirerlot(lg,pl,m.liste_lot_piece.get(i).volume);
                                            Chefbrico c = (Chefbrico)chef_equipe.get(j);
                                            c.monterMeuble(m);
                                            tresorerie+=prix;
                                            System.out.println("Lot retiré : "+b);
                                            System.out.println("Meuble montée ! ");
                                            res = 1;
                                            break recherche;
                                        }
                                        else {
                                            for(int k=0;k<chef_equipe.get(j).liste_ouv.length; k++) {
                                                if(chef_equipe.get(j).liste_ouv[k]!= null && chef_equipe.get(j).liste_ouv[k].actif == false && chef_equipe.get(j).liste_ouv[k].specialite.equals(m.piece)) {
                                                    double prix = m.calculerPrix(ligne[lg].place[pl]);
                                                    int b = retirerlot(lg,pl,m.liste_lot_piece.get(i).volume);
                                                    Ouvrier o = (Ouvrier)chef_equipe.get(j).liste_ouv[k];
                                                    o.monterMeuble(m);
                                                    tresorerie+=prix;
                                                    System.out.println("Meuble montée ! ");
                                                    res = 1;
                                                    break recherche;
                                                }
                                            }
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Désolé, il n'y pas la quantité de pièce suffisante pour monter le meuble. ");
                                }
                            }
                            else {
                                System.out.println("Désolé, il n'y a pas de pièce dispo pour le montage du meuble");
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
