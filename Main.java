package projet;
import projet.LotPiece.Piece;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("  ____  _ _ _                       \r\n"
                + " |  _ \\(_) | |                      \r\n"
                + " | |_) |_| | | ___  _ __ ___   ___  \r\n"
                + " |  _ <| | | |/ _ \\| '_ ` _ \\ / _ \\ \r\n"
                + " | |_) | | | | (_) | | | | | | (_) |\r\n"
                + " |____/|_|_|_|\\___/|_| |_| |_|\\___/ \r\n"
                + "                                    \r\n"
                + "                                    ");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for (int j = 0; j < 10; j++) {
                if (i < 220) {
                    break;
                }
                System.out.println(j);

            }
        }

        Entrepot e2 = new Entrepot(5, 5, 10000);
        //Rangee a= new Rangee(7);
        LotPiece lp = new LotPiece(4, "plache", 4, 20);
        //lp.addPiece("Planche", 3.5, 19.99);
        //lp.addPiece("Vis", 0.5, 1.99);
        LotPiece lp2 = new LotPiece(5, "vis", 3, 3);
        e2.recruterchefstock("paula", "jacquass");
        Chefstock aaa = (Chefstock) e2.chef_equipe.get(0);
        aaa.ajouterlot(lp, e2);
        //lp2.addPiece("Clou", 0.25, 0.99);
//    	System.out.println(lp.toString());
        System.out.println(e2.ligne[0].place[3]);
        //System.out.println(lp.id);
        e2.ligne[1].place[2] = lp2;

        e2.faireInventaire();
        //     Rangee a= new Rangee(7);
        //     a.place[1]=new LotPiece("vis",5.5,4.0,2);
        //     System.out.println(a.place[1]);
        //     a.place[1]=null;
        //     System.out.println(a.place[1]);
        //   double f;
        //  f=54412.2;
        // int c=412;
        // f=f-c;
        // System.out.println(f);


        //System.out.println(e1.chef_equipe.get(0).nom);
        //System.out.println(e1.chef_equipe.size());
        // e1.chef_equipe.get(0).actif=true;
        //e1.chef_equipe.get(1).actif=true;
        //e1.chef_equipe.get(2).actif=true;
        // e1.chef_equipe.get(3).actif=true;

        //System.out.println(e1.chef_equipe.size());
        //  System.out.println(e1.chef_equipe.get(0).nom);
        //System.out.println( e1.chef_equipe.get(2).liste_ouv[1]);
        //   e1.recruterouvrier("rock","pierre", "cuisine");
        //e1.chef_equipe.get(0).liste_ouv[0].ajouterlot(lp,e1);
        //System.out.println(e1.ligne[0].place[0]);
        //   e1.chef_equipe.get(0).liste_ouv[0].deplacerlot(e1,1,0,2);
        //System.out.println(e1.ligne[2].place[3]);
        //  e1.faireInventaire();
        //e1.recruterouvrier("roche","caillou", "toilette");;
        //System.out.println(e1.chef_equipe.get(0).tailleeq);
        //System.out.println(e1.chef_equipe.get(0).liste_ouv[0].nom);
        //System.out.println(e1.chef_equipe.get(0).liste_ouv[1].nom);
        //System.out.println(e1.chef_equipe.get(0).tailleeq);
        //System.out.println("on est la3");
        //e1.licencierChefbrico();
        //    System.out.println(e1.chef_equipe.get(0).tailleeq);
        //System.out.println("on est la2");
        //System.out.println(e1.chef_equipe.get(0).liste_ouv[1].nom);
        //System.out.println("on est la");
        //   e1.licencierOuvrier("toilette");
        //System.out.println(e1.chef_equipe.get(0).liste_ouv[0].nom);
        //System.out.println(e1.chef_equipe.get(0).tailleeq);
        String che = "azertyuiop";
        System.out.println(che.substring(0, 4));
//        try{
        //          BufferedReader reader = new BufferedReader(new FileReader("C:\\test.txt"));
        //        int a=reader.read() ;
        //      System.out.println(a);
        //    String line = reader.readLine();

