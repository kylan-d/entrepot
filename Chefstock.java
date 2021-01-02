package projet;

/**
 * Un Chefstock est une {@link Personne} qui a sous ses ordres des {@link Ouvrier}. Le Chefbrico s'occupe de la gestion des {@link LotPiece} (ajout, supression ou déplacement).
 * @author Abdesamad - Kylan
 * @version 1.0
 */
public class Chefstock extends Chef{
    /**
     * Constructeur de la classe Chefstock.
     * @param nom correspond au nom du Chefstock.
     * @param prenom correspond au prénom du Chefstock.
     */
    public Chefstock(String nom, String prenom) {
        super(nom,prenom,"Chefstock",0,false);
    }

    /**
     * Fonction qui permet de retirer un {@link LotPiece} de l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel le Chefstock va effectuer ses tâches.
     * @param rangee correspond à une {@link Rangee} de l'{@link Entrepot}.
     * @param place corresond à un emplacement de la {@link Rangee} de l'{@link Entrepot}.
     * @param vol correspond à la place, au volume que l'on veut rajouter dans l'{@link Entrepot} (grâce à la supression de certains {@link LotPiece}).
     */
    public void retirerlot(Entrepot e1, int rangee, int place, int vol) {
        for(int i = 0; i<vol; i++) {
            e1.getLigne(rangee).getPlace(place+i).setVolume(e1.getLigne(rangee).getPlace(place+i).getVolume()-1); //e1.ligne[rangee].place[place+i].volume--
            e1.getLigne(rangee).setPlace(place+i, null); //e1.ligne[rangee].place[place+i]=null;
            super.setActif(true);
        }
    }


    /**
     * Fonction qui permet de retirer un {@link LotPiece} de l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel le Chefstock va effectuer ses tâches.
     * @param idlot correspond à l'identifiant du {@link LotPiece} à retirer de l'{@link Entrepot}.
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
     * Fonction qui permet de retirer un {@link LotPiece} de l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel le Chefstock va effectuer ses tâches.
     * @param nom correspond au nom du {@link LotPiece} à retirer de l'{@link Entrepot}.
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
                            e1.getLigne(i).getPlace(j).setVolume(e1.getLigne(i).getPlace(j).getVolume() -1); //e1.ligne[i].place[j].volume--
                            e1.getLigne(i).setPlace(j, null);//place[j] = null;
                        }
                        else if(memid==e1.getLigne(i).getPlace(j).getId()){
                            super.setActif(true);
                            e1.getLigne(i).getPlace(j).setVolume(e1.getLigne(i).getPlace(j).getVolume() -1); //e1.ligne[i].place[j].volume--
                            e1.getLigne(i).setPlace(j,null);//place[j] = null;
                        }
                    }
                }
            }
        }

    }

    /**
     * Fonction qui permet de déplacer un {@link LotPiece}.
     * @param e1 correspond à l'{Entrepot} dans lequel le Chefstock va effectuer ses tâches.
     * @param idlot correspond à l'identifiant du {@link LotPiece} à déplacer.
     * @param rangee1 correspond à la place initial du {@link LotPiece}.
     * @param rangee2 correspond à la place final du {@link LotPiece} (l'endroit dans lequel on souhaite déplacer le {@link LotPiece}).
     * @return return 1 si le {@link LotPiece} a été déplacé et -1 si c'est un echec.
     */
    public int deplacerlot(Entrepot e1, int idlot, int rangee1, int rangee2) {
        int vol=-1;
        int verifpossible=0;

        int res=-1;
        LotPiece lotdep = null;

        for(int i2 =0; i2<e1.getN(); i2++) {
            if(e1.getLigne(rangee1).getPlace(i2)!=null) { //ligne[rangee1].place[i2]
                if(e1.getLigne(rangee1).getPlace(i2).getId()==idlot) { //ligne[rangee1].place[i2]
                    vol=e1.getLigne(rangee1).getPlace(i2).getVolume(); //e1.ligne[rangee1].place[i2].volume | //ligne[rangee1].place[i2]
                    lotdep=e1.getLigne(rangee1).getPlace(i2); //ligne[rangee1].place[i2]
                    //e1.ligne[rangee1].place[i]=null;
                }
            }
        }

        int a2=0;
        for(int j2 = 0; j2<e1.getN() ; j2++) {
            if(e1.getLigne(rangee2).getPlace(j2)== null || (a2!=0 &&e1.getLigne(rangee2).getPlace(j2).getId()==idlot)) { //e1.ligne[rangee2].place[j2]== null || (a2!=0 &&e1.ligne[rangee2].place[j2].getId()==idlot)
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
                if(e1.getLigne(rangee1).getPlace(i)!=null){ //ligne[rangee1].place[i]!=null
                    if(e1.getLigne(rangee1).getPlace(i).getId()==idlot){ //ligne[rangee1].place[i]
                        vol=e1.getLigne(rangee1).getPlace(i).getVolume(); //ligne[rangee1].place[i]
                        lotdep=e1.getLigne(rangee1).getPlace(i); //ligne[rangee1].place[i]
                        e1.getLigne(rangee1).setPlace(i, null);
                    }//ligne[rangee1].place[i]
                }
            }

            int a=0;
            for(int j=0;j<e1.getN();j++){
                if(e1.getLigne(rangee2).getPlace(j)==null){ //ligne[rangee2].place[j]
                    a++;
                }
                else{
                    a=0;
                }
                if(a==vol){
                    for(int k=0;k<a;k++){
                        e1.getLigne(rangee2).setPlace(j-k, lotdep); //ligne[rangee2].place[j-k]=lotdep;
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
     * Fonction qui permet d'ajouter un {@link LotPiece}.
     * @param lot correspond au {@link LotPiece} à ajouter dans l'{@link Entrepot}.
     * @param e1 correspond à l'{@link Entrepot} dans lequel le Chefstock effectue ses tâches.
     * @return 1 si le {@link LotPiece} a bien été ajouté, et -1 si c'est un echec.
     */
    public int ajouterlot(LotPiece lot, Entrepot e1) {
        int a;
        int res = -1;
        recherche:
        for(int i=0; i<e1.getM(); i++) {
            if(e1.getLigne(i).getTaille_restante()>=lot.getVolume()) {
                a=0;
                for(int j=0; j<e1.getN();j++) {
                    if(e1.getLigne(i).getPlace(j)==null) {
                        a++;
                    }
                    else {
                        a=0;
                    }
                    if(a==lot.getVolume()) {
                        for(int k=0;k<a;k++) {
                            e1.getLigne(i).setPlace(j-k, lot);//.place[j-k]=lot;
                            e1.getLigne(i).setTaille_restante(e1.getLigne(i).getTaille_restante() -1); //taille_restante--
                        }
                        super.setActif(true);
                        res =  1;
                        break recherche;
                    }
                }
            }
        }
        return res;
    }













}
