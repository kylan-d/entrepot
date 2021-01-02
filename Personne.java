package projet;

/**
 * Une Personne est un individu qui dans ce cadre va effectuer différentes tâches. Une Personne peut correspond à un {@link Chef} ou à un {@link Ouvrier}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public abstract class Personne {
    // nom : correspond au nom de la Personne
    private String nom;
    // prenom : correspond au prenom de la Personne
    private String prenom;
    // fonction : correspond à la fonction qu'occupe la Personne (Chefstock, Chefbrico, Ouvrier).
    private String fonction;
    // actif : true la Personne est active et false pour le contraire.
    private boolean actif;
    // i : est un nombre qui va s'incrémenter à chaque fois qu'on qu'une Personne est instancié, et cette valeur va être associé à l'identifiant de la Personne.
    private static int i = 0;
    // id : correspond à l'identifiant de la Personne.
    private int id;

    /**
     *
     * @param nom correspond à l'identifiant de la Personne.
     * @param prenom correspond au prénom de la Personne.
     * @param fonction correspond à la fonction qu'occupe la Personne.
     * @param actif true si la personne est active et false pour le contraire. 1
     */
    public Personne(String nom, String prenom,String fonction, Boolean actif){
        this.setNom(nom);;
        this.setPrenom(prenom);;
        this.setFonction(fonction);
        this.setActif(actif);
        this.setId(i);
        i++;
    }


    /**
     * Fonction qui récupère le nom de la Personne (Getter)
     * @return return le nom de la Personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Fonction qui permet de modifier le nom de la Personne
     * @param nom correspond au nom de la Personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Fonction qui permet de modifier la valeur de i (Setter)
     * @param i correspond à la valeur i
     */
    public static void setI(int i) {
        Personne.i = i;
    }


    /**
     * Fonction qui récupère le prénom de la Personne. (Getter)
     * @return return le prénom de la Personne.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Fonction qui permet de modifier le prénom de la Personne. (Setter)
     * @param prenom correspond au prenom de la Personne.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Fonction qui permet de récupérer la fonction de la Personne (Chefstock , Chefbrico ou Ouvrier) (Getter).
     * @return return la fonction de la Personne.
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * Fonction qui permet de modifier la fonction de la Personne. (Setter)
     * @param fonction correspond à la fonction de la personne.
     */
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


    /**
     * Fonction qui récupère un booléen qui indique si la Personne est ocuppée ou non (actif ou inactif). (Getter)
     * @return return le statut de la Personne (actif : true ou inactif : false)
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * Fonction qui va permettre de modifier la valeur actif de la Personne.(Setter)
     * @param actif correspond à un booléen (true ou false)
     */
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    /**
     * Fonction qui permet de récupérer la valeur i (valeur qui sera associer à l'identifiant de la personne). (Getter)
     * @return return la valeur i.
     */
    public static int getI() {
        return i;
    }

    /**
     * Fonction qui permet de récupérer l'identifiant de la Personne. (Getter)
     * @return return l'identifiant de la Personne.
     */
    public int getId() {
        return id;
    }

    /**
     * Fonction qui permet de modifier l'identifiant de la Personne. (Setter)
     * @param id correspond à l'identifiant de la Personne.
     */
    public void setId(int id) {
        this.id = id;
    }

}

