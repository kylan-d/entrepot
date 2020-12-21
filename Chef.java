package projet;

public abstract class Chef extends Personne{

    int tailleeq;
    Ouvrier liste_ouv[] = new Ouvrier[4];


    public Chef(String nom, String prenom, int tailleeq, boolean actif) {
        super(nom, prenom, actif);
        this.tailleeq = tailleeq;
        this.actif = actif;
    }

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


    public void licencier_ouvrier(int k) {
        this.liste_ouv[k] = null;
        this.tailleeq--;
    }

    public String afficherOuvrier() {
        String res = "";
        int ouvid = -1;
        for(int i = 0; i<this.liste_ouv.length; i++ ) {
            if(this.liste_ouv[i] != null && ouvid != this.liste_ouv[i].id) {
                res += " [ Ouvrier : ID : " + this.liste_ouv[i].id + " | Nom : " + this.liste_ouv[i].nom + " | Prenom : " + this.liste_ouv[i].prenom + " | Spécialité : "+ this.liste_ouv[i].specialite +" | Actif : "+ this.liste_ouv[i].actif+ " ] \n";
                ouvid = this.liste_ouv[i].id;
            }
        }
        return res;
    }



    // public abstract int ajouterlot(LotPiece lp, Entrepot e2);
    // public abstract void retirerlot(Entrepot e1,int rangee,int place);
    // public abstract void deplacerlot(Entrepot e1,int idlot,int rangee1, int rangee2);



}