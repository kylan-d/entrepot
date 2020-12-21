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
                                while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                    chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];
                                    chef_equipe.get(k).tailleeq++;
                                    chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
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
                                    while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                                        chef_equipe.get(k).tailleeq++;
                                        chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                    }
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
                                    while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];
                                        chef_equipe.get(k).tailleeq++;
                                        chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
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
                                    while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];
                                        chef_equipe.get(k).tailleeq++;
                                        chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                    }
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
                                    while(chef_equipe.get(k).tailleeq<4 && chef_equipe.get(i).tailleeq!=0 && i!=k){
                                        chef_equipe.get(k).liste_ouv[chef_equipe.get(k).tailleeq]=chef_equipe.get(i).liste_ouv[chef_equipe.get(i).tailleeq-1];

                                        chef_equipe.get(k).tailleeq++;
                                        chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;}
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
        recherche:
        for(int i=0;i<m.liste_lot_piece.size();i++){
            //System.out.println(a);
            if(a!=1){pierest++;}
            a=0;

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
            for(int j=0;j<n;j++){
                if(ligne[i].place[j]!=null){
                    int k=0;
                    while(deplacerlot(i,k,ligne[i].place[j].id)==-1){
                        k++;
                        if(k==i){break;}
                    }
                }

            }
        }
    }
public void strat1(int i,int xpasdetemps,int inactmin,int inactmax){
         if (i % xpasdetemps == 0) {//ici on fais la division euclidienne du pas te temps ou l'on se trouve symbolise par i par xpasdetemps et on garde le reste, donc si xpasdetemps =10 on fera la methode tout les 10 pas de temps
           optirangementstrat1();
      }

          if (compteinactif() <= inactmin) {
            if (meublepasfini.size() != 0) {
              int spec = i % meublepasfini.size();
    //comme ca on recrute une specialite qui a besoin d'un ouvrier et la division euclidienne pour changer a chaque fois
    String specrec = meublepasfini.get(spec).piece;
          String nomrec = "Paul" + i;
        int testrec = recruterouvrier(nomrec, nomrec, specrec);
      if (testrec == -1) {
        recruterchefbrico(nomrec, nomrec);
               }
             } else {
                   String nomrec = "Paul" + i;
    // la on pourrai utiliser un tableau de specialite pour en tirer une au sort et la donner a l'ouvrier
      int testrec = recruterouvrier(nomrec, nomrec, "toilette");
        if (testrec == -1) {
              recruterchefbrico(nomrec, nomrec);
            }
          }
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
          }
              }
        }
           else{
             stratrangement2();
        }


    }
}
