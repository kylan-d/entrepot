package projet;
/**
 * Un Chefbrico est une {@link Personne} qui a sous ses ordres des {@link Ouvrier}. Le Chefbrico peut uniquement monter des {@link Meuble}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Chefbrico extends Chef{
    // pas_restantmeuble : correspond au temps restant avant que le meuble soit construit
    private int pas_restantmeuble=0;

    /**
     * Constructeur de la classe Chefbrico.
     * @param nom correspond au nom du Chefbrico.
     * @param prenom correspond au prenom du Chefbrico.
     */
    public Chefbrico(String nom,String prenom){
        super(nom,prenom,"Chefbrico", 0,false);
    }

    /**
     * Fonction qui rend actif le Chefbrico et instancie la durée de construction du {@link Meuble} à construire par le Chefbrico.
     * @param m correspond au {@link Meuble} à monter.
     */
    public void monterMeuble(Meuble m){
        super.setActif(true);
        this.setPas_restantmeuble(m.getDuree());
    }

    /**
     * Fonction qui récupère la durée restante pour la construction d'un meuble. (Getter)
     * @return return la durée restante pour la construction d'un meuble (Correspond à la durée de construction d'un meuble. Initialement à 0 quand le chef est inactif).
     */
    public int getPas_restantmeuble() {
        return pas_restantmeuble;
    }

    /**
     * Fonction qui permet de modifier les pas restant. (Setter)
     * @param pas_restantmeuble correspond au pas restant.
     */
    public void setPas_restantmeuble(int pas_restantmeuble) {
        this.pas_restantmeuble = pas_restantmeuble;
    }


}

