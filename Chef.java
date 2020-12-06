package projet;
public abstract class Chef extends Personne{

    private int tailleeq;
    private Ouvrier liste_ouv[]= new Ouvrier[4];

    public Chef(String nom, String prenom, int tailleeq, boolean actif){
        super(nom, prenom, actif);
        this.tailleeq = this.tailleeq;
        this.actif = actif; 
    }

    public void recruterouv(String nom,String prenom,String specialite){
        for(int j=0;j<4;j++){
            if(liste_ouv[j]==null){
                liste_ouv[j]=new Ouvrier(nom,prenom,specialite);
                 tailleeq++;
                 return;
    }}}

    public void licencier_ouvrier(int k){
        liste_ouv[k]=null;
        tailleeq--;
    }
}