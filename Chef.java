package projet;
public abstract class Chef extends Personne{
    Ouvrier liste_ouv[]= new Ouvrier[4];
    int tailleeq;
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
