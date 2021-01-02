package projet;

/**
 * Un Ouvrier est une Personne qui va être sous les ordres d'un {@link Chef}. L'Ouvrier va s'occuper du montage des {@link Meuble} et de la gestion de l'{@link Entrepot}.
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Ouvrier extends Personne {
    // specialite : correspond à la spécialité de l'Ouvrier, à la piece dont il est spécialiste (Cuisine, Chambre, Salon, ...).
    private String specialite;
    // pas_restantmeuble : correspond au temps restant avant que le meuble soit construit.
    private int pas_restantmeuble=0;

    /**
     * Constructeur de la classe Ouvrier.
     * @param nom correspond au nom de l'Ouvrier.
     * @param prenom correspond au prénom de l'Ouvrier.
     * @param specialite correspond à la spécialité de l'Ouvrier.
     */
    public Ouvrier(String nom, String prenom, String specialite) {
        super(nom, prenom,"Ouvrier", false);
        this.setSpecialite(specialite);
    }

    /**
     * Fonction qui va permettre de retirer un {@link LotPiece} de l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel l'Ouvrier travaille.
     * @param rangee correspond à la {@link Rangee} qui contient le(s) {@link LotPiece} à retirer.
     * @param place correpond à l'emplacement de la {@link Rangee}.
     * @param vol correspond au à la place de l'on souhaite gagner dans l'{@link Entrepot} (grâce à la supression du/des {@link LotPiece}).
     */
    public void retirerlot(Entrepot e1,int rangee,int place,int vol){
        for(int j=0;j<vol;j++) {
            e1.getLigne(rangee).getPlace(place+j).setVolume(e1.getLigne(rangee).getPlace(place+j).getVolume() -1);; //e1.ligne[rangee].place[place+j].volume--
            e1.getLigne(rangee).setPlace(place+j,null);//=null
            super.setActif(true);
        }
    }

    /**
     * Fonction qui va permettre de retirer un {@link LotPiece} de l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel l'Ouvrier travaille.
     * @param idlot correspond à l'identifiant du {@link LotPiece} à retirer.
     */
    public void retirerlot(Entrepot e1,int idlot){
        for(int i=0;i<e1.getM();i++){
            for(int j=0;j<e1.getN();j++){
                if(e1.getLigne(i).getPlace(j)!=null) {
                    if (e1.getLigne(i).getPlace(j).getId() == idlot) {
                        super.setActif(true);
                        e1.getLigne(i).getPlace(j).setVolume(e1.getLigne(i).getPlace(j).getVolume() -1); //e1.ligne[i].place[j].volume--
                        e1.getLigne(i).setPlace(j, null);//place[j]=null;
                    }
                }
            }
        }
    }

    /**
     * Fonction qui va permettre de retirer un {@link LotPiece} de l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel l'Ouvrier travaille.
     * @param nom correspond au nom du {@link LotPiece} à retirer.
     */
    public void retirerlot(Entrepot e1,String nom){
        int memid=-1;
        for(int i=0;i<e1.getM();i++){
            for(int j=0;j<e1.getN();j++){
                if(e1.getLigne(i).getPlace(j)!=null) {
                    if (e1.getLigne(i).getPlace(j).getPiece().getNom().equals(nom)) {

                        if(memid==-1) {
                            super.setActif(true);
                            memid=e1.getLigne(i).getPlace(j).getId();
                            e1.getLigne(i).getPlace(j).setVolume(e1.getLigne(i).getPlace(j).getVolume() -1); //e1.ligne[i].place[j].volume--;
                            e1.getLigne(i).setPlace(j, null);
                        }
                        else if(memid==e1.getLigne(i).getPlace(j).getId()){
                            super.setActif(true);
                            e1.getLigne(i).getPlace(j).setVolume(e1.getLigne(i).getPlace(j).getVolume() -1); //e1.ligne[i].place[j].volume--
                            e1.getLigne(i).setPlace(j, null);//place[j] = null;
                        }
                    }
                }
            }
        }

    }

    /**
     * Fonction qui permet de déplacer {@link LotPiece}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel l'Ouvrier travaille.
     * @param idlot correspond à l'identifiant du {@link LotPiece} à déplacer.
     * @param rangee1 correspond à l'emplacement initial du {@link LotPiece}.
     * @param rangee2 correspond à l'emplacement final du {@link LotPiece}.
     * @return 1 si le {@link LotPiece} a été déplacé et -1 pour le contraire.
     */
    public int deplacerlot(Entrepot e1, int idlot, int rangee1, int rangee2) {
        int vol=-1;
        int verifpossible=0;

        int res=-1;
        LotPiece lotdep = null;

        for(int i2 =0; i2<e1.getN(); i2++) {
            if(e1.getLigne(rangee1).getPlace(i2)!=null) {
                if(e1.getLigne(rangee1).getPlace(i2).getId()==idlot) {
                    vol=e1.getLigne(rangee1).getPlace(i2).getVolume();
                    lotdep=e1.getLigne(rangee1).getPlace(i2);
                    //e1.ligne[rangee1].place[i]=null;
                }
            }
        }

        int a2=0;
        for(int j2 = 0; j2<e1.getN() ; j2++) {
            if(e1.getLigne(rangee2).getPlace(j2)== null  || (a2!=0 &&e1.getLigne(rangee2).getPlace(j2).getId()==idlot)) {
                a2++;
            }
            else {
                a2=0;
            }
            if(a2==vol) {
                verifpossible=1;
            }
        }
        if(verifpossible==1){
            for(int i=0;i<e1.getN();i++){
                if(e1.getLigne(rangee1).getPlace(i)!=null){
                    if(e1.getLigne(rangee1).getPlace(i).getId()==idlot){ //e1.ligne[rangee1].place[i].id==idlot
                        vol=e1.getLigne(rangee1).getPlace(i).getVolume();
                        lotdep=e1.getLigne(rangee1).getPlace(i);
                        e1.getLigne(rangee1).setPlace(i, null);}//ligne[rangee1].place[i]=null;}
                }
            }

            int a=0;
            for(int j=0;j<e1.getN();j++){
                if(e1.getLigne(rangee2).getPlace(j)==null){
                    a++;
                }
                else{
                    a=0;
                }
                if(a==vol){
                    for(int k=0;k<a;k++){
                        e1.getLigne(rangee2).setPlace(j-k,lotdep);
                    }
                    super.setActif(true);
                    res=1;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Fonction qui permet d'ajouter un {@link LotPiece} dans l' Entrepot.
     * @param lot correspond au {@link LotPiece} à ajouter dans l' Entrepot.
     * @param e1 correspond à l'{@link Entrepot} dans lequel l'Ouvrier travaille.
     * @return 1 si le {@link LotPiece} a été ajouté et -1 pour le contraire.
     */
    public int ajouterlot(LotPiece lot,Entrepot e1){
        int a;
        int res = -1;
        recherche:
        for(int i=0;i<e1.getM();i++){
            if(e1.getLigne(i).getTaille_restante()>=lot.getVolume()){
                a=0;
                for(int j=0;j<e1.getN();j++){
                    if(e1.getLigne(i).getPlace(j)==null){
                        a++;
                    }
                    else{
                        a=0;
                    }
                    if(a==lot.getVolume()){
                        for(int k=0;k<a;k++){
                            e1.getLigne(i).setPlace(j-k, lot);//ligne[i].place[j-k]=lot;
                            e1.getLigne(i).setTaille_restante(e1.getLigne(i).getTaille_restante() -1); //taille_restante--;
                        }
                        super.setActif(true);
                        res = 1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }


    /**
     * Fonction qui rend actif le Chefbrico et instancie la durée de construction du {@link Meuble} à construire par le Chefbrico.
     * @param m correspond au {@link Meuble} à monter.
     */


    /**
     * Fonction qui return la spécialité de la Personne (Correspond à la Piece du type de meuble que l'Ouvrier est capable de construire). (Getter)
     * @return return la spécialité de l'Ouvrier.
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * Fonction qui permet de modifier la spécialité d'un Ouvrier. (Setter)
     * @param specialite correspond à la spécialité de l'Ouvrier.
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * Fonction qui return les pas restant. (Getter)
     * @return correspond à la durée restant pour la construction d'un meuble.
     */
    public int getPas_restantmeuble() {
        return pas_restantmeuble;
    }

    /**
     * Fonction qui permet de modifier les pas restant. (Setter).
     * @param pas_restantmeuble correspond au pas restant (durrée restante pour la construction d'un meuble).
     */
    public void setPas_restantmeuble(int pas_restantmeuble) {
        this.pas_restantmeuble = pas_restantmeuble;
    }

    /**
     * Fonction qui rend actif l'Ouvrier et instancie la durée de construction du {@link Meuble} à construire par l'Ouvrier.
     * @param m correspond au {@link Meuble} qui doit être construit par l'Ouvrier.
     */
    public void monterMeuble(Meuble m){
        super.setActif(true);
        pas_restantmeuble=m.getDuree();
    }



}

