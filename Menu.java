package projet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java.util.ArrayList;
//import java.io.*;

public class Menu {
    static Entrepot entrepot;
    static int taille_eq, nb_chefs, nb_chefb, nb_ouv;
    private static Scanner scan = new Scanner(System.in);
    private static Scanner sc = new Scanner(System.in);

    public static void creerEntrepot(){
        boolean quitter = false;
        String m, n, tres;
        do {
            System.out.println("Veuillez entrer la valeur m de rangée de l'entrepot : ");
            m = sc.nextLine();
            System.out.println("Veuillez entrer la longeur n de l'entrepot : ");
            n = sc.nextLine();
            System.out.println("Veuillez entrer le montant de la trésorerie : ");
            tres = sc.nextLine();
            try {
                int rangee = Integer.parseInt(m);
                int ligne = Integer.parseInt(n);
                double tresorerie = Double.parseDouble(tres);
                entrepot = new Entrepot(rangee,ligne,tresorerie);
                quitter = true;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }while(quitter != true );
        creerEquipe();
    }

    public static void creerEquipe() {
        boolean quitter = false;
        String taille_equipe;
        String nb_o;
        String nb_cs;
        String nb_cb;
        if(entrepot != null) {
            do {
                System.out.println("Veuillez entrer la taille de l'équipe :");
                taille_equipe = sc.nextLine();
                try {
                    int taille = Integer.parseInt(taille_equipe);
                    boolean quit = false;
                    do {
                        System.out.println("Veuillez entrer le nombre de Chef Stock : ");
                        nb_cs = sc.nextLine();
                        System.out.println("Veuillez entrer le nombre de Chef Brico : ");
                        nb_cb = sc.nextLine();
                        System.out.println("Veuillez entrer le nombre d'Ouvrier");
                        nb_o = sc.nextLine();
                        try {
                            int nb_chefstock = Integer.parseInt(nb_cs);
                            int nb_chefbrico = Integer.parseInt(nb_cb);
                            int nb_ouvrier = Integer.parseInt(nb_o);
                            int total = nb_chefstock + nb_chefbrico + nb_ouvrier;
                            if(total != taille || nb_cs == "" || nb_cb == "" || nb_o == "" ) {
                                System.out.println("Désolé mais il y a un problème avec la saisie des informations.. Veuillez réessayer :");
                                quit = false;
                            }
                            else if((nb_chefstock+nb_chefbrico)*4<nb_ouvrier) {
                                System.out.println("Désolé mais il y a un problème avec la saisie des informations.. Veuillez réessayer :");
                                quit = false;
                            }
                            else {
                                taille_eq = total;
                                nb_chefs = nb_chefstock;
                                nb_chefb = nb_chefbrico;
                                nb_ouv = nb_ouvrier;
                                quit = true;
                            }
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }while(quit !=true);

                    quitter = true;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }while(quitter != true);
        }
        ajouterEquipe(nb_chefs, nb_chefb, nb_ouv);
        choisirSimu();
    }

    public static void ajouterEquipe(int nb_chefs, int nb_chefb, int nb_ouv) {
        if(nb_chefs != 0) {
            for(int i = 0; i<nb_chefs; i++) {
                entrepot.recruterchefstock("Chef", "Stock"+i);
            }
        }
        if(nb_chefb != 0) {
            for(int i = 0; i<nb_chefb; i++) {
                entrepot.recruterchefbrico("Chef", "Brico"+i);
            }
        }
        if(nb_ouv != 0) {
            for(int i = 0; i<nb_ouv; i++) {
                Random rand = new Random();
                String specialite = Entrepot.nomspe[rand.nextInt(6)];
                entrepot.recruterouvrier("Mac", "Gyver"+i, specialite);
            }
        }
    }

    public static void Simul1() {
        boolean quitter = false;
        String nomFichier;
        System.out.println("Veuillez entrer le nom du fichier :");
        do {
            try {
                nomFichier = sc.nextLine();
                if(!nomFichier.isEmpty()) {
                    fileSimul(nomFichier);
                    quitter = true;
                    break;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }while(!quitter);
    }

    public static void Simul2() {
        try{
            System.out.println("quel strategie voulez vous ? 0,1 ou 2");
            Scanner sc=new Scanner(System.in);
            int strat=sc.nextInt();
            while(strat!=0 &&strat!=1 && strat !=2){
                System.out.println("cette strategie n'existe pas");
                System.out.println("quel strategie voulez vous ? 0,1 ou 2");
                strat=sc.nextInt();
            }
            int xpasdetemps=0;
            int inactmin=0;
            int inactmax=0;
            if(strat==1){
                System.out.println("tout les combien de pas de temps souhaitez vous resserez les lots");
                xpasdetemps=sc.nextInt();
                System.out.println("combien voulez vous avoir en ouvrier inactif maximal");
                inactmax=sc.nextInt();
                System.out.println("sous quel nombre d'ouvrier inactif recruterez vous");
                inactmin=sc.nextInt();
            }
            System.out.println("quel strategie voulez vous pour l'enlevement de lot ? 0,1 ou 2");
            int stratlot=sc.nextInt();
            while(stratlot!=0 &&stratlot!=1 && stratlot!=2){
                System.out.println("cette strategie n'existe pas");
                System.out.println("quel strategie voulez vous ? 0,1 ou 2");
                strat=sc.nextInt();
            }
            int nbconservationlot=0;
            if(stratlot==1){
                System.out.println("a partir de combien de reception de lot, voulez vous supprimez un lot");
                nbconservationlot=sc.nextInt();
            }
            int pourcent=0;
            if(stratlot==2){
                System.out.println("a partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece");
                pourcent=sc.nextInt();
            }
            Scanner sc3 = new Scanner(System.in);
            int pas_de_temps=0;
            simu:
            while (true) {
                System.out.println("que voulez vous faire ensuite?\npour recevoir une commande de meuble: tapez meuble\npour recevoir un lot: tapez lot\npour ne rien faire: tapez rien\npour quitter: tapez quitter\n pour afficher les infos de l'entrepot: taper afficher ");
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
                            meuble.addcompo(new Paire(volume, type));

                        }
                        int test_meuble = entrepot.montermeuble(meuble);
                        System.out.println(test_meuble);
                        if (test_meuble == -1) {

                            entrepot.meublepasfini.add(meuble);
                        }
                        System.out.println(entrepot.tresorerie);
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
                        entrepot.ajoutlot(new LotPiece(volume, nom, poids, prix));
                        pas_de_temps++;
                        break;
                    case "rien":
                        System.out.println("rien");
                        pas_de_temps++;
                        break;
                    case "quitter":
                        break simu;
                    case "afficher":
                        afficherInfos();
                    default:
                        System.out.println("cette option n'existe pas");
                        break;
                }
                int imeu = 0;
                while (imeu < entrepot.meublepasfini.size()) {

                    int testm = entrepot.montermeuble(entrepot.meublepasfini.get(imeu));
                    if (testm == 1) {
                        entrepot.meublepasfini.remove(imeu);

                    } else {
                        imeu++;
                    }

                }
                entrepot.payer();
                if(strat==1){
                    entrepot.strat1(pas_de_temps,xpasdetemps,inactmin,inactmax);
                }
                if(strat==2){
                    entrepot.strat2();
                }
                if(stratlot==1){
                    entrepot.stratretirerlot1(pas_de_temps,nbconservationlot);
                }
                if(stratlot==2){
                    entrepot.stratretirerlot2(pourcent);
                }
                entrepot.rendreactif();

                System.out.println(entrepot.tresorerie);
                System.out.println(entrepot.meublepasfini.size());
            }} catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void Simul3() {
        System.out.println("quel strategie voulez vous ? 0,1 ou 2");
        Scanner sc=new Scanner(System.in);
        int strat=sc.nextInt();
        while(strat!=0 && strat!=1 && strat !=2){
            System.out.println("cette strategie n'existe pas");
            System.out.println("quel strategie voulez vous ? 0,1 ou 2");
            strat=sc.nextInt();
        }
        int xpasdetemps=0;
        int inactmin=0;
        int inactmax=0;
        if(strat==1){
            System.out.println("tout les combien de pas de temps souhaitez vous resserez les lots");
            xpasdetemps=sc.nextInt();
            System.out.println("combien voulez vous avoir en ouvrier inactif maximal");
            inactmax=sc.nextInt();
            System.out.println("sous quel nombre d'ouvrier inactif recruterez vous");
            inactmin=sc.nextInt();
        }
        System.out.println("quel strategie voulez vous pour l'enlevement de lot ? 0,1 ou 2");
        int stratlot=sc.nextInt();
        while(stratlot!=0 &&stratlot!=1 && stratlot!=2){
            System.out.println("cette strategie n'existe pas");
            System.out.println("quel strategie voulez vous ? 0,1 ou 2");
            strat=sc.nextInt();
        }
        int nbconservationlot=0;
        if(stratlot==1){
            System.out.println("a partir de combien de reception de lot, voulez vous supprimez un lot");
            nbconservationlot=sc.nextInt();
        }
        int pourcent=0;
        if(stratlot==2){
            System.out.println("a partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece");
            pourcent=sc.nextInt();
        }
        Scanner sc3 = new Scanner(System.in);
        int proba;
        System.out.println("probabilité de recevoir un nouveau lot en %");
        int problot = sc3.nextInt();
        System.out.println("probabilité de recevoir une commande de meuble en %");
        int probmeuble = sc3.nextInt();
        int probrien =  100 - problot - probmeuble;
        proba=problot+probmeuble+probrien;
        while(proba!=100 || problot>100 || problot<0 ||probmeuble<0 ||probmeuble>100 ||probrien<0 ||probrien>1001) {
            System.out.println("les valeurs données sont impossible");
            System.out.println("probabilité de recevoir un nouveau lot en %");
            problot = sc3.nextInt();
            System.out.println("probabilité de recevoir une commande de meuble en %");
            probmeuble = sc3.nextInt();
            probrien = 100 - problot - probmeuble;
            proba=problot+probmeuble+probrien;

        }
        System.out.println("combien de pas de temps");
        int nb_de_pas =sc3.nextInt();
        System.out.println("combien de pas de temps maximum pour la construction d'un meuble");
        int tempsmax=sc3.nextInt();
        for (int nbpas = 0; nbpas < nb_de_pas; nbpas++) {
            double prob = Math.random()*100;
            if (prob < problot) {
                System.out.println("lot");
                int prob2 = (int) (Math.random() * entrepot.nompiece.length);
                int prob3 = 1 + (int) (Math.random() * (entrepot.n - 1));
                entrepot.ajoutlot(new LotPiece(prob3, entrepot.nompiece[prob2], 1, entrepot.prixpiece[prob2]));
            } else if (prob < problot + probmeuble) {
                System.out.println("meuble");
                int prob2 = (int) (Math.random() * entrepot.nommeuble.length);
                int tempsmeuble = 1 + (int) (Math.random() * (tempsmax));
                int prob3 = (int) (Math.random() * entrepot.nomspe.length);
                Meuble meubleaj = new Meuble(entrepot.nommeuble[prob2], entrepot.nomspe[prob3], tempsmeuble);
                for (int nblot = 0; nblot < 3; nblot++) {
                    int prob4 = (int) (Math.random() * entrepot.nompiece.length);
                    int prob5 = 1 + (int) (Math.random() * (10));
                    meubleaj.addcompo(new Paire(prob5, entrepot.nompiece[prob4]));
                }
                int test = entrepot.montermeuble(meubleaj);
                if (test == -1) {
                    entrepot.meublepasfini.add(meubleaj);
                }
            } else {
                System.out.println("rien");
                //rien
            }
            int imeu = 0;
            while (imeu < entrepot.meublepasfini.size()) {

                int testm = entrepot.montermeuble(entrepot.meublepasfini.get(imeu));
                System.out.println("test"+testm);
                if (testm == 1) {
                    entrepot.meublepasfini.remove(imeu);

                } else {
                    imeu++;
                }

            }
            entrepot.payer();
            if(strat==1){
                entrepot.strat1(nbpas,xpasdetemps,inactmin,inactmax);
            }
            if(strat==2){
                entrepot.strat2();
            }
            if(stratlot==1){
                entrepot.stratretirerlot1(nbpas,nbconservationlot);
            }
            if(stratlot==2){
                entrepot.stratretirerlot2(pourcent);
            }
            entrepot.rendreactif();
            entrepot.faireInventaire();
            System.out.println(entrepot.tresorerie);
            System.out.println(entrepot.meublepasfini.size());
        }
    }



    public static void printAction() {
        System.out.println("----------------------------------------\n Veuillez choisir une action à effectuer : \n----------------------------------------");
        System.out.println("Entrer 0 pour revenir au menu précédent. ");
        System.out.println("Entrer 1 pour afficher les informations actuel (Dimension de l'entrepot, Trésorerie, Taille équipe & composition : ");
        System.out.println("Entrer 2 pour ajouter un nouveau lot : ");
        System.out.println("Entrer 3 pour recruter une nouvelle personne : ");
        System.out.println("Entrer 4 pour monter un nouveau meuble : ");
    }

    public static void ajouterNouvLot(){

    }

    public static void recruterNouvPers() {

    }
    public static void monterNouvMeuble() {
        boolean quitter = false;
        String nom_meuble;
        String piece_meuble;
        String duree;
        String nombre_piece;
        if(entrepot!=null) {
            do {
                System.out.println("Veuillez entrer le nom du meuble : ");
                nom_meuble = sc.nextLine();
                System.out.println("Veuillez entrer la pièce correspondante : ");
                piece_meuble = sc.nextLine();
                System.out.println("Veuillez entrer le nombre de pièce nécessaire pour le montage : ");
                nombre_piece=sc.nextLine();
                System.out.println("duree nécessaire pour le montage : ");
                duree= sc.nextLine();
                quitter = true;
                try {
                    if(nom_meuble == null || piece_meuble == null || duree == null ) {
                        System.out.println("Désolé mais il y a un problème avec la saisie des informations.. Veuillez réessayer :");
                        quitter = false;
                    }
                    else {
                        String nom = nom_meuble;
                        String piece = piece_meuble;
                        int dur = Integer.parseInt(duree);
                        Meuble meuble = new Meuble(nom,piece,dur);
                        int nbdepiece=Integer.parseInt(nombre_piece);
                        for(int nbpi=0;nbpi<nbdepiece;nbpi++) {
                            System.out.println("type de la piece n°"+(nbpi+1)+" ?");
                            String type = sc.next();
                            System.out.println("volume de la piece n°"+(nbpi+1)+" ?");
                            int volume = sc.nextInt();
                            meuble.addcompo(new Paire(volume, type));

                        }
                        int val = entrepot.montermeuble(meuble);
                        if(val == -1) {
                            entrepot.meublepasfini.add(meuble);
                        }
                        quitter = true;
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }while(!quitter);
        }
        entrepot.payer();
        entrepot.rendreactif();



    }

    public static void action() {
        boolean quitter = false;
        do {
            printAction();
            int choix = scan.nextInt();
            switch(choix) {
                case(0):
                    quitter = true;
                    break;
                case(1):
                    afficherInfos();
                    break;
                case(2):
                    ajouterNouvLot();
                    break;
                case(3):
                    recruterNouvPers();
                    break;
                case(4):
                    monterNouvMeuble();
                    break;
                default:
                    System.out.println("Le choix que vous avez fait ne correspond à aucun choix");
            }
        }while(!quitter);
    }



    public static void fileSimul(String nomFichier) throws IOException {
        System.out.println("quel strategie voulez vous ? 0,1 ou 2");
        Scanner sc=new Scanner(System.in);
        int strat=sc.nextInt();
        while(strat!=0 &&strat!=1 && strat !=2){
            System.out.println("cette strategie n'existe pas");
            System.out.println("quel strategie voulez vous ? 0,1 ou 2");
            strat=sc.nextInt();
        }

        int xpasdetemps=0;
        int inactmin=0;
        int inactmax=0;
        if(strat==1){
            System.out.println("tout les combien de pas de temps souhaitez vous resserez les lots");
            xpasdetemps=sc.nextInt();
            System.out.println("combien voulez vous avoir en ouvrier inactif maximal");
            inactmax=sc.nextInt();
            System.out.println("sous quel nombre d'ouvrier inactif recruterez vous");
            inactmin=sc.nextInt();
        }
        System.out.println("quel strategie voulez vous pour l'enlevement de lot ? 0,1 ou 2");
        int stratlot=sc.nextInt();
        while(stratlot!=0 &&stratlot!=1 && stratlot!=2){
            System.out.println("cette strategie n'existe pas");
            System.out.println("quel strategie voulez vous ? 0,1 ou 2");
            strat=sc.nextInt();
        }
        int nbconservationlot=0;
        if(stratlot==1){
            System.out.println("a partir de combien de reception de lot, voulez vous supprimez un lot");
            nbconservationlot=sc.nextInt();
        }
        int pourcent=0;
        if(stratlot==2){
            System.out.println("a partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece");
            pourcent=sc.nextInt();
        }
        String chemin = "C:\\" + nomFichier;
        String line;
        ArrayList<String[]> informations = new ArrayList<String[]>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(chemin));
            line = bf.readLine();
            while(line  !=null) {
                String[] tab = line.split(" ");
                informations.add(tab);
                line = bf.readLine();
            }
            bf.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Erreur lors de l'ouverture du ficher \n" + e);
        }
        for(int i = 0; i<informations.size(); i++) {
            if (informations.get(i)[1].equals("lot")) {
                System.out.println("Ajout d'un nouveau lot dans l'inventaire ... ");
                int volume = Integer.parseInt(informations.get(i)[5]);
                double poids = Double.parseDouble(informations.get(i)[3]);
                double prix = Double.parseDouble(informations.get(i)[4]);
                LotPiece lot = new LotPiece(volume, informations.get(i)[2], poids, prix);
                System.out.println(" [ Volume : " + lot.volume + " | Nom : " + lot.piece.nom + " | Poids : " + lot.piece.poids + " | Prix : " + lot.prix + " ] \n");
                System.out.println(entrepot.ajoutlot(lot));
            } else if (informations.get(i)[1].equals("rien")) {
                System.out.println("La ligne ne contient rien, il n'y a donc rien à faire");
            } else if (informations.get(i)[1].equals("meuble")) {
                System.out.println("Meuble à monter ...");
                String nom = informations.get(i)[2];
                String piece = informations.get(i)[3];
                int duree = Integer.parseInt(informations.get(i)[4]);
                Meuble meuble = new Meuble(nom, piece, duree);
                System.out.println(" [ Nom : " + meuble.nom + " | Piece : " + meuble.piece + " | Duree : " + meuble.duree + " | Prix : " + meuble.prix + " ] \n");
                for(int addp=5;addp<informations.get(i).length;addp=addp+2) {
                    String type = informations.get(i)[addp];
                    int volume = Integer.parseInt(informations.get(i)[addp+1]);
                    meuble.addcompo(new Paire(volume, type));
                }
                int test_meuble = entrepot.montermeuble(meuble);
                if (test_meuble == 1) {
                    System.out.println("Meuble construit !");
                } else {
                    System.out.println("Problème lors de la construction du meuble");
                }
                System.out.println(test_meuble);
                if (test_meuble == -1) {
                    entrepot.meublepasfini.add(meuble);
                }
            } else {
                System.out.println("Désolé, l'information de la ligne n° " + i + " n'a pas été exécuté.");
            }

            entrepot.payer();
            if(strat==1){
                entrepot.strat1(i,xpasdetemps,inactmin,inactmax);
            }
            if(strat==2){
                entrepot.strat2();
            }
            if(stratlot==1){
                entrepot.stratretirerlot1(i,nbconservationlot);
            }
            if(stratlot==2){
                entrepot.stratretirerlot2(pourcent);
            }
            entrepot.rendreactif();
            System.out.println(entrepot.meublepasfini.size());
           // action();
        }action();
    }


    public static void choisirSimu() {
        boolean quitter = false;
        do {
            printChoix();
            int strat = scan.nextInt();
            switch(strat) {
                case(0):
                    Personne.i = 0;
                    entrepot = null;
                    quitter = true;
                    break;
                case(1):
                    afficherInfos();
                    break;
                case(2):
                    Simul1();
                    break;
                case(3):
                    Simul2();
                    break;
                case(4):
                    Simul3();
                    break;
                default:
                    System.out.println("Le choix que vous avez fait ne correspond à aucun choix");
            }
        }while(!quitter);
    }

    public static void afficherInfos() {
        System.out.println(" Informations de l'entrepot : \n");
        if(entrepot != null) {System.out.println(" Informations : \n [ Rangee : " + entrepot.m + " | Ligne "+ entrepot.n + " | Tresorerie "+ entrepot.tresorerie + " ] \n");}
        else { System.out.println("Désolé, il n'existe aucun entrepot."); }

        if(entrepot !=null) {
            System.out.println("Inventaire : \n");
            System.out.println(entrepot.faireInventaire());
            entrepot.meubleAFinir();
        }
        else {
            System.out.println("Désolé, il n'y a aucun inventaire.");
        }

        System.out.println("Taille de l'équipe & composition : \n ");
        if(entrepot !=null) { System.out.println("Taille équipe : "+ taille_eq +"\n"+ entrepot.afficherEquipe() + " \n");}
        else { System.out.println("Désolé, il n'existe aucune équipe."); }

    }

    public static void printChoix() {
        System.out.println("-------------------------------------------------------------------------\n Veuillez choisir votre stratégie : \n-------------------------------------------------------------------------");
        System.out.println("Entrer 0 pour recommencer avec un nouvel entrepot : ");
        System.out.println("Entrer 1 pour afficher les informations actuel (Dimension de l'entrepot, Trésorerie, Taille équipe & composition : ");
        System.out.println("Entrer 2 pour lancer la simulation n°1, fichier ");
        System.out.println("Entrer 3 pour lancer la simulation n°2, console ");
        System.out.println("Entrer 4 pour lancer la simulation n°3, aleatoire ");
    }

    public static void printMenu() {
        System.out.println("  ____  _ _ _                       \r\n"
                + " |  _ \\(_) | |                      \r\n"
                + " | |_) |_| | | ___  _ __ ___   ___  \r\n"
                + " |  _ <| | | |/ _ \\| '_ ` _ \\ / _ \\ \r\n"
                + " | |_) | | | | (_) | | | | | | (_) |\r\n"
                + " |____/|_|_|_|\\___/|_| |_| |_|\\___/ \r\n"
                + "                                    \r\n"
                + "                                    \n");
        System.out.println("Auteur : Abdesamad & Kylan \n");

        System.out.println("-------------------------------------------------------------------------\n Bienvenue sur l'interface de gestion : Plusieurs choix s'offrent à vous : \n-------------------------------------------------------------------------");
        System.out.println("Entrer 0 pour quitter l'interface.");
        System.out.println("Entrer 1 pour créer l'entrepot : ");
    }


    public static void lancerMenu() {
        boolean quitter = false;
        do {
            printMenu();
            int choix = scan.nextInt();
            scan.nextLine();
            switch(choix) {
                case(0):
                    quitter = true;
                    break;
                case(1):
                    creerEntrepot();
                    break;
                default:
                    System.out.println("Désolé, mais la valeur entrer est incorrect.");
            }
        }while(!quitter);
    }

}
