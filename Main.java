package projet;
import projet.LotPiece.Piece;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main{
    public static void main(String[] args) {
     	System.out.println("  ____  _ _ _                       \r\n"
    			+ " |  _ \\(_) | |                      \r\n"
    			+ " | |_) |_| | | ___  _ __ ___   ___  \r\n"
    			+ " |  _ <| | | |/ _ \\| '_ ` _ \\ / _ \\ \r\n"
    			+ " | |_) | | | | (_) | | | | | | (_) |\r\n"
    			+ " |____/|_|_|_|\\___/|_| |_| |_|\\___/ \r\n"
    			+ "                                    \r\n"
    			+ "                                    ");

        Entrepot e2= new Entrepot(5,5,10000);
        //Rangee a= new Rangee(7);
       LotPiece lp = new LotPiece(4,"plache",4,20);
       //lp.addPiece("Planche", 3.5, 19.99);
        //lp.addPiece("Vis", 0.5, 1.99);
        LotPiece lp2 = new LotPiece(5,"vis",3,3);
        e2.recruterchefstock("paula","jacquass");
        e2.chef_equipe.get(0).ajouterlot(lp,e2);
        //lp2.addPiece("Clou", 0.25, 0.99);
//    	System.out.println(lp.toString());
       System.out.println(e2.ligne[0].place[3]) ;
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

            // e1.recruterchefbrico("paul","jacques");
             //e1.recruterchefstock("paulo","jacquot");
             //e1.recruterchefstock("paula","jacquass");
             //e1.recruterchefbrico("pauli","jacquie");
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
String che="azertyuiop";
System.out.println(che.substring(0,4));
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
        ArrayList<String> choseafaire;
        //parfois on pas d'ouvrier inactif on pourra donc pas le faire maitenant et faut trouver un moyen de remettre a plus tard

        //juste une base qu'on devra utiliser pour chaque differente stratégie pour trouver la mieux
        try{
            Scanner sc= new Scanner(new FileReader("C:\\test.txt"));
           // int a=sc.rea;
           // System.out.println(a);
           double tresor=Double.valueOf(sc.next());
            int m=Integer.valueOf(sc.next());
            int n=Integer.valueOf(sc.next());
            sc.nextLine();
            Entrepot e1=new Entrepot(m,n,tresor);
            String line=null;
            int a=2;
            String line2;
           int i=1;
            while(sc.hasNext()) {
                if(a==-1){break;}
                line= sc.nextLine();
                System.out.println(line);

                Scanner scl= new Scanner(line);
                while(scl.hasNext()){
                line2=scl.next();
                //line2=line2.substring(1,line2.indexOf('>'));
                a=Integer.valueOf(line2);

                if(a!=i){a=-1;System.out.println("probleme id pas");break;}
                    line2=scl.next();
                if(line2.equals("rien")){System.out.println("on fait rien");break;}
                    if(line2.equals("meuble")){System.out.println("on monte un meuble");break;}
                    if(line2.equals("lot")){System.out.println("on range un lot");break;}


                }
                i++;
                scl.close();
                e1.payer();
                //+mettre les actif en inactif sauf si il construit un meuble et il lui reste du temps pour construire ce meuble


            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch( NoSuchElementException e){
            e.printStackTrace();
        }
        catch( Exception e){
            e.printStackTrace();
        }
        System.out.println("line");
    }}
