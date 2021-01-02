package projet;
/**
 * Un Chef est une personne qui dirige et qui a sous ses ordres des {@link Ouvrier}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */



public abstract class Chef extends Personne{
    // tailleeq correspond à la taille de l'équipe d'ouvrier que le Chef a à sa charge.
    private int tailleeq;
    // liste_ouv correspond à la liste des ouvriers qui sont sous les ordres du Chef.
    private Ouvrier liste_ouv[] = new Ouvrier[4];

    /**
     * Constructeur de la classe Chef.
     * @param nom correspond au nom du Chef.
     * @param prenom correspond au prénom du Chef.
     * @param fonction correspond à la fonction du Chef.
     * @param tailleeq correspond à la taille de l'équipe du Chef.
     * @param actif indique si le Chef est occupé ou non (true ou false).
     */
    public Chef(String nom, String prenom,String fonction, int tailleeq, boolean actif) {
        super(nom, prenom,fonction, actif);
        this.tailleeq = tailleeq;
    }


    /**
     * Fonction qui permet de recruter un {@link Ouvrier}.
     * @param nom correspond au Nom de l' {@link Ouvrier}.
     * @param prenom correspond au Prénom de l'{@link Ouvrier}.
     * @param specialite correspond  à la spécialité de l'{@link Ouvrier}.
     * @return return 1 si l'{@link Ouvrier} est recruté et -1 pour le contraire.
     */
    public int recruterOuv(String nom, String prenom, String specialite) {
        int res = -1;
        for(int i = 0; i<this.liste_ouv.length; i++) {
            if(liste_ouv[i] == null) {
                if(this.tailleeq<4) {
                    liste_ouv[i] = new Ouvrier(nom, prenom, specialite);
                    tailleeq++;
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
    public int recruterOuv(Ouvrier o) {
        int res = -1;
        for(int i=0; i<this.liste_ouv.length ; i++) {
            if(liste_ouv[i] == null) {
                if(this.tailleeq<4) {
                    liste_ouv[i] = o;
                    tailleeq++;
                    res = 1;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet de licencier un {@link Ouvrier}.
     * @param k correspond au Kème {@link Ouvrier} à licencier.
     */
    public void licencier_ouvrier(int k) {
        this.liste_ouv[k] = null;
        this.tailleeq--;
    }


    /**
     * Fonction qui permet d'afficher le {@link Ouvrier} qui sont sous les ordres du Chef.
     * @return return la liste des {@link Ouvrier} qui sont sous les ordres du Chef.
     */
    public String afficherOuvrier() {
        String res = "";
        int ouvid = -1;
        for(int i = 0; i<this.liste_ouv.length; i++ ) {
            if(this.liste_ouv[i] != null && ouvid != this.liste_ouv[i].getId()) {
                res += " [ Ouvrier : ID : " + this.liste_ouv[i].getId() + " | Nom : " + this.liste_ouv[i].getNom() + " | Prenom : " + this.liste_ouv[i].getPrenom() + " | Fonction :  "+this.liste_ouv[i].getFonction()+"| Spécialité : "+ this.liste_ouv[i].getSpecialite() +" | Actif : "+ this.liste_ouv[i].isActif()+ " ] \n";
                ouvid = this.liste_ouv[i].getId();
            }
        }
        return res;
    }

    /**
     * Fonction qui return la taille de l'equipe du Chef. (Getter)
     * @return return la taille de l'équipe.
     */
    public int getTailleeq() {
        return tailleeq;
    }

    /**
     * Fonction qui permet de modifier la taille de l'équipe. (Setter)
     * @param tailleeq correspond à la taille de l'équipe.
     */
    public void setTailleeq(int tailleeq) {
        this.tailleeq = tailleeq;
    }

    /**
     * Fonction qui return la liste des Ouvriers. (Getter)
     * @return return un tableau d'Ouvrier.
     */
    public Ouvrier[] getListe_ouv() {
        return liste_ouv;
    }

    /**
     * Fonction qui retourne un Ouvrier. (Getter)
     * @param k correspond au kème ouvrier que l'on recherche.
     * @return return un Ouvrier.
     */
    public Ouvrier getOuv(int k) {
        Ouvrier o = null;
        for(int i=0; i<this.getListe_ouv().length;i++) {
            if(i == k) {
                o = this.liste_ouv[i];
            }
        }
        return o;
    }

    /**
     * Fonction qui permet de modifier un {@link Ouvrier}.
     * @param k correspond au kème {@link Ouvrier}.
     * @param o Correspond à l'{@link Ouvrier} que l'on souhaite ajouter.
     */
    public void setOuv(int k , Ouvrier o) {
        for(int i = 0; i<this.getListe_ouv().length; i++) {
            if(i == k) {
                this.liste_ouv[k] = o;
            }
        }
    }



    /**
     * Fonction qui permette de modifier la liste d'Ouvrier. (Setter)
     * @param liste_ouv correspond à la liste d'ouvrier que l'on va associer au Chef.
     */
    public void setListe_ouv(Ouvrier[] liste_ouv) {
        this.liste_ouv = liste_ouv;
    }



}
