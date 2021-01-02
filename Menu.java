package projet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * Un Menu est une interface qui va permettre à l'utilisateur d'interragir avec le programme. Ce dernier va pouvoir effecuter différentes actions.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Menu {
    // entrepot : correspond à l'entrepôt dans lequel on va effectuer différentes actions.
    private static Entrepot entrepot;
    // taille_eq : correspond à la taille de l'équipe. ; nb_chefs : correspond au nombre de Chefstock présent dans l'entrepot. ; nb_chefb : correspond au nombre de Chefbrico présent dans l'entrepôt. ; nb_ouv : correspond au nombre d'ouvrier présent dans l'entrepôt.
    private static int taille_eq, nb_chefs, nb_chefb, nb_ouv;
    // scan : Scanner qui va permettre la récupération de la saisie de l'utilisateur.
    private static Scanner scan = new Scanner(System.in);
    // sc : Scanner qui va permettre la récupération de la saisie de l'utilisateur.
    private static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    /**
     * Fonction qui permet la création d'un {@link Entrepot}.
     */
    public static void creerEntrepot(){
        boolean quitter = false;
        String m, n, tres;
        do {
            System.out.println(ANSI_PURPLE+"Veuillez entrer la valeur m de rangée de l'entrepot : "+ANSI_RESET);
            m = sc.nextLine();
            System.out.println(ANSI_PURPLE+"Veuillez entrer la longeur n de l'entrepot : "+ANSI_RESET);
            n = sc.nextLine();
            System.out.println(ANSI_PURPLE+"Veuillez entrer le montant de la trésorerie : "+ANSI_RESET);
            tres = sc.nextLine();
            try {
                if(!(m.isEmpty() || Integer.parseInt(m)==0) && !(n.isEmpty() || Integer.parseInt(n)==0) && !(tres.isEmpty() || Integer.parseInt(tres)==0)) {
                    int rangee = Integer.parseInt(m);
                    int ligne = Integer.parseInt(n);
                    double tresorerie = Double.parseDouble(tres);
                    entrepot = new Entrepot(rangee,ligne,tresorerie);
                    quitter = true;
                }
                else {System.out.println(ANSI_RED+" \n Désolé un des champs n'a pas été renseignée. Veuillez réessayer. \n"+ANSI_RESET); quitter = false; }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }while(quitter != true );
        creerEquipe();
    }

    /**
     * Fonction qui permet la création d'une équipe.
     */
    public static void creerEquipe() {
        boolean quitter = false;
        String taille_equipe;
        String nb_o;
        String nb_cs;
        String nb_cb;
        if(entrepot != null) {
            do {
                System.out.println(ANSI_PURPLE+"Veuillez entrer la taille de l'équipe :"+ANSI_RESET);
                taille_equipe = sc.nextLine();
                System.out.println(ANSI_PURPLE+"Veuillez entrer le nombre de Chef Stock : "+ANSI_RESET);
                nb_cs = sc.nextLine();
                System.out.println(ANSI_PURPLE+"Veuillez entrer le nombre de Chef Brico : "+ANSI_RESET);
                nb_cb = sc.nextLine();
                System.out.println(ANSI_PURPLE+"Veuillez entrer le nombre d'Ouvrier"+ANSI_RESET);
                nb_o = sc.nextLine();
                try {
                    if(!(taille_equipe.isEmpty() || Integer.parseInt(taille_equipe)==0) && !(nb_cs.isEmpty()) && !(nb_cb.isEmpty()) && !(nb_o.isEmpty())) {
                        int taille = Integer.parseInt(taille_equipe);
                        int nb_chefstock = Integer.parseInt(nb_cs);
                        int nb_chefbrico = Integer.parseInt(nb_cb);
                        int nb_ouvrier = Integer.parseInt(nb_o);
                        int total = nb_chefstock + nb_chefbrico + nb_ouvrier;
                        taille_eq = total;
                        nb_chefs = nb_chefstock;
                        nb_chefb = nb_chefbrico;
                        int nb_chef = nb_chefs+nb_chefb;
                        nb_ouv = nb_ouvrier;
                        if(taille == total) {
                            if(nb_ouv <= 4*nb_chef) {
                                quitter = true;
                            }
                            else {
                                System.out.println(ANSI_RED+"Désolé, il n'y a pas assez de chef. Veuillez rééssayer. \n"+ANSI_RESET);
                                quitter = false;
                            }
                        }
                        else {
                            System.out.println(ANSI_RED+"Désolé, le nombre de personnes ajouter ne correspond pas à la taille de l'équipe entrée. Veuillez réessayer. \n"+ANSI_RESET);
                            quitter = false;
                        }
                    }
                    else {System.out.println(ANSI_RED+"Désolé, il y a un problème avec la saisie. Veuillez réessayer."+ANSI_RESET); quitter = false; }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }while(quitter != true);
        }
        ajouterEquipe(nb_chefs, nb_chefb, nb_ouv);
        choisirStrat();
    }

    /**
     * Fonction qui permet de ajouter une équipe dans l'{@link Entrepot}
     * @param nb_chefs correspond au nombre de {@link Chefstock} que l'on souhaite recruter.
     * @param nb_chefb correspond au nombre de {@link Chefbrico} que l'on souhaite recruter.
     * @param nb_ouv correspond au nombre d'{@link Ouvrier} que l'on souhaite recruter.
     */
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
                String specialite = Entrepot.getNomSpe(rand.nextInt(6));//nomspe[rand.nextInt(6)];
                entrepot.recruterouvrier("Mac", "Gyver"+i, specialite);
            }
        }
    }

    /**
     * Fonction qui va permettre d'executer la Simulation n°1 (Via fichier)
     */
    public static void Simul1() {
        boolean quitter = false;
        String nomFichier;
        System.out.println(ANSI_PURPLE+"Veuillez entrer le nom du fichier :"+ANSI_RESET);
        do {
            try {
                nomFichier = sc.nextLine();
                if(!nomFichier.isEmpty()) {
                    fileSimul(nomFichier);
                    quitter = true;
                    break;
                }
                else {System.out.println(ANSI_RED+"Vous n'avez pas entrer de nom. Veuillez réessayer. \n"+ANSI_RESET);quitter = false;}
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }while(!quitter);
    }

    /**
     * Fonction qui va permettre d'exectuer la Simulation n°2 (Via console)
     */
    public static void Simul2() {
        try{
            System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous choisir ? 0,1 ou 2"+ANSI_RESET);
            Scanner sc=new Scanner(System.in);
            int strat=sc.nextInt();
            while(strat!=0 &&strat!=1 && strat !=2){
                System.out.println(ANSI_RED+ "Cette strategie n'existe pas"+ANSI_RESET);
                System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
                strat=sc.nextInt();
            }
            int xpasdetemps=0;
            int inactmin=0;
            int inactmax=0;
            if(strat==1){
                System.out.println(ANSI_PURPLE+"Tout les combien de pas de temps souhaitez vous resserez les lots"+ANSI_RESET);
                xpasdetemps=sc.nextInt();
                System.out.println(ANSI_PURPLE+"combien voulez vous avoir en ouvrier inactif maximal"+ANSI_RESET);
                inactmax=sc.nextInt();
                System.out.println(ANSI_PURPLE+"sous quel nombre d'ouvrier inactif recruterez vous"+ANSI_RESET);
                inactmin=sc.nextInt();
            }
            System.out.println(ANSI_PURPLE+"quel strategie voulez vous pour l'enlevement de lot ? 0,1 ou 2"+ANSI_RESET);
            int stratlot=sc.nextInt();
            while(stratlot!=0 &&stratlot!=1 && stratlot!=2){
                System.out.println(ANSI_RED+"Cette strategie n'existe pas"+ANSI_RESET);
                System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
                strat=sc.nextInt();
            }
            int nbconservationlot=0;
            if(stratlot==1){
                System.out.println(ANSI_PURPLE+"A partir de combien de reception de lot, voulez vous supprimez un lot"+ANSI_RESET);
                nbconservationlot=sc.nextInt();
            }
            int pourcent=0;
            if(stratlot==2){
                System.out.println(ANSI_PURPLE+"A partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece"+ANSI_RESET);
                pourcent=sc.nextInt();
            }
            Scanner sc3 = new Scanner(System.in);
            int pas_de_temps=0;
            simu:
            while (true) {
                System.out.println(ANSI_PURPLE+"Que voulez vous faire ensuite?\npour recevoir une commande de meuble: tapez meuble\npour recevoir un lot: tapez lot\npour ne rien faire: tapez rien\npour quitter: tapez quitter\n pour afficher les infos de l'entrepot: taper afficher "+ANSI_RESET);
                String testst = sc3.next();
                switch (testst) {
                    case "meuble":
                        System.out.println(ANSI_PURPLE+"nom du meuble?"+ANSI_RESET);
                        String nomM = sc3.next();
                        System.out.println(ANSI_PURPLE+"piece du meuble?"+ANSI_RESET);
                        String piece = sc3.next();
                        System.out.println(ANSI_PURPLE+"durée de construction du meuble?"+ANSI_RESET);
                        int duree = sc3.nextInt();
                        Meuble meuble = new Meuble(nomM, piece, duree);
                        System.out.println(ANSI_PURPLE+"nombre de type de piece du meuble?"+ANSI_RESET);
                        int nbdepiece=sc3.nextInt();
                        for(int nbpi=0;nbpi<nbdepiece;nbpi++) {
                            System.out.println(ANSI_PURPLE+"type de la piece n°"+(nbpi+1)+" ?"+ANSI_RESET);
                            String type = sc3.next();
                            System.out.println(ANSI_PURPLE+"volume de la piece n°"+(nbpi+1)+" ?"+ANSI_RESET);
                            int volume = sc3.nextInt();
                            meuble.addcompo(new Paire(volume, type));

                        }
                        int test_meuble = entrepot.montermeuble(meuble);
                        System.out.println(test_meuble);
                        if (test_meuble == -1) {

                            entrepot.getMeuble_nonfini().add(meuble);
                        }
                        System.out.println(entrepot.getTresorerie());
                        pas_de_temps++;
                        break;
                    case "lot":
                        System.out.println(ANSI_PURPLE+"nom du lot?"+ANSI_RESET);
                        String nom = sc3.next();
                        System.out.println(ANSI_PURPLE+"poids du lot?"+ANSI_RESET);
                        double poids = sc3.nextDouble();

                        System.out.println(ANSI_PURPLE+"prix du lot?"+ANSI_RESET);
                        double prix =sc3.nextDouble();
                        System.out.println(ANSI_PURPLE+"volume du lot?"+ANSI_RESET);
                        int volume = sc3.nextInt();
                        entrepot.ajoutlot(new LotPiece(volume, nom, poids, prix));
                        pas_de_temps++;
                        break;
                    case "rien":
                        System.out.println(ANSI_PURPLE+"rien"+ANSI_RESET);
                        pas_de_temps++;
                        break;
                    case "quitter":
                        break simu;
                    case "afficher":
                        afficherInfos();
                    default:
                        System.out.println(ANSI_RED+"cette option n'existe pas"+ANSI_RESET);
                        break;
                }
                int imeu = 0;
                while (imeu < entrepot.getMeuble_nonfini().size()) {

                    int testm = entrepot.montermeuble(entrepot.getMeuble_nonfini().get(imeu));
                    if (testm == 1) {
                        entrepot.getMeuble_nonfini().remove(imeu);

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

                System.out.println(entrepot.getTresorerie());
                System.out.println(entrepot.getMeuble_nonfini().size());
            }} catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Fonction qui va permettre d'effectuer la Simulation n°3 (via console)
     */
    public static void Simul3() {
        System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
        Scanner sc=new Scanner(System.in);
        int strat=sc.nextInt();
        while(strat!=0 && strat!=1 && strat !=2){
            System.out.println(ANSI_RED+"Cette strategie n'existe pas"+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
            strat=sc.nextInt();
        }
        int xpasdetemps=0;
        int inactmin=0;
        int inactmax=0;
        if(strat==1){
            System.out.println(ANSI_PURPLE+"Tout les combien de pas de temps souhaitez vous resserez les lots"+ANSI_RESET);
            xpasdetemps=sc.nextInt();
            System.out.println(ANSI_PURPLE+"combien voulez vous avoir en ouvrier inactif maximal"+ANSI_RESET);
            inactmax=sc.nextInt();
            System.out.println(ANSI_PURPLE+"sous quel nombre d'ouvrier inactif recruterez vous"+ANSI_RESET);
            inactmin=sc.nextInt();
        }
        System.out.println(ANSI_PURPLE+"quel strategie voulez vous pour l'enlevement de lot ? 0,1 ou 2"+ANSI_RESET);
        int stratlot=sc.nextInt();
        while(stratlot!=0 &&stratlot!=1 && stratlot!=2){
            System.out.println(ANSI_RED+"cette strategie n'existe pas"+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"quel strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
            strat=sc.nextInt();
        }
        int nbconservationlot=0;
        if(stratlot==1){
            System.out.println(ANSI_PURPLE+"a partir de combien de reception de lot, voulez vous supprimez un lot"+ANSI_RESET);
            nbconservationlot=sc.nextInt();
        }
        int pourcent=0;
        if(stratlot==2){
            System.out.println(ANSI_PURPLE+"a partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece"+ANSI_RESET);
            pourcent=sc.nextInt();
        }
        Scanner sc3 = new Scanner(System.in);
        int proba;
        System.out.println(ANSI_PURPLE+"probabilité de recevoir un nouveau lot en %"+ANSI_RESET);
        int problot = sc3.nextInt();
        System.out.println(ANSI_PURPLE+"probabilité de recevoir une commande de meuble en %"+ANSI_RESET);
        int probmeuble = sc3.nextInt();
        int probrien =  100 - problot - probmeuble;
        proba=problot+probmeuble+probrien;
        while(proba!=100 || problot>100 || problot<0 ||probmeuble<0 ||probmeuble>100 ||probrien<0 ||probrien>1001) {
            System.out.println(ANSI_RED+"les valeurs données sont impossible"+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"probabilité de recevoir un nouveau lot en %"+ANSI_RESET);
            problot = sc3.nextInt();
            System.out.println(ANSI_PURPLE+"probabilité de recevoir une commande de meuble en %"+ANSI_RESET);
            probmeuble = sc3.nextInt();
            probrien = 100 - problot - probmeuble;
            proba=problot+probmeuble+probrien;

        }
        System.out.println(ANSI_PURPLE+"combien de pas de temps"+ANSI_RESET);
        int nb_de_pas =sc3.nextInt();
        System.out.println(ANSI_PURPLE+"combien de pas de temps maximum pour la construction d'un meuble"+ANSI_RESET);
        int tempsmax=sc3.nextInt();
        for (int nbpas = 0; nbpas < nb_de_pas; nbpas++) {
            double prob = Math.random()*100;
            if (prob < problot) {
                System.out.println(ANSI_PURPLE+"LOT"+ANSI_RESET);
                int prob2 = (int) (Math.random() * entrepot.getNompiece().length);
                int prob3 = 1 + (int) (Math.random() * (entrepot.getN() - 1)); //entrepot.n - 1
                entrepot.ajoutlot(new LotPiece(prob3, entrepot.getNomPiece(prob2), 1, entrepot.getPrixPiece(prob2)));
            } else if (prob < problot + probmeuble) {
                System.out.println(ANSI_PURPLE+"meuble"+ANSI_RESET);
                int prob2 = (int) (Math.random() * entrepot.getNommeuble().length);
                int tempsmeuble = 1 + (int) (Math.random() * (tempsmax));
                int prob3 = (int) (Math.random() * entrepot.getNomspe().length);
                Meuble meubleaj = new Meuble(entrepot.getNommeuble(prob2), entrepot.getNomSpe(prob3), tempsmeuble); //entrepot.nommeuble[prob2], entrepot.nomspe[prob3], tempsmeuble
                for (int nblot = 0; nblot < 3; nblot++) {
                    int prob4 = (int) (Math.random() * entrepot.getNompiece().length); //entrepot.nompiece.length
                    int prob5 = 1 + (int) (Math.random() * (10));
                    meubleaj.addcompo(new Paire(prob5, entrepot.getNomPiece(prob4))); //entrepot.nompiece[prob4]
                }
                int test = entrepot.montermeuble(meubleaj);
                if (test == -1) {
                    entrepot.getMeuble_nonfini().add(meubleaj); //meuble_nonfini.add(meubleaj)
                }
            } else {
                System.out.println(ANSI_PURPLE+"RIEN"+ANSI_RESET);
                //rien
            }
            int imeu = 0;
            while (imeu < entrepot.getMeuble_nonfini().size()) { //entrepot.meuble_nonfini.size()

                int testm = entrepot.montermeuble(entrepot.getMeuble_nonfini().get(imeu)); //entrepot.meuble_nonfini.get(imeu)
                System.out.println("test"+testm);
                if (testm == 1) {
                    entrepot.getMeuble_nonfini().remove(imeu); //entrepot.meuble_nonfini.remove(imeu)

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
            System.out.println(entrepot.getTresorerie()); //entrepot.tresorerie
            System.out.println(entrepot.getMeuble_nonfini().size()); //meuble_nonfini.size()
        }
    }

    /**
     * Fonction qui va afficher les différentes actions qui peuvent être effectuer par l'utilisateur.
     */
    public static void printAction() {
        System.out.println(ANSI_BLUE+"----------------------------------------\n Veuillez choisir une action à effectuer : \n----------------------------------------"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 0 pour revenir en arrière. "+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 1 pour afficher les informations actuel (Dimension de l'entrepot, Trésorerie, Taille équipe & composition : "+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 2 pour recruter une nouvelle personne : "+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 3 pour monter un nouveau meuble : "+ANSI_RESET);
    }

    /**
     * Fonction qui va permettre le recrutement d'une {@link Personne} ({@link Chefstock}, {@link Chefbrico}, {@link Ouvrier}).
     */
    public static void recruterNouvPers() {
        boolean quitter = false;
        String nom;
        String prenom;
        String fonction;
        do {
            System.out.println(ANSI_PURPLE+"Veuillez entrer le nom de la personne a recruter"+ANSI_RESET);
            nom = sc.nextLine();
            System.out.println(ANSI_PURPLE+"Veuillez entrer le prénom de la personne a recruter"+ANSI_RESET);
            prenom = sc.nextLine();
            System.out.println(ANSI_PURPLE+"Veuillez entrer la fonction de la personne a recruter (Chefbrico, Chefstock, Ouvrier)"+ANSI_RESET);
            fonction = sc.nextLine();
            try {
                if(!(nom.isEmpty()) && !(nom.isEmpty()) && fonction.equals("Chefbrico") || fonction.equals("Chefstock") || fonction.equals("Ouvrier") ) {
                    if(fonction.equals("Chefbrico")) {
                        entrepot.recruterchefbrico(new Chefbrico(nom, prenom));
                        quitter = true;
                    }
                    else if(fonction.equals("Chefstock")) {
                        entrepot.recruterchefstock(new Chefstock(nom,prenom));
                        quitter = true;
                    }
                    else if(fonction.equals("Ouvrier")) {
                        Boolean end = false;
                        do {
                            String specialite;
                            System.out.println(ANSI_PURPLE+"Veuillez entrer la spécialité de l'ouvrier"+ANSI_RESET);
                            specialite = sc.nextLine();
                            if(!(specialite.isEmpty())) {
                                entrepot.recruterouvrier(new Ouvrier(nom,prenom,specialite));
                                quitter = true;
                                end = true;
                            }
                            else {
                                System.out.println(ANSI_RED+"Un problème est survenue. Veuillez réessayer svp. "+ANSI_RESET);
                                end = false;
                            }
                        }while(!end);
                    }
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }while(!quitter);
    }

    /**
     * Fonction qui permet le montage d'un {@link Meuble}.
     */
    public static void monterNouvMeuble() {
        boolean quitter = false;
        String nom_meuble;
        String piece_meuble;
        String nombre_piece;
        if(entrepot!=null) {
            do {
                System.out.println(ANSI_PURPLE+"Veuillez entrer le nom du meuble : "+ANSI_RESET);
                nom_meuble = sc.nextLine();
                System.out.println(ANSI_PURPLE+"Veuillez entrer la pièce correspondante : "+ANSI_RESET);
                piece_meuble = sc.nextLine();
                System.out.println(ANSI_PURPLE+"Veuillez entrer le nombre de pièce nécessaire pour le montage : "+ANSI_RESET);
                nombre_piece = sc.nextLine();
                quitter = true;
                try {
                    if(nom_meuble.isEmpty() || piece_meuble.isEmpty() || nombre_piece.isEmpty()) {
                        System.out.println(ANSI_RED+"Désolé mais il y a un problème avec la saisie des informations.. Veuillez réessayer :"+ANSI_RESET);
                        quitter = false;
                    }
                    else {
                        String nom = nom_meuble;
                        String piece = piece_meuble;
                        int nombrep = Integer.parseInt(nombre_piece);
                        Meuble meuble = new Meuble(nom,piece,nombrep);
                        int val = entrepot.montermeuble(meuble);
                        if(val == -1) {
                            entrepot.getMeuble_nonfini().add(meuble); //entrepot.meuble_nonfini.add(meuble)
                        }
                        else {
                            entrepot.getMeuble_fini().add(meuble); //meuble_fini.add(meuble)
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

    /**
     * Fonction qui va exéctuer des actions en fonction du choix de l'utilisateur.
     */
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
                    recruterNouvPers();
                    break;
                case(3):
                    monterNouvMeuble();
                    break;
                default:
                    System.out.println(ANSI_RED+"Le choix que vous avez fait ne correspond à aucun choix"+ANSI_RESET);
            }
        }while(!quitter);
    }

    /**
     * Fonction qui va charger un fichier (txt) et va exécuter les actions qui y sont à l'intérieur.
     * @param nomFichier correspond au nom du fichier à charger.
     * @throws IOException return une exception si il y'a une erreur au niveau du nom du fichier.
     */
    public static void fileSimul(String nomFichier) throws IOException {
        System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
        Scanner sc=new Scanner(System.in);
        int strat=sc.nextInt();
        while(strat!=0 &&strat!=1 && strat !=2){
            System.out.println(ANSI_RED+"cette strategie n'existe pas"+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"quel strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
            strat=sc.nextInt();
        }

        int xpasdetemps=0;
        int inactmin=0;
        int inactmax=0;
        if(strat==1){
            System.out.println(ANSI_PURPLE+"Tout les combien de pas de temps souhaitez vous resserez les lots"+ANSI_RESET);
            xpasdetemps=sc.nextInt();
            System.out.println(ANSI_PURPLE+"Combien voulez vous avoir en ouvrier inactif maximal"+ANSI_RESET);
            inactmax=sc.nextInt();
            System.out.println(ANSI_PURPLE+"Quel nombre d'ouvrier inactif voulez vous recruter"+ANSI_RESET);
            inactmin=sc.nextInt();
        }
        System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous pour l'enlevement de lot ? 0,1 ou 2"+ANSI_RESET);
        int stratlot=sc.nextInt();
        while(stratlot!=0 &&stratlot!=1 && stratlot!=2){
            System.out.println(ANSI_RED+"cette strategie n'existe pas"+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"quel strategie voulez vous ? 0,1 ou 2"+ANSI_RESET);
            strat=sc.nextInt();
        }
        int nbconservationlot=0;
        if(stratlot==1){
            System.out.println(ANSI_PURPLE+"A partir de combien de reception de lot, voulez vous supprimez un lot"+ANSI_RESET);
            nbconservationlot=sc.nextInt();
        }
        int pourcent=0;
        if(stratlot==2){
            System.out.println(ANSI_PURPLE+"A partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece"+ANSI_RESET);
            pourcent=sc.nextInt();
        }

        String chemin = System.getProperty("user.dir") + "\\src\\projet\\" + nomFichier;
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
            System.out.println(ANSI_RED+"Erreur lors de l'ouverture du ficher \n"+ANSI_RESET + e);
        }
        for(int i = 0; i<informations.size(); i++) {
            if (informations.get(i)[1].equals("lot")) {
                System.out.println(ANSI_YELLOW+"Ajout d'un nouveau lot dans l'inventaire ... "+ANSI_RESET);
                int volume = Integer.parseInt(informations.get(i)[5]);
                double poids = Double.parseDouble(informations.get(i)[3]);
                double prix = Double.parseDouble(informations.get(i)[4]);
                LotPiece lot = new LotPiece(volume, informations.get(i)[2], poids, prix);
                System.out.println(ANSI_YELLOW+" [ Volume : " + lot.getVolume() + " | Nom : " + lot.getPiece().getNom() + " | Poids : " + lot.getPiece().getPoids() + " | Prix : " + lot.getPrix() + " ] \n"+ANSI_RESET);
                System.out.println(entrepot.ajoutlot(lot));
            } else if (informations.get(i)[1].equals("rien")) {
                System.out.println(ANSI_RED+"La ligne ne contient rien, il n'y a donc rien à faire"+ANSI_RESET);
            } else if (informations.get(i)[1].equals("meuble")) {
                System.out.println(ANSI_YELLOW+"Meuble à monter ..."+ANSI_RESET);
                String nom = informations.get(i)[2];
                String piece = informations.get(i)[3];
                int duree = Integer.parseInt(informations.get(i)[4]);
                Meuble meuble = new Meuble(nom, piece, duree);
                System.out.println(ANSI_YELLOW+" [ Nom : " + meuble.getNom() + " | Piece : " + meuble.getPiece() + " | Duree : " + meuble.getDuree() + " | Prix : " + meuble.getPrix() + " ] \n"+ANSI_RESET);
                for(int addp=5;addp<informations.get(i).length;addp=addp+2) {
                    String type = informations.get(i)[addp];
                    int volume = Integer.parseInt(informations.get(i)[addp+1]);
                    meuble.addcompo(new Paire(volume, type));
                }
                int test_meuble = entrepot.montermeuble(meuble);
                if (test_meuble == 1) {
                    System.out.println(ANSI_GREEN+"Meuble construit !"+ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED+"Problème lors de la construction du meuble"+ANSI_RESET);
                }
                System.out.println(test_meuble);
                if (test_meuble == -1) {
                    entrepot.getMeuble_nonfini().add(meuble); //entrepot.meuble_nonfini.add(meuble)
                }
            } else {
                System.out.println(ANSI_RED+"Désolé, l'information de la ligne n° " + i + " n'a pas été exécuté."+ANSI_RESET);
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
            System.out.println(entrepot.getMeuble_nonfini().size()); //entrepot.meuble_nonfini.size()
            // action();
        }action();
    }









//	public static void choixstrat(int i) {
//		Boolean sortie = false;
//		int strat = 0;
//		Scanner scanner = new Scanner(System.in);
//        String nbconservationlot;
//        String pourcent;
//		do {
//			System.out.println(ANSI_PURPLE+"Veuillez choisir une stratégie (1, 2, 3)"+ANSI_RESET);
//			strat = scanner.nextInt();
//			try {
//				if(strat == 0|| strat == 1 || strat == 2) {
//					if(strat == 1) {
//						String xpasdetemps;
//				        String inactmin;
//				        String inactmax;
//						boolean quitter = false;
//						do {
//							System.out.println(ANSI_PURPLE+"Tout les combien de pas de temps souhaitez vous resserez les lots"+ANSI_RESET);
//				            xpasdetemps=scanner.nextLine();
//				            System.out.println(ANSI_PURPLE+"Combien voulez vous avoir en ouvrier inactif maximal"+ANSI_RESET);
//				            inactmax=scanner.nextLine();
//				            System.out.println(ANSI_PURPLE+"Sous quel nombre d'ouvrier inactif recruterez vous"+ANSI_RESET);
//				            inactmin=scanner.nextLine();
//				            if(!(xpasdetemps.isEmpty()) && !(inactmax.isEmpty()) && !(inactmin.isEmpty()) ) {
//				            	entrepot.strat1(i,Integer.parseInt(xpasdetemps),Integer.parseInt(inactmin),Integer.parseInt(inactmax));
//				            	sortie = true;
//				            	quitter = true;
//				            }
//				            else {
//				            	System.out.println(ANSI_RED+"Désolé, il y a un problème avec la saisie."+ANSI_RESET);
//				            	quitter = false;
//				            }
//						}while(!quitter);
//					}
//					else if(strat == 2) {
//						entrepot.strat2();
//						sortie = true;
//						break;
//					}
//					else if(strat == 3) {
//						System.out.println(ANSI_PURPLE+"Quelle strategie voulez vous pour l'enlevement de lot ? (1 ou 2)"+ANSI_RESET);
//						int stratlot=scanner.nextInt();
//						if(stratlot == 0 || stratlot == 1 || stratlot == 2) {
//							if(stratlot == 1) {
//								Boolean s = false;
//								do {
//									System.out.println(ANSI_PURPLE+"A partir de combien de reception de lot, voulez vous supprimez un lot"+ANSI_RESET);
//						            nbconservationlot=scanner.nextLine();
//						            if(!(nbconservationlot.isEmpty())) {
//						            	entrepot.stratretirerlot1(i,Integer.parseInt(nbconservationlot));
//						            	sortie = true;
//						            	s = true;
//						            }
//								}while(!s);
//							}
//							else if(stratlot == 2) {
//								Boolean end = false;
//								do {
//								System.out.println("A partir de quel pourcentage de l'entrepot pris par une seule piece, voulez vous supprimer  un lot de ce type de piece");
//					            pourcent=scanner.nextLine();
//					            if(!(pourcent.isEmpty())) {
//									entrepot.stratretirerlot2(Integer.parseInt(pourcent));
//									sortie = true;
//									end = true;
//					            }
//								}while(!end);
//							}
//						}
//					}
//					else {
//						System.out.println(ANSI_RED+"Désolé, la saisie ne correspond à aucun des choix. "+ANSI_RESET);
//						sortie = false;
//					}
//
//				}
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}while(!sortie);
//		scanner.close();
//	}








    /**
     * Fonction qui va exécuter une action en fonctions du choix de l'utilisateur.
     */
    public static void choisirStrat() {
        boolean quitter = false;
        do {
            printChoix();
            int strat = scan.nextInt();
            switch(strat) {
                case(0):
                    Personne.setI(0);
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
                    System.out.println(ANSI_RED+"Le choix que vous avez fait ne correspond à aucun choix"+ANSI_RESET);
            }
        }while(!quitter);
    }

    /**
     * Fonction qui va afficher les informations de l'{@link Entrepot}.
     */
    public static void afficherInfos() {
        System.out.println(ANSI_YELLOW+" Informations de l'entrepot : \n"+ANSI_RESET);
        if(entrepot != null) {System.out.println(ANSI_YELLOW+" Informations : \n [ Rangee : " + entrepot.getM() + " | Ligne "+ entrepot.getN() + " | Tresorerie "+ entrepot.getTresorerie() + " ] \n"+ANSI_RESET);} //entrepot.m + " | Ligne "+ entrepot.n + " | Tresorerie "+ entrepot.tresorerie + " ] \n"+ANSI_RESET);
        else { System.out.println(ANSI_RED+"Désolé, il n'existe aucun entrepot."+ANSI_RESET); }

        if(entrepot !=null) {
            System.out.println(ANSI_YELLOW+"Inventaire : \n"+ANSI_RESET);
            System.out.println(ANSI_YELLOW+entrepot.faireInventaire()+ANSI_RESET);
            entrepot.afficherMeuble();
        }
        else {
            System.out.println(ANSI_RED+"Désolé, il n'y a aucun inventaire."+ANSI_RESET);
        }

        System.out.println(ANSI_YELLOW+"Taille de l'équipe & composition : \n "+ANSI_RESET);
        if(entrepot !=null) { System.out.println(ANSI_YELLOW+"Taille équipe : "+ taille_eq +"\n"+ entrepot.afficherEquipe() + " \n"+ANSI_RESET);}
        else { System.out.println(ANSI_RED+"Désolé, il n'existe aucune équipe."+ANSI_RESET); }

    }

    /**
     * Fonction qui va afficher les choix qui peuvent être choisi par l'utilisateur.
     */
    public static void printChoix() {
        System.out.println(ANSI_BLUE+"-------------------------------------------------------------------------\n Veuillez choisir votre stratégie : \n-------------------------------------------------------------------------"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 0 pour recommencer avec un nouvel entrepot : "+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 1 pour afficher les informations actuel (Dimension de l'entrepot, Trésorerie, Taille équipe & composition) : "+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 2 pour lancer la simulation n°1 via fichie"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 3 pour lancer la simulation n°2 via console "+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 4 pour lancer la simulation n°3 aléatoire"+ANSI_RESET);
    }

    /**
     * Fonction qui va afficher le menu de départ du programme.
     */
    public static void printMenu() {
        System.out.println(ANSI_BLUE+"  ____  _ _ _                       \r\n"
                + " |  _ \\(_) | |                      \r\n"
                + " | |_) |_| | | ___  _ __ ___   ___  \r\n"
                + " |  _ <| | | |/ _ \\| '_ ` _ \\ / _ \\ \r\n"
                + " | |_) | | | | (_) | | | | | | (_) |\r\n"
                + " |____/|_|_|_|\\___/|_| |_| |_|\\___/ \r\n"
                + "                                    \r\n"
                + "                                    \n"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Auteur : Abdesamad & Kylan \n"+ANSI_RESET);

        System.out.println(ANSI_BLUE+"-------------------------------------------------------------------------\n Bienvenue sur l'interface de gestion : Plusieurs choix s'offrent à vous : \n-------------------------------------------------------------------------"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 0 pour quitter l'interface."+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Entrer 1 pour créer l'entrepot : "+ANSI_RESET);
    }

    /**
     * Fonction qui va permettre d'arrêter le programme ou d'initialiser un nouvel {@link Entrepot} afin d'y effectuer différentes actions.
     */
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
                    System.out.println(ANSI_RED+"Désolé, mais la valeur entrer est incorrect."+ANSI_RESET);
            }
        }while(!quitter);
    }

}
