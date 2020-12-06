package projet;

public abstract class Personne{
    String nom;
    String prenom;
    boolean actif;
    static int i = 1;
    int id;

    public Personne(String nom, String prenom, Boolean actif){
        this.nom = nom;
        this.prenom = prenom; 
        this.actif = actif;
        this. id = i; 
        i++;
    }

    public int get_id(){
        return this.id;
    }

    public String get_nom(){
        return this.nom;
    }

    public String get_prenom(){
        return this.prenom;
    }

    public Boolean get_actif(){
        return this.actif; 
    }

    public void set_actif(Boolean actif){
        this.actif = actif; 
    }

}