//            while(line !=null)
        //          {
        //            System.out.println(line);
        //          line = reader.readLine();}


        // } catch (FileNotFoundException e) {
        //       e.printStackTrace();
        // } catch (IOException e) {
        //   e.printStackTrace();
        //}
        ArrayList<Meuble> meublepasfini = new ArrayList<Meuble>();
        //parfois on pas d'ouvrier inactif on pourra donc pas le faire maitenant et faut trouver un moyen de remettre a plus tard

        //juste une base qu'on devra utiliser pour chaque differente stratégie pour trouver la mieux
        try {
            //on pourrait demander le nom du fichier
            Scanner sc = new Scanner(new FileReader("C:\\test.txt"));
            // int a=sc.rea;
            // System.out.println(a);
            double tresor = Double.valueOf(sc.next());
            int m = Integer.valueOf(sc.next());
            int n = Integer.valueOf(sc.next());
            sc.nextLine();
            Entrepot e1 = new Entrepot(m, n, tresor);
            e1.recruterchefbrico("paul", "jacques");
            e1.recruterchefstock("paulo", "jacquot");
            e1.recruterchefstock("paula", "jacquass");
            e1.recruterchefbrico("pauli", "jacquie");
            e1.recruterchefbrico("pauly", "jacquesi");
            e1.recruterchefstock("paulou", "jacquotu");
            e1.recruterchefstock("paulai", "jacquassj");
            e1.recruterouvrier("paulie", "jacquiez", "cuisine");
            e1.recruterouvrier("pauler", "jacquese", "salledebain");
            e1.recruterouvrier("pauloj", "jacquott", "toilette");
            e1.recruterouvrier("paulak", "jacquassd", "salleamanger");
            e1.recruterouvrier("paulim", "jacquier", "salle");
            String line = null;
            int a = 2;
            String line2;
            int i = 1;
            while (sc.hasNext()) {
                if (a == -1) {
                    break;
                }
                line = sc.nextLine();
                System.out.println(line);

                Scanner scl = new Scanner(line);
                while (scl.hasNext()) {
                    line2 = scl.next();
                    //line2=line2.substring(1,line2.indexOf('>'));
                    a = Integer.valueOf(line2);

                    if (a != i) {
                        a = -1;
                        System.out.println("probleme id pas");
                        break;
                    }
                    line2 = scl.next();
                    if (line2.equals("rien")) {
                        System.out.println("on fait rien");
                        break;
                    }
                    //pour monter meuble si on peut pas le faire par manque d'ouvrier, on doit l'etaler sur plusieurs pas de temps
                    //pour lot par manque de place ou meuble par manque de piece, on refuse
                    if (line2.equals("meuble")) {
                        System.out.println("on monte un meuble");
                        String nom = scl.next();
                        String piece = scl.next();
                        int duree = Integer.valueOf(scl.next());
                        Meuble meuble = new Meuble(nom, piece, duree);
                        while (scl.hasNext()) {
                            String type = scl.next();
                            int volume = Integer.valueOf(scl.next());
                            meuble.addcompo(new paires(volume, type));

                        }
                        int test_meuble = e1.montermeuble(meuble);
                        System.out.println(test_meuble);
                        if (test_meuble == -1) {

                            meublepasfini.add(meuble);
                        }
                        System.out.println(e1.tresorerie);
                        break;
                    }
                    if (line2.equals("lot")) {
                        System.out.println("on range un lot");
                        String nom = scl.next();
                        double poids = Double.valueOf(scl.next());
                        double prix = Double.valueOf(scl.next());
                        int volume = Integer.valueOf(scl.next());
                        e1.ajoutlot(new LotPiece(volume, nom, poids, prix));
                        break;
                    }


                }
                i++;
                scl.close();
                int imeu = 0;
                while (imeu < meublepasfini.size()) {

                    int testm = e1.montermeuble(meublepasfini.get(imeu));
                    if (testm == 1) {
                        meublepasfini.remove(imeu);

                    } else {
                        imeu++;
                    }

                }
                e1.payer();
                e1.rendreactif();
                e1.faireInventaire();
                System.out.println(e1.tresorerie);
                //+mettre les actif en inactif sauf si il construit un meuble et il lui reste du temps pour construire ce meuble


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("line\n\n\n\n");


        meublepasfini = new ArrayList<Meuble>();

//variable qu'on pourra demander a l'utilisateur de rentrer
        int inactmax = 5;
        int inactmin = 2;
        int xpasdetemps = 10;

        try {
            //on pourrait demander le nom du fichier
            Scanner sc = new Scanner(new FileReader("C:\\test.txt"));
            // int a=sc.rea;
            // System.out.println(a);
            double tresor = Double.valueOf(sc.next());
            int m = Integer.valueOf(sc.next());
            int n = Integer.valueOf(sc.next());
            sc.nextLine();
            Entrepot e1 = new Entrepot(m, n, tresor);
            e1.recruterchefbrico("paul", "jacques");
            e1.recruterchefstock("paulo", "jacquot");
            e1.recruterchefstock("paula", "jacquass");
            e1.recruterchefbrico("pauli", "jacquie");
            e1.recruterchefbrico("pauly", "jacquesi");
            e1.recruterchefstock("paulou", "jacquotu");
            e1.recruterchefstock("paulai", "jacquassj");
            e1.recruterouvrier("paulie", "jacquiez", "cuisine");
            e1.recruterouvrier("pauler", "jacquese", "salledebain");
            e1.recruterouvrier("pauloj", "jacquott", "toilette");
            e1.recruterouvrier("paulak", "jacquassd", "salleamanger");
            e1.recruterouvrier("paulim", "jacquier", "salle");
            String line = null;
            int a = 2;
            String line2;
            int i = 1;
            while (sc.hasNext()) {
                if (a == -1) {
                    break;
                }
                line = sc.nextLine();
                // System.out.println(line);

                Scanner scl = new Scanner(line);
                while (scl.hasNext()) {
                    line2 = scl.next();
                    //line2=line2.substring(1,line2.indexOf('>'));
                    a = Integer.valueOf(line2);

                    if (a != i) {
                        a = -1;
                        System.out.println("probleme id pas");
                        break;
                    }
                    line2 = scl.next();
                    if (line2.equals("rien")) {
                        System.out.println("on fait rien");
                        break;
                    }
                    //pour monter meuble si on peut pas le faire par manque d'ouvrier, on doit l'etaler sur plusieurs pas de temps
                    //pour lot par manque de place ou meuble par manque de piece, on refuse
                    if (line2.equals("meuble")) {
                        System.out.println("on monte un meuble");
                        String nom = scl.next();
                        String piece = scl.next();
                        int duree = Integer.valueOf(scl.next());
                        Meuble meuble = new Meuble(nom, piece, duree);
                        while (scl.hasNext()) {
                            String type = scl.next();
                            int volume = Integer.valueOf(scl.next());
                            meuble.addcompo(new paires(volume, type));

                        }
                        int test_meuble = e1.montermeuble(meuble);
                        System.out.println(test_meuble);
                        if (test_meuble == -1) {

                            meublepasfini.add(meuble);
                        }
                        System.out.println(e1.tresorerie);
                        break;
                    }
                    if (line2.equals("lot")) {
                        System.out.println("on range un lot");
                        String nom = scl.next();
                        double poids = Double.valueOf(scl.next());
                        double prix = Double.valueOf(scl.next());
                        int volume = Integer.valueOf(scl.next());
                        e1.ajoutlot(new LotPiece(volume, nom, poids, prix));
                        break;
                    }


                }
                i++;
                scl.close();
                e1.faireInventaire();
                int imeu = 0;
                while (imeu < meublepasfini.size()) {

                    int testm = e1.montermeuble(meublepasfini.get(imeu));
                    if (testm == 1) {
                        meublepasfini.remove(imeu);

                    } else {
                        imeu++;
                    }

                }
                if (i % xpasdetemps == 0) {
                    e1.optirangementstrat1();
                }

                e1.payer();
                if (e1.compteinactif() <= inactmin) {
                    if (meublepasfini.size() != 0) {
                        int spec = i % meublepasfini.size();
                        //comme ca on recrute une specialite qui a besoin d'un ouvrier et la division euclidienne pour changer a chaque fois
                        String specrec = meublepasfini.get(spec).piece;
                        String nomrec = "Paul" + i;
                        int testrec = e1.recruterouvrier(nomrec, nomrec, specrec);
                        if (testrec == -1) {
                            e1.recruterchefbrico(nomrec, nomrec);
                        }
                    } else {
                        String nomrec = "Paul" + i;
                        // la on pourrai utiliser un tableau de specialite pour en tirer une au sort et la donner a l'ouvrier
                        int testrec = e1.recruterouvrier(nomrec, nomrec, "toilette");
                        if (testrec == -1) {
                            e1.recruterchefbrico(nomrec, nomrec);
                        }
                    }
                } else if (e1.compteinactif() >= inactmax) {
                    int testlic = e1.licencierChefstock();
                    if (testlic == -1) {
                        testlic = e1.licencierOuvrier();
                        if (testlic == -1) {
                            e1.licencierChefbrico();
                        }
                    }
                }

                e1.rendreactif();
                e1.faireInventaire();
                System.out.println(e1.tresorerie);
                //+mettre les actif en inactif sauf si il construit un meuble et il lui reste du temps pour construire ce meuble


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("line2\n\n\n\n");

        meublepasfini = new ArrayList<Meuble>();
        Entrepot e3 = new Entrepot(100, 100, 5000);
        e3.recruterchefbrico("paul", "jacques");
        e3.recruterchefstock("paulo", "jacquot");
        e3.recruterchefstock("paula", "jacquass");
        e3.recruterouvrier("paulak", "jacquassd", "salleamanger");
        e3.recruterouvrier("paulim", "jacquier", "salle");
        int m = 10;
        int n = 10;
        float problot = (float) 0.5;
//if problot >1 redemander
        float probmeuble = (float) 0.3;
        //if problot+probmeuble>1 redemander
        float probrien = (float) 1 - problot - probmeuble;
        //a demander a l'utilisateur aussi
        int tempsmax = 10;

        //ca on changera pas, ce sont toutes les piece données par le prof on pourra donc utiliser nomspe[] dans les strats
        String[] nomspe = {"salon", "salledebain", "cuisine", "chambre", "toilette", "salleamanger"};

        String nompiece[] = {"porte", "charniere", "tiroir", "poignee", "cheville", "vis", "planche", "tasseau", "equerre", "boulon", "clou"};
        double prixpiece[] = {20, 4, 13, 4, 2, 6, 10, 9, 4, 8, 5};
        String nommeuble[] = {"commode", "lit", "etagere", "placard", "bureau", "table", "meubletv"};
        int nb_de_pas = 200;
        for (int nbpas = 0; nbpas < nb_de_pas; nbpas++) {
            double prob = Math.random();
            if (prob < problot) {
                int prob2 = (int) (Math.random() * nompiece.length);
                int prob3 = 1 + (int) (Math.random() * (e3.n - 1));
                e3.ajoutlot(new LotPiece(prob3, nompiece[prob2], 1, prixpiece[prob2]));
            } else if (prob < problot + probmeuble) {
                int prob2 = (int) (Math.random() * nommeuble.length);
                int tempsmeuble = 1 + (int) (Math.random() * (tempsmax));
                int prob3 = (int) (Math.random() * nomspe.length);
                Meuble meubleaj = new Meuble(nommeuble[prob2], nomspe[prob3], tempsmeuble);
                int test = e3.montermeuble(meubleaj);
                if (test == -1) {
                    meublepasfini.add(meubleaj);
                }
                for (int nblot = 0; nblot < 3; nblot++) {
                    int prob4 = (int) (Math.random() * nompiece.length);
                    int prob5 = 1 + (int) (Math.random() * (10));
                    meubleaj.addcompo(new paires(prob5, nompiece[prob4]));
                }
            } else {
                //rien
            }
            int imeu = 0;
            while (imeu < meublepasfini.size()) {

                int testm = e3.montermeuble(meublepasfini.get(imeu));
                if (testm == 1) {
                    meublepasfini.remove(imeu);

                } else {
                    imeu++;
                }

            }
            e3.payer();
            e3.rendreactif();
            e3.faireInventaire();
            System.out.println(e3.tresorerie);
            System.out.println(meublepasfini.size());
        }
try{
        System.out.println("taille tresorerie?");
        Scanner sc3 = new Scanner(System.in);
        double treso3 = sc3.nextDouble();
        System.out.println("nombre de rangee?");
        int m3 = sc3.nextInt();
        System.out.println("taille rangeee?");
        int n3 = sc3.nextInt();
        Entrepot ec = new Entrepot(m3, n3, treso3);
        ec.recruterchefbrico("pauli", "jacquie");
        ec.recruterchefbrico("pauly", "jacquesi");
        ec.recruterchefstock("paulou", "jacquotu");
        ec.recruterchefstock("paulai", "jacquassj");
        ec.recruterouvrier("paulie", "jacquiez", "cuisine");
        ec.recruterouvrier("pauler", "jacquese", "salledebain");
        ec.recruterouvrier("pauloj", "jacquott", "toilette");
    meublepasfini = new ArrayList<Meuble>();
    int pas_de_temps=0;
        simu:
        while (true) {
            System.out.println("que voulez vous faire ensuite?\npour recevoir une commande de meuble: tapez meuble\npour recevoir un lot: tapez lot\npour ne rien faire: tapez rien\npour quitter: tapez quitter");
            String testst = sc3.next();
            switch (testst) {
                case "meuble":
                    System.out.println("nom du meuble?");
                    String nomM = sc3.next();
                    System.out.println("piece du meuble?");
                    String piece = sc3.next();
                    System.out.println("durée de construction du meuble?");
                    int duree = sc3.nextInt();
                    Meuble meuble = new Meuble(nomM, piece, duree);
                    System.out.println("nombre de type de piece du meuble?");
                    int nbdepiece=sc3.nextInt();
                    for(int nbpi=0;nbpi<nbdepiece;nbpi++) {
                        System.out.println("type de la piece n°"+(nbpi+1)+" ?");
                        String type = sc3.next();
                        System.out.println("volume de la piece n°"+(nbpi+1)+" ?");
                        int volume = sc3.nextInt();
                        meuble.addcompo(new paires(volume, type));

                    }
                    int test_meuble = ec.montermeuble(meuble);
                    System.out.println(test_meuble);
                    if (test_meuble == -1) {

                        meublepasfini.add(meuble);
                    }
                    System.out.println(ec.tresorerie);
                    pas_de_temps++;
                    break;
                case "lot":
                    System.out.println("nom du lot?");
                    String nom = sc3.next();
                    System.out.println("poids du lot?");
                    double poids = sc3.nextDouble();

                    System.out.println("prix du lot?");
                    double prix =sc3.nextDouble();
                    System.out.println("volume du lot?");
                    int volume = sc3.nextInt();
                    ec.ajoutlot(new LotPiece(volume, nom, poids, prix));
                    pas_de_temps++;
                    break;
                case "rien":
                    System.out.println("rien");
                    pas_de_temps++;
                    break;
                case "quitter":
                    break simu;
                default:
                    System.out.println("cette option n'existe pas");
                    break;
            }
            int imeu = 0;
            while (imeu < meublepasfini.size()) {

                int testm = ec.montermeuble(meublepasfini.get(imeu));
                if (testm == 1) {
                    meublepasfini.remove(imeu);

                } else {
                    imeu++;
                }

            }
            ec.payer();
            ec.rendreactif();
            ec.faireInventaire();
            System.out.println(ec.tresorerie);
            System.out.println(meublepasfini.size());
        }} catch (Exception e) {
    e.printStackTrace();
}
//STRAT 0 a mettre a la fin d'un pas de temps
        //       int imeu = 0;
        //     while (imeu < meublepasfini.size()) {
//
        //          int testm = e1.montermeuble(meublepasfini.get(imeu));
        //        if (testm == 1) {
        //          meublepasfini.remove(imeu);

        //    } else {
        //      imeu++;
        //}

        //       }
       // ec.payer();
      //  ec.rendreactif();
    //    ec.faireInventaire();
  //      System.out.println(ec.tresorerie);
//        System.out.println(meublepasfini.size());

//STRAT 1 a mettre a la fin d'un pas de temps
 //       int imeu = 0;
   //     while (imeu < meublepasfini.size()) {
//
  //          int testm = e1.montermeuble(meublepasfini.get(imeu));
    //        if (testm == 1) {
      //          meublepasfini.remove(imeu);

        //    } else {
          //      imeu++;
            //}

 //       }
   //     if (i % xpasdetemps == 0) {//ici on fais la division euclidienne du pas te temps ou l'on se trouve symbolise par i par xpasdetemps et on garde le reste, donc si xpasdetemps =10 on fera la methode tout les 10 pas de temps
     //       e1.optirangementstrat1();
      //  }

        //e1.payer();
  //      if (e1.compteinactif() <= inactmin) {
    //        if (meublepasfini.size() != 0) {
      //          int spec = i % meublepasfini.size();
                //comme ca on recrute une specialite qui a besoin d'un ouvrier et la division euclidienne pour changer a chaque fois
        //        String specrec = meublepasfini.get(spec).piece;
          //      String nomrec = "Paul" + i;
            //    int testrec = e1.recruterouvrier(nomrec, nomrec, specrec);
              //  if (testrec == -1) {
                //    e1.recruterchefbrico(nomrec, nomrec);
     //           }
   //         } else {
 //               String nomrec = "Paul" + i;
                // la on pourrai utiliser un tableau de specialite pour en tirer une au sort et la donner a l'ouvrier
              //  int testrec = e1.recruterouvrier(nomrec, nomrec, "toilette");
            //    if (testrec == -1) {
          //          e1.recruterchefbrico(nomrec, nomrec);
        //        }
      //      }
    //    } else if (e1.compteinactif() >= inactmax) {
  //          int testlic = e1.licencierChefstock();
//            if (testlic == -1) {
            //    testlic = e1.licencierOuvrier();
          //      if (testlic == -1) {
        //            e1.licencierChefbrico();
      //          }
    //        }
  //      }
//
     //   e1.rendreactif();
   //     e1.faireInventaire();
 //       System.out.println(e1.tresorerie);

//STRAT 2 a mettre a la fin d'un pas de temps
//        ec.payer();
//        if(e.compteainctif()==0){
  //          int recru=e.recruterouvrier("John","Doe",nomspe[(int)Math.random()*nomspe.length]);
  //          if(recru==-1){
    //            double pileouface=Math.random();
      //          if(pileouface<0.5){
        //            e.recruterchefbrico;
        //        }
          //      else{
            //        e.recruterchefstock;
              //  }
      //      }
        //}
     //   else{
       //     stratrangement2();
        //}
  //      ec.rendreactif();
    //    ec.faireInventaire();
      //  System.out.println(ec.tresorerie);
        //System.out.println(meublepasfini.size());
    }
}
//strat 0 on fais rien
//strat 1 on vire a partir un certain nombre d'ouvrier inactif et on recrute sous un certain nombre d'ouvier inactif,et on resserre les lignes de l'entrepot tout le x pas de temsp
//strat 2 on recrute des que tout les employés sont actifs on recrute jamais, rangement on deplace les lots dans  les premieres rangees tout le temps

//pour l'instant j'ai lié strat de rangement et strat de ressources humaines mais je pense que ce serait une tres bonne idée de laisser l'utilisateur choisir
// par exemple il pouurait faire la strat de recrutement de strat 1 et de rangement de strat 2 ca donnerait un grnad nombre de different strategie pour peu de strategie,
//si on fait 3 strat de recru, 3 strat de rangment on aurait en realiter 9 strat 16 meme si rien faire est compter comme une strat et ca sans compter les strat de retirement de lot
//d'ailleurs pour retirer les lots je pense qu'une seul ou deux est envisageable, une avec une file ou l'on retirerait le premier arrivé au bout d'un certain temps, l'autre si un lot est en trop grand nombre