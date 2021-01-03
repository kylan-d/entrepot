package projet;
import java.util.ArrayList;

/**
 * Un entrepot est un endroit qui va permettre le stockage de {@link LotPiece}. Différentes actions pourront y être effectuer par des {@link Chefbrico}, {@link Chefstock} ou des {@link Ouvrier}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Entrepot {
    // m : correspond à au nombre de Rangee
    private int m;
    // n : correspond à la taille d'une Rangee
    private int n;
    // tresorerie : correspond à la trésorerie de l'E
    private double tresorerie;
    // nbactchefstock : correspond au nombre de Chefstock qui sont occupés (actif).
    private int nbactchefstock;
    // nbactchefbrico : correspond au nombre de Chefbrico qui sont occupés (actif)
    private int nbactchefbrico;
    // nbactouvrier : correspond au nombre d'Ouvrier qui sont occupés (actif).
    private int nbactouvrier;
    // nomspe[] : correspond aux spécialité que les Ouvriers peuvent avoir et aux pièces des Meubles.
    private static String[] nomspe = {"salon", "salledebain", "cuisine", "chambre", "toilette", "salleamanger"};
    // nompiece : correspond aux noms des différentes pièces qui peuvent être utilisé pour la construction d'un Meuble.
    private static String[] nompiece = {"porte", "charniere", "tiroir", "poignee", "cheville", "vis", "planche", "tasseau", "equerre", "boulon", "clou"};
    // prixpiece : correspond aux prix que peuvent avoir les pièces.
    private static double[] prixpiece = {2000, 400, 1300, 400, 200, 600, 1000, 900, 400, 800, 500};
    // nommeuble : correspond aux meubles qui peuvent être construit.
    private static String[] nommeuble = {"commode", "lit", "etagere", "placard", "bureau", "table", "meubletv"};
    // meuble_nonfini : correspond à l'ensemble des meubles qui ne sont pas encore construit.
    private ArrayList<Meuble> meuble_nonfini = new ArrayList<Meuble>();
    //meuble_fini : correspond à l'ensemble des meubles qui sont construit.
    private ArrayList<Meuble> meuble_fini = new ArrayList<Meuble>();
    // chef_equipe : correspond à l'ensemble des chefs qui ont été recruté dans l'Entrepot.
    private ArrayList<Chef> chef_equipe = new ArrayList<Chef>();
    // ligne : correspond au contenu de la Rangee.
    private Rangee[] ligne;
    // liste_reservation : correspond a tout les lots déja affecté a des meuble.
    ArrayList<Reservation> liste_reservation;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    /**
     * Constructeur de la classe Entrepot.
     * @param m correspond au nombre de {@link Rangee}.
     * @param n correspond à la taille des {@link Rangee}.
     * @param tresorerie correspond à la trésorerie de l'{@link Entrepot}.
     */
    public Entrepot(int m, int n, double tresorerie) {
        this.m = m;
        this.n = n;
        this.tresorerie = tresorerie;
        ligne = new Rangee[m];
        for(int i=0; i<m; i++) {
            ligne[i] = new Rangee(n);
        }
        liste_reservation= new ArrayList<Reservation>();
    }

    /**
     * Fonction qui affiche l'inventaire de l'Entrepot.
     * @return return le contenu de l'Entrepot.
     */
    public String faireInventaire(){
        int memid=-1;
        int placerest=0;
        String c= "Dans l'entrepot il y a : \n";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(this.getLigne(i).getPlace(j)!=null && memid!= this.getLigne(i).getPlace(j).getId()){
                    c += this.getLigne(i).getPlace(j).getPiece().getNom() +" avec "+ this.getLigne(i).getPlace(j).getVolume() +" quantité(s). \n";
                    memid=this.getLigne(i).getPlace(j).getId();
                }
            }
            placerest+= ligne[i].getTaille_restante(); // N'est pas utilisé ici
        }
        System.out.println(ANSI_YELLOW+"Place restante : "+ placerest +ANSI_RESET );
        return c;
    }



    /**
     * Fonction qui correspond à la Simulation 4 (Strat 3)
     */
    public void Simul4(){
        if(entrepot.compteinactif() > entrepot.compteactif()){
            entrepot.licencierOuvrier();
        }

        String specialite = "";
        int indice_meuble_nonfini = 0;
        for(int i = 0; i<entrepot.getMeuble_nonfini().size();i++){
            if(entrepot.getMeuble_nonfini().get(i)!=null){
                specialite = entrepot.getMeuble_nonfini().get(i).getPiece();
                indice_meuble_nonfini = i; 
                break;
            }
        }        
        int res = 0;
        try{
            for(int j = 0; j<entrepot.getChef_equipe.size();j++){
                if(entrepot.getTailleeq <4){
                    Ouvrier o = new Ouvrier("Ou","Vrier",specialite);
                    for(int k = 0; k<entrepot.getmeuble_nonfini().size();k++){
                        if(i == k){
                            res = entrepot.montermeuble(entrepot.getmeuble_nonfini().get(i));
                            if(res == 1){
                                entrepot.getmeuble_nonfini.remove(entrepot.getmeuble_nonfini.get(k));
                                entrepot.get_meublefini.add(entrepot.getmeuble_nonfini.get(k));
                                break;
                            }
                            else{
                                System.out.println("Une erreur est surevenue, le meuble n'a pas été monter");
                                break;
                            }
                        }
                    }
                   
                }
                else if(entrepot.getTailleeq >4){
                    if(m.getMeuble_nonfini.getDuree >2){
                        Chefstock = new Chefstock("Chef","Stock");
                        break;
                    }
                    else{
                        Chefbrico = new Chefbrico("Chef","Brico");
                        for(int l = 0; l<entrepot.getmeuble_nonfini().size();i++){
                            if(i == l ){
                                res = entrepot.monterMeuble(entrepot.getmeuble_nonfini().get(l));
                                if(res == 1){
                                    entrepot.getmeuble_nonfini.remove(entrepot.getmeuble_nonfini.get(k));
                                    entrepot.getMeuble_fini.add(entrepot.getmeuble_nonfini.get(k));
                                    break;
                                })
                            }                        }
                    }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }












    /**
     * Fonction qui affiche l'ensemble des {@link Meuble} (finis et non finis)
     */
    public void afficherMeuble() {
//		System.out.println("\033[2J\033[1;1H");
        String resultat = " ";
        resultat += ANSI_RED + "\nLes meubles à finir sont : \n" + ANSI_RESET;
        for(int i = 0; i<meuble_nonfini.size() ;i++) {
            resultat += ANSI_RED + "\n[Nom : "+meuble_nonfini.get(i).getNom() + " | Pièce : "+ meuble_nonfini.get(i).getPiece()+ " | Duree : "+meuble_nonfini.get(i).getDuree() + "]\n"+ANSI_RESET;
            for(int j = 0; j<meuble_nonfini.get(i).getListe_lot_piece().size();j++) { //int j = 0; j<meuble_nonfini.get(i).liste_lot_piece.size();j++
                resultat +=  ANSI_YELLOW + "[Type de piece : "+meuble_nonfini.get(i).getListe_lot_piece().get(j).getType() + " | Quantité : "+ meuble_nonfini.get(i).getListe_lot_piece().get(j).getVolume() + "]\n" +ANSI_RESET; //ANSI_YELLOW + "[Type de piece : "+meuble_nonfini.get(i).liste_lot_piece.get(j).type + " | Quantité : "+ meuble_nonfini.get(i).liste_lot_piece.get(j).volume + "]\n" +ANSI_RESET
            }
        }

        resultat += ANSI_BLUE+"\n******************************************************************\n"+ANSI_RESET+ ANSI_GREEN+"\nLes meubles finis sont : \n"+ANSI_RESET;
        for(int i = 0; i<meuble_fini.size() ;i++) {
            resultat += ANSI_GREEN + "\n[Nom : "+meuble_fini.get(i).getNom() + " | Pièce : "+ meuble_fini.get(i).getPiece()+ " | Duree : "+meuble_fini.get(i).getDuree() + " | Prix :  "+meuble_fini.get(i).getPrix() +"]\n"+ANSI_RESET;
            for(int j = 0; j<meuble_fini.get(i).getListe_lot_piece().size();j++) { //int j = 0; j<meuble_fini.get(i).liste_lot_piece.size();j++
                resultat += ANSI_YELLOW+"[Type de piece : "+meuble_fini.get(i).getListe_lot_piece().get(j).getType()+ " | Quantité : "+ meuble_fini.get(i).getListe_lot_piece().get(j).getVolume() + "]\n"+ANSI_RESET; //ANSI_YELLOW+"[Type de piece : "+meuble_fini.get(i).liste_lot_piece.get(j).type + " | Quantité : "+ meuble_fini.get(i).liste_lot_piece.get(j).volume + "]\n"+ANSI_RESET
            }
        }

        System.out.println(resultat);
    }


    /**
     * Fonction qui va payer l'ensemble des {@link Personne} qui travaille dans l'Entrepot.
     */
    public void payer() {
        tresorerie -=  (10 * chef_equipe.size());
        for (int i = 0; i<chef_equipe.size();i++) {
            tresorerie -= (5*chef_equipe.get(i).getTailleeq());
        }
    }

    /**
     * Fonction qui va permettre le recrutement d'un {@link Chefbrico}.
     * @param nom correspond au nom du {@link Chefbrico}.
     * @param prenom correspond au prénom du {@link Chefbrico}.
     */
    public void recruterchefbrico(String nom,String prenom){
        chef_equipe.add(new Chefbrico(nom,prenom));
    }

    /**
     * Fonction qui va permettre le recrutement d'un {@link Chefbrico}.
     * @param c correspond à un {@link Chefbrico}.
     */
    public void recruterchefbrico(Chefbrico c) {
        if(c instanceof Chefbrico) {
            chef_equipe.add(c);
        }
        else { System.out.println(ANSI_RED+"Désolé, ce n'est pas un Chef brico."+ANSI_RESET);}
    }

    /**
     * Fonction qui va permettre le recrutement d'un {@link Chefstock}.
     * @param nom correspond au nom du {@link Chefstock}.
     * @param prenom correspond au prenom du {@link Chefstock}.
     */
    public void recruterchefstock(String nom,String prenom){
        chef_equipe.add(new Chefstock(nom,prenom));
    }

    /**
     * Fonction qui va permettre le recrutement d'un {@link Chefstock}.
     * @param c correspond à un {@link Chefstock}.
     */
    public void recruterchefstock(Chefstock c) {
        if(c instanceof Chefstock) {
            chef_equipe.add(c);
        }
        else { System.out.println(ANSI_RED+"Désolé, ce n'est pas un Chef stock."+ANSI_RESET);}
    }

    /**
     * Fonction qui permet de licencier un {@link Chef} de l'Entrepot.
     * @return return 1 si le {@link Chef} a été licencié et -1 pour le contraire.
     */
    public int licencierChef(){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            a=0;
            if(chef_equipe.get(i).isActif()==false){
                if(chef_equipe.get(i).getTailleeq()==0){
                    chef_equipe.remove(i);
                    res = 1;
                    break;
                }
                for(int j=0;j<chef_equipe.size();j++){
                    if(i!=j){
                        a+= (4-chef_equipe.get(j).getTailleeq());
                        if(a>=chef_equipe.get(i).getTailleeq()){
                            for(int k=0;k<chef_equipe.size();k++){
                                if(chef_equipe.get(k).getTailleeq()<4 && chef_equipe.get(i).getTailleeq()!=0 && i!=k){
                                    for(int chgt2=0;chgt2<4;chgt2++){
                                        for(int chgt=0;chgt<4;chgt++){
                                            if(chef_equipe.get(k).getOuv(chgt)==null && chef_equipe.get(i).getOuv(3-chgt2)!=null){ // liste_ouv[chgt] ; liste_ouv[3-chgt2]
                                                chef_equipe.get(k).setOuv(chgt, chef_equipe.get(i).getOuv(3-chgt2)); //chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];

                                                chef_equipe.get(i).setOuv(3-chgt2, null); //liste_ouv[3-chgt2] = null
                                                chef_equipe.get(k).setTailleeq(chef_equipe.get(k).getTailleeq()+1);
                                                chef_equipe.get(i).setTailleeq(chef_equipe.get(i).getTailleeq() -1);
                                            }}}}
                                if(chef_equipe.get(i).getTailleeq() == 0){
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

    /**
     * Fonction qui permet de licencier un {@link Chefbrico} de l'Entrepot.
     * @return return 1 si le {@link Chefbrico} a été licencié et -1 pour le contraire.
     */
    public int licencierChefbrico(){
        int a = 0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefbrico){
                a=0;
                if(chef_equipe.get(i).isActif() == false){
                    if(chef_equipe.get(i).getTailleeq() == 0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+= (4-chef_equipe.get(j).getTailleeq());

                            if(a>=chef_equipe.get(i).getTailleeq()){
                                for(int k=0;k<chef_equipe.size();k++){

                                    if(chef_equipe.get(k).getTailleeq()<4 && chef_equipe.get(i).getTailleeq()!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).getOuv(chgt)==null && chef_equipe.get(i).getOuv(3-chgt2)!=null){ //if(chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null)
                                                    chef_equipe.get(k).setOuv(chgt, chef_equipe.get(i).getOuv(3-chgt2)); //chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];

                                                    chef_equipe.get(i).setOuv(3-chgt2, null); //chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).setTailleeq(chef_equipe.get(k).getTailleeq() +1);//tailleeq++;
                                                    chef_equipe.get(i).setTailleeq(chef_equipe.get(i).getTailleeq() -1); //chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).getTailleeq()==0){
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


    /**
     * Fonction qui permet de licencier un {@link Chefstock} de l'Entrepot.
     * @return return 1 si le {@link Chefstock} est a été licencié et -1 pour le contraire.
     */
    public int licencierChefstock(){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock){
                a=0;
                if(chef_equipe.get(i).isActif()==false){
                    if(chef_equipe.get(i).getTailleeq()==0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+= (4-chef_equipe.get(j).getTailleeq());
                            if(a>=chef_equipe.get(i).getTailleeq()){
                                for(int k=0;k<chef_equipe.size();k++){
                                    if(chef_equipe.get(k).getTailleeq()<4 && chef_equipe.get(i).getTailleeq()!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).getOuv(chgt)==null && chef_equipe.get(i).getOuv(3-chgt2)!=null){ //chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null
                                                    chef_equipe.get(k).setOuv(chgt, chef_equipe.get(i).getOuv(3-chgt2)); //chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];

                                                    chef_equipe.get(i).setOuv(3-chgt2, null);//liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).setTailleeq(chef_equipe.get(k).getTailleeq() +1);//tailleeq++;
                                                    chef_equipe.get(i).setTailleeq(chef_equipe.get(i).getTailleeq() -1);//tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).getTailleeq()==0){
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


    /**
     * Fonction qui permet de licencier un {@link Chef} de l' Entrepot.
     * @param id correspond à l'identifiant du {@link Chef} à licencier.
     * @return return 1 si le {@link Chef} a été licencié et -1 pour le contraire.
     */
    public int licencierChef(int id){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).getId()==id){
                a=0;
                if(chef_equipe.get(i).isActif()==false){
                    if(chef_equipe.get(i).getTailleeq()==0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+=(4-chef_equipe.get(j).getTailleeq());
                            if(a>=chef_equipe.get(i).getTailleeq()){
                                for(int k=0;k<chef_equipe.size();k++){
                                    if(chef_equipe.get(k).getTailleeq()<4 && chef_equipe.get(i).getTailleeq()!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).getOuv(chgt)==null && chef_equipe.get(i).getOuv(3-chgt2)!=null){ //chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null
                                                    chef_equipe.get(k).setOuv(chgt, chef_equipe.get(i).getOuv(3-chgt2));//chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];
                                                    System.out.println(chgt);
                                                    chef_equipe.get(i).setOuv(3-chgt2, null); // chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).setTailleeq(chef_equipe.get(k).getTailleeq() + 1); //chef_equipe.get(k).tailleeq++;
                                                    chef_equipe.get(i).setTailleeq(chef_equipe.get(i).getTailleeq() -1); //chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).getTailleeq()==0){
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



    /**
     * Fonction qui permet de licencier un {@link Chef} de l'Entrepot.
     * @param nom correspond au nom du {@link Chef} à licencier.
     * @param prenom correspond au prénom du {@link Chef} à licencier.
     * @return return 1 si le {@link Chef} a été licencié et -1 pour le contraire.
     */
    public int licencierChef(String nom,String prenom){
        int a=0;
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).getNom()==nom && chef_equipe.get(i).getPrenom()==prenom){
                a=0;
                if(chef_equipe.get(i).isActif()==false){
                    if(chef_equipe.get(i).getTailleeq()==0){
                        chef_equipe.remove(i);
                        res = 1;
                        break;
                    }
                    for(int j=0;j<chef_equipe.size();j++){
                        if(i!=j){
                            a+=(4-chef_equipe.get(j).getTailleeq());
                            if(a>=chef_equipe.get(i).getTailleeq()){
                                for(int k=0;k<chef_equipe.size();k++){
                                    if(chef_equipe.get(k).getTailleeq()<4 && chef_equipe.get(i).getTailleeq()!=0 && i!=k){
                                        for(int chgt2=0;chgt2<4;chgt2++){
                                            for(int chgt=0;chgt<4;chgt++){
                                                if(chef_equipe.get(k).getOuv(chgt)==null && chef_equipe.get(i).getOuv(3-chgt2)!=null){ //chef_equipe.get(k).liste_ouv[chgt]==null && chef_equipe.get(i).liste_ouv[3-chgt2]!=null
                                                    chef_equipe.get(k).setOuv(chgt, chef_equipe.get(i).getOuv(3-chgt2)); //chef_equipe.get(k).liste_ouv[chgt]=chef_equipe.get(i).liste_ouv[3-chgt2];
                                                    System.out.println(chgt);
                                                    chef_equipe.get(i).setOuv(3-chgt2, null); //chef_equipe.get(i).liste_ouv[3-chgt2]=null;
                                                    chef_equipe.get(k).setTailleeq(chef_equipe.get(k).getTailleeq() +1); //chef_equipe.get(k).tailleeq++;
                                                    chef_equipe.get(i).setTailleeq(chef_equipe.get(i).getTailleeq() -1); //chef_equipe.get(i).tailleeq=chef_equipe.get(i).tailleeq-1;
                                                }}}}
                                    if(chef_equipe.get(i).getTailleeq()==0){
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

    /**
     * Fonction qui permet de recruter un {@link Ouvrier}.
     * @param nom correspond au nom de l'{@link Ouvrier}.
     * @param prenom correspond au prénom de l'{@link Ouvrier}.
     * @param specialite correspond à la spécialité de l'{@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est recruté et -1 pour le contraire.
     */
    public int recruterouvrier(String nom,String prenom,String specialite){
        int res =-1;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) != null) {
                if(chef_equipe.get(i).getTailleeq()<4){
                    chef_equipe.get(i).recruterOuv(nom,prenom,specialite);
                    res = 1;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de recruter un {@link Ouvrier}.
     * @param o correspond à un {@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est recruté et -1 pour le contraire.
     */
    public int recruterouvrier(Ouvrier o) {
        int res = -1;
        for(int i=0; i<chef_equipe.size();i++) {
            if(chef_equipe.get(i) != null) {
                if(chef_equipe.get(i).getTailleeq()<4) {
                    chef_equipe.get(i).recruterOuv(o);
                    res = 1;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de licencier un {@link Ouvrier}.
     * @return 1 si l'{@link Ouvrier} est licencié et -1 pour le contraire.
     */
    public int licencierOuvrier(){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ // chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//                    if(res == 1) break;
            }
        }return res;
    }

    /**
     * Fonction qui permet de licencier un {@link Ouvrier}.
     * @param specialite correspond à la spécialité de l'{@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est licencié, -1 pour le contraire.
     */
    public int licencierOuvrier(String specialite){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false && chef_equipe.get(i).getOuv(j).getSpecialite().equals(specialite)){//chef_equipe.get(i).liste_ouv[j].isActif()==false && chef_equipe.get(i).liste_ouv[j].getSpecialite().equals(specialite)
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//                    if(res==1) break;
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de licencié un {@link Ouvrier}.
     * @param id correspond à l'identifiant de l'{@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est licencié, -1 pour le contraire.
     */
    public int licencierOuvrier(int id){
        int res = -1;
        recherche:
        for(int i = 0; i<chef_equipe.size(); i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false && chef_equipe.get(i).getOuv(j).getId()== id){ //chef_equipe.get(i).liste_ouv[j].isActif()==false && chef_equipe.get(i).liste_ouv[j].getId()== id
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//                    if(res==1) break;
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de licencié un {@link Ouvrier}.
     * @param nom correspond au nom de l'{@link Ouvrier}.
     * @param prenom correspond au prénom de l'{@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est licencié, -1 pour le contraire.
     */
    public int licencierOuvrier(String nom, String prenom){
        int res = -1;
        recherche:
        for(int i = 0; i<chef_equipe.size(); i++) {
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false && chef_equipe.get(i).getOuv(j).getNom().equals(nom) && chef_equipe.get(i).getOuv(j).getPrenom().equals(prenom)) { //chef_equipe.get(i).liste_ouv[j].isActif()==false && chef_equipe.get(i).liste_ouv[j].getNom().equals(nom) && chef_equipe.get(i).liste_ouv[j].getPrenom().equals(prenom)
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res = 1;
                        break recherche;
                    }}
//        			if(res==1) break;
            }
        }
        return res;
    }


    /**
     * Fonction qui permet de licencier un {@link Ouvrier}.
     * @param nom correspond au nom de l'{@link Ouvrier}.
     * @param prenom correspond au prénom de l'{@link Ouvrier}.
     * @param specialite correspond à la spécialité de l'{@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est licencié, -1 pour le contraire.
     */
    public int licencierOuvrier(String nom, String prenom, String specialite){
        int res = -1;
        recherche:
        for(int i = 0; i<chef_equipe.size(); i++) {
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false && chef_equipe.get(i).getOuv(j).getNom().equals(nom) && chef_equipe.get(i).getOuv(j).getPrenom().equals(prenom) && chef_equipe.get(i).getOuv(j).getPrenom().equals(specialite)) {//chef_equipe.get(i).liste_ouv[j].isActif()==false && chef_equipe.get(i).liste_ouv[j].getNom().equals(nom) && chef_equipe.get(i).liste_ouv[j].getPrenom().equals(prenom) && chef_equipe.get(i).liste_ouv[j].getPrenom().equals(specialite)
                        chef_equipe.get(i).licencier_ouvrier(j);
                        res =1;
                        break recherche;
                    }}
//        			if(res==1) break;
            }
        }
        return res;

    }

    /**
     *Fonction qui permet de licencié un {@link Ouvrier}.
     * @param o correspond à un {@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est licencié, -1 pour le contraire.
     */
    public int licencierOuvrier(Ouvrier o) {
        int res = -1;
        recherche:
        for(int i=0; i<chef_equipe.size(); i++) {
            System.out.println(chef_equipe.get(i));
            if(chef_equipe.get(i) != null) {
                System.out.println(chef_equipe.get(i).getNom());
                for(int j=0;j<4;j++){
                    if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                        if(chef_equipe.get(i).getOuv(j) != null) { //chef_equipe.get(i).liste_ouv[j] != null
//	        				System.out.println(chef_equipe.get(i).liste_ouv[j].nom);
                            System.out.println(chef_equipe.get(i).getOuv(j).isActif()); //chef_equipe.get(i).liste_ouv[j].isActif()
                            if(chef_equipe.get(i).getOuv(j).isActif() == false && chef_equipe.get(i).getOuv(j).equals(o)) { //chef_equipe.get(i).liste_ouv[j].isActif() == false && chef_equipe.get(i).liste_ouv[j].equals(o)
                                System.out.println(chef_equipe.get(i).getOuv(j).getNom()); //chef_equipe.get(i).liste_ouv[j].getNom()
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

    /**
     * Fonction qui permet d'ajouter un nouveau {@link LotPiece} dans l' Entrepot.
     * @param lot correspond à un {@link LotPiece}
     * @return return 1 si le {@link LotPiece} a été ajouté, -1 pour le contraire.
     */
    public int ajoutlot(LotPiece lot){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
//        	System.out.println("Chefstock dispo");
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).isActif()==false){
                Chefstock a = (Chefstock)chef_equipe.get(i);
                int b= a.ajouterlot(lot,this);
                res = b;
                break;
            }
            for(int j=0;j<4;j++){
//            	System.out.println("Ouvrier dispo");
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        res = chef_equipe.get(i).getOuv(j).ajouterlot(lot,this); //chef_equipe.get(i).liste_ouv[j].ajouterlot(lot,this)
                        break recherche;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de retirer un {@link LotPiece} de l'Entrepot.
     * @param m correspond aux nombre de {@link Rangee}.
     * @param n correspond à la taille de la {@link Rangee}.
     * @param vol correspond à la taille que l'on souhaite gagner dans la {@link Rangee}(grâce au retrait).
     * @return return 1 si le {@link LotPiece} est retiré, -1 pour le contraire.
     */
    public int retirerlot(int m, int n, int vol){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).isActif()==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,m,n,vol);
                res = 1;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        chef_equipe.get(i).getOuv(j).retirerlot(this,m,n,vol); //chef_equipe.get(i).liste_ouv[j].retirerlot(this,m,n,vol)
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de retirer un {@link LotPiece} de l'Entrepot.
     * @param id correspond à l'identifiant du {@link LotPiece}.
     * @return return 1 si le {@link LotPiece} est retiré, -1 pour le contraire.
     */
    public int retirerlot(int id){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).isActif()==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,id);
                res = 1;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        chef_equipe.get(i).getOuv(j).retirerlot(this,id); //  chef_equipe.get(i).liste_ouv[j].retirerlot(this,id)
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de retiré un {@link LotPiece} de l'Entrepot.
     * @param nom correspond au nom du {@link LotPiece}.
     * @return return 1 si le {@link LotPiece} est retiré, -1 pour le contraire.
     */
    public int retirerlot(String nom){
        int res = -1;
        recherche:
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).isActif()==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                a.retirerlot(this,nom);
                res = 1;
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        chef_equipe.get(i).getOuv(j).retirerlot(this,nom); //chef_equipe.get(i).liste_ouv[j].retirerlot(this,nom)
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de déplacer un {@link LotPiece} dans l'Entrepot.
     * @param m1 correspond à l'enplaceement initial du {@link LotPiece}.
     * @param m2 correspond à l'emplacement final du {@link LotPiece}.
     * @param idlot correspond à l'identifiant du {@link LotPiece}.
     * @return return 1 si le {@link LotPiece} est déplacé, -1 pour le contraire.
     */
    public int deplacerlot(int m1, int m2, int idlot){
        int res=-1;
        int test=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefstock && chef_equipe.get(i).isActif()==false){
                Chefstock a= (Chefstock)chef_equipe.get(i);
                res=a.deplacerlot(this,idlot,m1,m2);
                break;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        res = chef_equipe.get(i).getOuv(j).deplacerlot(this,idlot,m1,m2); //chef_equipe.get(i).liste_ouv[j].deplacerlot(this,idlot,m1,m2)
                        test=1; // ?
                        break;

                    }
                }
            }if(test!=0){break;}
        }
        return res;
    }

    /**
     * Fonction qui permet de construire un {@link Meuble}.
     * @param m correspond au {@link Meuble} qui doit être construit.
     * @return return 1 si le {@link Meuble} est monté, -1 pour le contraire.
     */
    public int  montermeublebis(Meuble m){
        int res = -1;
        recherche:
        for(int lg=0;lg<this.m;lg++){
            if(ligne[lg] !=null){ // On parcours les rangée
                for(int pl=0;pl<this.n;pl++){  // On parcours les lots dans la rangée
                    if(this.getLigne(lg).getPlace(pl) != null){ // Si dans la rangée, il y a des lots
                        for(int i=0;i<m.getListe_lot_piece().size();i++){ // On parcours la liste des pièces nécéssaire au montage du meuble que l'on a passer en paramettre //int i=0;i<m.liste_lot_piece.size();i++
                            if(this.getLigne(lg).getPlace(pl).getPiece().getNom().equals(m.getListe_lot_piece().get(i).getType())){ // Si on a la pièce dispo en entrepot //ligne[lg].place[pl].piece.nom.equals(m.liste_lot_piece.get(i).type
                                if(this.getLigne(lg).getPlace(pl).getVolume()>=m.getListe_lot_piece().get(i).getVolume()){ // On check si il y a une qté suffisante //ligne[lg].place[pl].volume>=m.liste_lot_piece.get(i).volume

                                    for(int j = 0; j<chef_equipe.size(); j++) {
                                        System.out.println(chef_equipe.get(j).getPrenom());
                                        if(chef_equipe.get(j) instanceof Chefbrico && chef_equipe.get(j).isActif() == false) {
                                            double prix = m.calculerPrix(this.getLigne(lg).getPlace(pl));
                                            int b = retirerlot(lg,pl,m.getListe_lot_piece().get(i).getVolume()); //lg,pl,m.liste_lot_piece.get(i).volume
                                            Chefbrico c = (Chefbrico)chef_equipe.get(j);
                                            c.monterMeuble(m);
                                            tresorerie+=prix;
                                            System.out.println("Lot retiré : "+b);
                                            System.out.println("Meuble montée ! ");
                                            res = 1;
                                            break recherche;
                                        }
                                        else {
                                            for(int k=0;k<chef_equipe.get(j).getListe_ouv().length; k++) { //int k=0;k<chef_equipe.get(j).liste_ouv.length; k++
                                                if(chef_equipe.get(j).getOuv(k)!= null && chef_equipe.get(j).getOuv(k).isActif() == false && chef_equipe.get(j).getOuv(k).getSpecialite().equals(m.getPiece())) { //chef_equipe.get(j).liste_ouv[k]!= null && chef_equipe.get(j).liste_ouv[k].isActif() == false && chef_equipe.get(j).liste_ouv[k].getSpecialite().equals(m.piece)
                                                    double prix = m.calculerPrix(this.getLigne(lg).getPlace(pl));
                                                    int b = retirerlot(lg,pl,m.getListe_lot_piece().get(i).getVolume()); //lg,pl,m.liste_lot_piece.get(i).volume
                                                    Ouvrier o = (Ouvrier)chef_equipe.get(j).getOuv(k); //(Ouvrier)chef_equipe.get(j).liste_ouv[k]
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

    /**
     * Fonction qui permet de rendre actif un {@link Chefbrico} ou un {@link Ouvrier}.
     */
    public void rendreactif(){
        System.out.println("actifff");
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i) instanceof Chefbrico){
                if(((Chefbrico) chef_equipe.get(i)).getPas_restantmeuble()>0){
                    ((Chefbrico) chef_equipe.get(i)).setPas_restantmeuble(((Chefbrico) chef_equipe.get(i)).getPas_restantmeuble() -1);}
                if(((Chefbrico) chef_equipe.get(i)).getPas_restantmeuble()==0){
                    chef_equipe.get(i).setActif(false);
                }


            }
            else{
                chef_equipe.get(i).setActif(false);
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).getPas_restantmeuble()>0){ //chef_equipe.get(i).liste_ouv[j].getPas_restantmeuble()>0
                        chef_equipe.get(i).getOuv(j).setPas_restantmeuble(chef_equipe.get(i).getOuv(j).getPas_restantmeuble() -1);//pas_restantmeuble--;chef_equipe.get(i).liste_ouv[j].setPas_restantmeuble(chef_equipe.get(i).liste_ouv[j].getPas_restantmeuble() -1
                    }
                    if(chef_equipe.get(i).getOuv(j).getPas_restantmeuble()==0){ //chef_equipe.get(i).liste_ouv[j].getPas_restantmeuble()==0
                        chef_equipe.get(i).getOuv(j).setActif(false); //chef_equipe.get(i).liste_ouv[j].setActif(false)
                    }
                }

            }
        }
    }

    /**
     * Fonction qui affiche l'ensemble des équipes de l'Entrepot.
     * @return return la liste des équipes.
     */
    public String afficherEquipe() {
        String res = "";
        int cid = -1;
        for(int i=0; i<this.chef_equipe.size(); i++) {
            if(this.chef_equipe.get(i) != null && cid != this.chef_equipe.get(i).getId()) {
                res += "{ Chef d'équipe : ID : " + this.chef_equipe.get(i).getId() + " | Nom : " + this.chef_equipe.get(i).getNom() + " | Prenom : " + this.chef_equipe.get(i).getPrenom() + " | Fonction : "+this.chef_equipe.get(i).getFonction()+" | Actif : "+ this.chef_equipe.get(i).isActif()+ " } \nListe ouvrier :  \n" + this.chef_equipe.get(i).afficherOuvrier();
                cid = this.chef_equipe.get(i).getId();
            }
        }
        return res;
    }

    /**
     * Fonction qui compte le nombre de {@link Personne} libre (non actif) .
     * @return return le nombre de {@link Personne} sans tâche (non actif).
     */
    public int compteinactif(){
        int nbinact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).isActif()==false){
                nbinact++;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==false){ //chef_equipe.get(i).liste_ouv[j].isActif()==false
                        nbinact++;
                    }
                }
            }
        }
        return nbinact;
    }

    /**
     * Fonction qui compte le nombre de {@link Chefbrico} inactif.
     * @return return le nombre de {@link Chefbrico} libre (inactif).
     */
    public int compteinactifbr(){
        int nbinact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).isActif()==false && chef_equipe.get(i) instanceof Chefbrico){
                nbinact++;
            }
        }
        return nbinact;
    }

    /**
     * Fonction qui compte le nombre de {@link Chefstock} inactif.
     * @return return le nombre de {@link Chefstock} libre (inactif).
     */
    public int compteinactifst(){
        int nbinact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).isActif()==false && chef_equipe.get(i) instanceof Chefstock){
                nbinact++;
            }
        }
        return nbinact;
    }

    /**
     * Fonction qui compte le nombre de {@link Personne} libres.
     * @return return le nombre de {@link Personne} occupés (actif).
     */
    public int compteactif(){
        int nbact=0;
        for(int i=0;i<chef_equipe.size();i++){
            if(chef_equipe.get(i).isActif()==true){
                nbact++;
            }
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).isActif()==true){ //chef_equipe.get(i).liste_ouv[j].isActif()==true
                        nbact++;
                    }
                }
            }
        }
        return nbact;
    }

    /**
     * Fonction qui va optimiser le rangement des {@link LotPiece} dans l'Entrepot.
     */
    public void optirangementstrat1(){
        int remp=0;
        int remp2=0;
        for(int i=0;i<m;i++){
            remp=0;
            remp2=0;
            for(int j=0;j<n;j++){
                if(this.getLigne(i).getPlace(j)!=null){
                    remp++;
                }
            }
            if(remp!=n){
                while(this.getLigne(i).getPlace(remp2)!=null){
                    remp2++;
                }
                if(remp2!=remp){
                    for(int k=remp2;k<n;k++){
                        if(this.getLigne(i).getPlace(k)!=null){
                            this.deplacerlot(i,i,this.getLigne(i).getPlace(k).getId());
                        }
                    }
                }
            }
        }
    }

    /**
     * Fonction qui va optimiser le rangement dans l'Entrepot.
     */
    public void stratrangement2(){
        int remp=0;
        int remp2=0;
        int memidlot=-1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(this.getLigne(i).getPlace(j)!=null){
                    int k=0;
                    int test=-1;
                    while(test==-1){

                        if(k==i){break;}
                        test=deplacerlot(i,k,this.getLigne(i).getPlace(j).getId());
                        k++;
                        if(k==i){break;}


                    }
                }

            }
        }
    }

    /**
     * Fonction qui va executé la stratégie n°1.
     * @param i i correspond ...
     * @param xpasdetemps xpasdetemps correspond à la durée de construction d'un meuble.
     * @param inactmin inactmin correspond au nombre minimum de Personne libres (inactif).
     * @param inactmax inactmax correspond au nombre maximum de Personne occupées (actif).
     */
    public void strat1(int i,int xpasdetemps,int inactmin,int inactmax){
        if(xpasdetemps!=0){
            if (i % xpasdetemps == 0) {//ici on fais la division euclidienne du pas te temps ou l'on se trouve symbolise par i par xpasdetemps et on garde le reste, donc si xpasdetemps = 10 on fera la methode tout les 10 pas de temps
                optirangementstrat1();
            }
        }

        if (compteinactif() <= inactmin) {
            String nomrec = "Paul" + i;
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
        }
        else if (compteinactif() >= inactmax) {
            int testlic = licencierChefstock();
            if (testlic == -1) {
                testlic = licencierOuvrier();
                if (testlic == -1) {
                    licencierChefbrico();
                }
            }
        }
    }


    /**
     *Fonction qui va exécuter la stratégie n°2.
     */
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

    /**
     * Fonction qui calcule le nombre d'{@link Ouvrier} qui ont spécialité passé en paramètre dans l'Entrepot.
     * @param spe correspond à la spécialité d'un {@link Ouvrier}.
     * @return return le nombre d'{@link Ouvrier} qui a la spécialité en question.
     */
    public int comptespe(String spe){
        int nb=0;
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){ //chef_equipe.get(i).liste_ouv[j]!=null
                    if(chef_equipe.get(i).getOuv(j).getSpecialite().equals(spe)){ //chef_equipe.get(i).liste_ouv[j].getSpecialite().equals(spe)
                        nb++;
                    }
                }
            }
        }
        return nb;
    }
    /**
     * Fonction qui calcule le nombre d'{@link Ouvrier} qui ont spécialité passé en paramètre dans l'Entrepot et libre(non actif).
     * @param spe correspond à la spécialité d'un {@link Ouvrier}.
     * @return return le nombre d'{@link Ouvrier} qui a la spécialité en question.
     */
    public int compteinactifspe(String spe){
        int nb=0;
        for(int i=0;i<chef_equipe.size();i++){
            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){
                    if(chef_equipe.get(i).getOuv(j).getSpecialite().equals(spe) &&chef_equipe.get(i).getOuv(j).isActif()==false){
                        nb++;
                    }
                }
            }
        }
        return nb;
    }

    /**
     * Fonction qui va exécuté la stratégie supression de {@link LotPiece}.
     * @param nbpasdetemps correspond au temps de construction d'un {@link Meuble}.
     * @param nbconservationlot correspond ....
     */
    public void stratretirerlot1(int nbpasdetemps,int nbconservationlot){
        int idplusancienlot=-1;
        int idplusrecentlot=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(this.getLigne(i).getPlace(j)!=null){
                    if(idplusancienlot==-1){
                        if(dejapris(i,j)==true){
                            break;
                        }
                        idplusancienlot=this.getLigne(i).getPlace(j).getId();
                    }
                    if(idplusrecentlot==-1){
                        idplusrecentlot=this.getLigne(i).getPlace(j).getId();
                    }
                    if(this.getLigne(i).getPlace(j).getId()<idplusancienlot){
                        if(dejapris(i,j)==true){
                            break;
                        }
                        idplusancienlot=this.getLigne(i).getPlace(j).getId();

                    }
                    if(this.getLigne(i).getPlace(j).getId()>idplusrecentlot){
                        idplusrecentlot=this.getLigne(i).getPlace(j).getId();
                    }
                }
            }
        }
        if(idplusrecentlot-idplusancienlot>nbconservationlot){
            retirerlot(idplusancienlot);
            System.out.println("on supp un lot");
        }


    }

    /**
     * Fonction qui va appliqué la stratégie supression {@link LotPiece}.
     * @param pourcent correspond au pourcentage ...
     */
    public void stratretirerlot2(int pourcent){
        ArrayList<Paire> piece=new ArrayList<Paire>();
        int r=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(dejapris(i,j)==true){
                    break;
                }
                if (this.getLigne(i).getPlace(j) != null) {
                    r=0;
                    for(int k=0;k<piece.size();k++){
                        if(this.getLigne(i).getPlace(j).getPiece().getNom().equals(piece.get(k).getType())){
                            piece.get(k).setVolume(piece.get(k).getVolume() +1); //volume++
                            r++;
                            break;
                        }
                        if(r==0){piece.add(new Paire(1,this.getLigne(i).getPlace(j).getPiece().getNom()));}
                    }
                }
            }
        }
        int max=0;
        int place=0;
        for(int l=0;l<piece.size();l++){
            if(piece.get(l).getVolume()>max){
                place=l;
            }
        }
        if(piece.size()!=0){
            if((m*n*pourcent)/100<piece.get(place).getVolume()) {
                retirerlot(piece.get(place).getType());
                System.out.println("on supp un lot");
            }
        }}

    public int  montermeuble(Meuble m){
        ArrayList<Integer> pm =new ArrayList<Integer>();
        ArrayList<Integer> pn =new ArrayList<Integer>();
        ArrayList<Integer> lvol =new ArrayList<Integer>();
        int res = 1;
        int a=1;
        int pierest=0;
        ArrayList<Paire> copielist=new ArrayList<Paire>();
        for(int cl=0;cl<m.getListe_lot_piece().size();cl++){
            copielist.add(new Paire(m.getListe_lot_piece().get(cl).getVolume(),m.getListe_lot_piece().get(cl).getType()));
        }
        if(compteinactif()-compteinactifbr()==0){
            return -1;
        }
        if(compteinactifspe(m.getPiece())+compteinactifbr()==0){
            return -2;
        }
        ArrayList<Reservation> lotdejareser= new ArrayList<Reservation>();
        for(int im=0;im<this.m;im++){
            for(int in=0;in<this.n;in++){
                if(ligne[im].getPlace(in)!=null){
                    for(int i=0;i<copielist.size();i++){
                        if(ligne[im].getPlace(in).getPiece().getNom().equals(copielist.get(i).getType())){
                            if(copielist.get(i).getVolume()>0){
                                boolean pris=dejapris(im,in);
                                if(pris==false) {
                                    pm.add(im);
                                    pn.add(in);
                                    copielist.get(i).setVolume(copielist.get(i).getVolume()-1);
                                    break;
                                }
                                else{
                                    int raj=-1;
                                    for(int parcresa=0;parcresa<lotdejareser.size();parcresa++){
                                        if(ligne[im].getPlace(in).getId()==lotdejareser.get(parcresa).idlot){
                                            raj=parcresa;
                                        }
                                    }
                                    if(raj==-1){
                                        lotdejareser.add(new Reservation(ligne[im].getPlace(in).getId(),0,m.getId(),ligne[im].getPlace(in).getPrix()));
                                        raj=lotdejareser.size()-1;
                                    }
                                    if(volumelotreserve(ligne[im].getPlace(in).getId())+lotdejareser.get(raj).volumelot<ligne[im].getPlace(in).getVolume()){
                                        lotdejareser.get(raj).volumelot++;
                                        pm.add(im);
                                        pn.add(in);
                                        copielist.get(i).setVolume(copielist.get(i).getVolume()-1);
                                        break;
                                    }
                                }
                            }}
                    }

                }
            }}

        // for(int ic=0;ic<pm.size();ic++){
        //   for(int jc=0;jc<copielist.size();jc++){
        //     if(copielist.get(jc).type==ligne[pm.get(ic)].place[pn.get(ic)].piece.nom && copielist.get(jc).volume>0){
        //     copielist.get(jc).volume--;
        //       break;
        //     }
        //   }
        // }
        int testpiece=0;
        for(int pc=0;pc<copielist.size();pc++){
            if(copielist.get(pc).getVolume()>0){
                testpiece++;
            }
        }
        if(testpiece!=0){
            return -3;
        }
        int present=0;
        ArrayList<Reservation> tableprereser= new ArrayList<Reservation>();
        for(int ir=0;ir<pm.size();ir++){
            present=0;
            for(int jr=0;jr<tableprereser.size();jr++){
                if(tableprereser.get(jr).idlot==ligne[pm.get(ir)].getPlace(pn.get(ir)).getId()){
                    tableprereser.get(jr).volumelot++;
                    present=1;
                    break;
                }
            }
            if(present==0){
                tableprereser.add(new Reservation(ligne[pm.get(ir)].getPlace(pn.get(ir)).getId(),1,m.id,ligne[pm.get(ir)].getPlace(pn.get(ir)).getPrix()));
            }
        }
        for(int resa=0;resa<tableprereser.size();resa++){
            liste_reservation.add(tableprereser.get(resa));
        }
        int finir=finirmeuble(m);
        if(finir==-1) {
            meuble_nonfini.add(m);
        }

            return finir;


    }

    public boolean dejapris(int im,int in){
        boolean pris=false;
        for(int i=0;i<liste_reservation.size();i++){
            if(liste_reservation.get(i).idlot==ligne[im].getPlace(in).getId()){
                pris=true;
            }
        }
        return pris;
    }
    public int volumelotreserve(int idlot){
        int pris=0;
        for(int i=0;i<liste_reservation.size();i++){
            if(liste_reservation.get(i).idlot==idlot){
                pris++;
            }
        }
        return pris;
    }
    public int retirerlot(int id,int vol){
        int bm=-1;
        int bn=-1;
        recherche:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ligne[i].getPlace(j)!=null){
                    if(ligne[i].getPlace(j).getId()==id){
                        bm=i;
                        bn=j;
                        break recherche;
                    }}
            }
        }
        int ret;
        if(bm==-1||bn==-1){
            ret=-1;
        }
        else{
            ret=retirerlot(bm,bn,vol);
        }
        return ret;
    }
    public int finirmeuble(Meuble m){
        int toutenleve=1;
        int i=0;
        while(i<liste_reservation.size()){
            if(liste_reservation.get(i).idmeuble==m.id){
                double pr=liste_reservation.get(i).prix;
                int test=retirerlot(liste_reservation.get(i).idlot,liste_reservation.get(i).volumelot);
                if(test==1){
                    m.setPrix(m.getPrix()+liste_reservation.get(i).volumelot*pr);
                    liste_reservation.remove(i);
                }
                else{
                    i++;
                    toutenleve=-1;
                }
            }
        }
        if(toutenleve==-1){
            return -1;
        }
        int res=-1;
        sortie:
        for(i=0;i<chef_equipe.size();i++){

            if(chef_equipe.get(i) instanceof Chefbrico && chef_equipe.get(i).isActif()==false){
                Chefbrico c= (Chefbrico)chef_equipe.get(i);
                c.monterMeuble(m);
                System.out.println("on termine un meuble");
                tresorerie += m.getPrix();
//                tempo += m.calculerPrix(ligne);
                res = 1;
                System.out.println("llaaa");
                break sortie;
            }

            for(int j=0;j<4;j++){
                if(chef_equipe.get(i).getOuv(j)!=null){
                    if(chef_equipe.get(i).getOuv(j).isActif()==false && chef_equipe.get(i).getOuv(j).getSpecialite().equals(m.getPiece())){
                        chef_equipe.get(i).getOuv(j).monterMeuble(m);
                        System.out.println("on termine un meuble");
                        tresorerie += m.getPrix();
//                        tempo += m.calculerPrix(ligne);
                        res = 1;
                        break sortie;
                    }
                }
            }
        }

        return res;
    }


    /**
     * Fonction qui retourne le nombre de {@link Rangee} de l'Entrepot.(Getter)
     * @return return le nombre de Rangee.
     */
    public int getM() {
        return m;
    }

    /**
     * Fonction qui permet de modifier la nombre de {@link Rangee} de l'Entrepot. (Setter)
     * @param m correspond à au nombre de Rangee que l'on va associer à l'Entrepot.
     */
    public void setM(int m) {
        this.m = m;
    }

    /**
     * Fonction qui retourne la taille des {@link Rangee} de l'Entrepot. (Getter)
     * @return return la taille des {@link Rangee} de l'Entrepot.
     */
    public int getN() {
        return n;
    }

    /**
     * Fonction qui permet de modifier la taille des {@link Rangee} de l'Entrepot (Setter)
     * @param n correspond à la taille des {@link Rangee} que l'on va associer à l'Entrepot.
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * Fonction qui retroune la tresorerie de l'Entrepot. (Getter)
     * @return return la tresorerie de l'Entrepot.
     */
    public double getTresorerie() {
        return tresorerie;
    }

    /**
     * Fonction qui permet de modifier la tresorerie de l'Entrepot (Setter)
     * @param tresorerie correspond à la valeur que l'on va associer à la tresorerie de l'Entrepot.
     */
    public void setTresorerie(double tresorerie) {
        this.tresorerie = tresorerie;
    }

    /**
     * Fonction qui permet de récuperer le nombre de {@link Chefstock} actif. (Getter)
     * @return return le nombre de {@link Chefstock} actif.
     */
    public int getNbactchefstock() {
        return nbactchefstock;
    }

    /**
     * Fonction qui permet de modifier le nombre de {@link Chefstock} actif. (Setter)
     * @param nbactchefstock correspond au nombre de {@link Chefstock} actif que l'on va associer à l'Entrepot.
     */
    public void setNbactchefstock(int nbactchefstock) {
        this.nbactchefstock = nbactchefstock;
    }

    /**
     * Fonction qui récupère le nombre de {@link Chefbrico} actif. (Getter)
     * @return return le nombre de {@link Chefbrico} actif.
     */
    public int getNbactchefbrico() {
        return nbactchefbrico;
    }

    /**
     * Fonction qui permet de modifier le nombre de {@link Chefbrico} actif. (Setter)
     * @param nbactchefbrico correspond au nombre {@link Chefbrico} actif que l'on va associer à l'Entrepot.
     */
    public void setNbactchefbrico(int nbactchefbrico) {
        this.nbactchefbrico = nbactchefbrico;
    }

    /**
     * Fonction qui récupère le nombre d'{@link Ouvrier} actif. (Getter)
     * @return return le nombre d'{@link Ouvrier} actif.
     */
    public int getNbactouvrier() {
        return nbactouvrier;
    }

    /**
     * Fonction qui permet de modifier le nombre d'{@link Ouvrier} actif. (Setter)
     * @param nbactouvrier correspond au nombre d'{@link Ouvrier} actif que l'on va associer à l'Entrepot.
     */
    public void setNbactouvrier(int nbactouvrier) {
        this.nbactouvrier = nbactouvrier;
    }

    /**
     * Return la liste des spécialité des {@link Ouvrier}. (Getter)
     * @return return un tableau qui contient la liste des spécialités des {@link Ouvrier}
     */
    public static String[] getNomspe() {
        return nomspe;
    }

    /**
     * Fonction qui permet de modifier les spécialités des {@link Ouvrier}. (Setter)
     * @param nomspe correspond aux spécialités que l'on va attribué aux {@link Ouvrier}
     */
    public static void setNomspe(String[] nomspe) {
        Entrepot.nomspe = nomspe;
    }

    /**
     * Fonction qui permet de récupérer une spécialité en particulier. (Getter)
     * @param k correspond au kème élement du tableau des spécialité.
     * @return return le nom de la spécialité.
     */
    public static String getNomSpe(int k) {
        String resultat = "";
        for(int i = 0; i<nomspe.length;i++) {
            if(i == k ) {
                resultat= nomspe[i];
            }
        }
        return resultat;
    }


    /**
     * Fonction qui récupère la liste des pièces possible pour un {@link Meuble} (Getter)
     * @return return un tableau qui contient la liste des pièces qu'un {@link Meuble} peut avoir.
     */
    public static String[] getNompiece() {
        return nompiece;
    }


    /**
     * Fonction qui récupère un nom de Piece en particulier. (Getter)
     * @param k correspond au kème élément du tableau des piece.
     * @return return le nom de la piece.
     */
    public static String getNomPiece(int k){
        String resultat = "";
        for(int i = 0; i<nompiece.length; i++) {
            if(i == k ) {
                resultat = nompiece[i];
            }
        }
        return resultat;
    }


    /**
     * Fonction qui permet de modifier la liste des pièces d'un {@link Meuble}. (Setter)
     * @param nompiece correspond aux noms des pieces que l'on pourra associer à un {@link Meuble}
     */
    public static void setNompiece(String[] nompiece) {
        Entrepot.nompiece = nompiece;
    }

    /**
     * Fonction qui récupère la liste des {@link LotPiece.Piece} possible pour les {@link LotPiece} (Getter)
     * @return return un tableau contenant les {@link LotPiece.Piece} possibles pour construire un {@link Meuble}.
     */
    public static double[] getPrixpiece() {
        return prixpiece;
    }

    /**
     * Fonction qui récupère un prix en particulier. (Getter)
     * @param k correspond au kème élément du tableau des prix.
     * @return return le prix.
     */
    public static double getPrixPiece(int k){
        double resultat = 0;
        for(int i = 0; i<prixpiece.length; i++) {
            if(i == k ) {
                resultat = prixpiece[i];
            }
        }
        return resultat;
    }





    /**
     * Fonction qui permet de modifier la liste des {@link LotPiece.Piece} possible pour les {@link LotPiece} (Setter)
     * @param prixpiece correspond à la liste des {@link LotPiece.Piece} qui pourront être utilisées pour contruire un {@link Meuble}
     */
    public static void setPrixpiece(double[] prixpiece) {
        Entrepot.prixpiece = prixpiece;
    }

    /**
     * Fonction qui permet de récupérer les noms des {@link Meuble} (Getter)
     * @return return un tableau qui contient les noms des {@link Meuble}
     */
    public static String[] getNommeuble() {
        return nommeuble;
    }


    /**
     * Fonction qui récupère le nom d'un certain {@link Meuble} (Getter)
     * @param k correspond au kème nom de meuble que l'on souhaite avoir.
     * @return return le nom d'un Meuble.
     */
    public static String getNommeuble(int k) {
        String resultat = "";
        for(int i = 0; i<nommeuble.length; i++) {
            if(i ==k) {
                resultat = nommeuble[i];
            }
        }

        return resultat;
    }







    /**
     * Fonction qui permet de modifier les noms des @{link Meuble}. (Setter)
     * @param nommeuble correspond au noms que l'on va pouvoir associer à des {@link Meuble}
     */
    public static void setNommeuble(String[] nommeuble) {
        Entrepot.nommeuble = nommeuble;
    }

    /**
     * Fonction qui return la liste des {@link Meuble} qui ne sont pas terminés. (Getter)
     * @return return une ArrayList de {@link Meuble} non fini.
     */
    public ArrayList<Meuble> getMeuble_nonfini() {
        return meuble_nonfini;
    }

    /**
     * Fonction qui permet de modifier la liste des {@link Meuble} non fini. (Setter)
     * @param meuble_nonfini correspond à la une ArrayList de {@link Meuble} que l'on va associer aux {@link Meuble} non fini.
     */
    public void setMeuble_nonfini(ArrayList<Meuble> meuble_nonfini) {
        this.meuble_nonfini = meuble_nonfini;
    }

    /**
     * Fonction qui return la liste des {@link Meuble} construit. (Getter)
     * @return return une ArrayList des {@link Meuble} finis.
     */
    public ArrayList<Meuble> getMeuble_fini() {
        return meuble_fini;
    }

    /**
     * Fonction qui permet de modifier la liste des {@link Meuble} construit. (Setter)
     * @param meuble_fini correspond à une ArrayList de {@link Meuble} que l'on va associer aux {@link Meuble} finis.
     */
    public void setMeuble_fini(ArrayList<Meuble> meuble_fini) {
        this.meuble_fini = meuble_fini;
    }

    /**
     * Fonction qui return une liste de {@link Chef} (Getter)
     * @return return une ArrayList de {@link Chef}.
     */
    public ArrayList<Chef> getChef_equipe() {
        return chef_equipe;
    }

    /**
     * Fonction qui permet de modifier la liste des {@link Chef} (Setter)
     * @param chef_equipe correspond à une ArrayList de {@link Chef} que l'on va associer au {@link Chef} de l'Entrepot.
     */
    public void setChef_equipe(ArrayList<Chef> chef_equipe) {
        this.chef_equipe = chef_equipe;
    }

    /**
     * Fonction qui récupère le contenu des {@link Rangee} (Getter)
     * @return return un tableau qui contient le contenu des {@link Rangee}.
     */
    public Rangee[] getLigne() {
        return ligne;
    }

    /**
     * Fonction qui permet de modifier le contenu des {@link Rangee} (Setter)
     * @param ligne correspond a un tableau qui contient des {@link LotPiece} et que l'on va associer aux {@link Rangee} de l'Entrepot.
     */
    public void setLigne(Rangee[] ligne) {
        this.ligne = ligne;
    }


    /**
     * Fonction qui return une certaine {@link Rangee} de l'Entrepot..  (Getter)
     * @param rangee correspond au numéro de la {@link Rangee} que l'on souhaite accéder.
     * @return return une certaine {@link Rangee}
     */
    public Rangee getLigne(int rangee) {
        Rangee resultat = null;
        for(int i = 0; i<this.ligne.length; i++) {
            if(i == rangee) {
                resultat = this.ligne[i];
            }
        }
        return resultat;
    }




















}
