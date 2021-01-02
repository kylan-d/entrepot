package projet;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EntrepotTest {
    private static Entrepot EntrepotUnderTest;
    @BeforeEach
    public void setUpTests(){
        EntrepotUnderTest=new Entrepot(100,100,10000);

    }
    @AfterEach
    public void restorAfterTests(){
        EntrepotUnderTest=null;
        LotPiece.setI(1);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0,1,2,3,4 })
    void recruterouvirer_taille(int ntab){
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        int a=EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        int b=EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        int c=EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        int d=EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        int e=EntrepotUnderTest.recruterouvrier("paulim", "jacquier", "salle");
        int recac[]={a,b,c,d,e};
        int recex[]={1,1,1,1,-1};
        assertEquals(recex[ntab],recac[ntab]);
    }

    @Test
    void licencierouvirer_actif(){
        EntrepotUnderTest.recruterchefbrico("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.ajoutlot(new LotPiece(1,"ee",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50,"ef",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100,"eg",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100,"eg",5,1));
        EntrepotUnderTest.licencierOuvrier();
        assertEquals(5,EntrepotUnderTest.compteactif()+EntrepotUnderTest.compteinactif());
    }

    @Test
    void licencierchef_equipepleine(){
        EntrepotUnderTest.recruterchefbrico("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterchefstock("paulain", "jacquassj");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquottt", "toilette");
        EntrepotUnderTest.licencierOuvrier("cuisine");
        EntrepotUnderTest.licencierChefbrico();
        assertEquals(5,EntrepotUnderTest.compteactif()+EntrepotUnderTest.compteinactif());
    }

    @Test
    void payer_verif(){
        EntrepotUnderTest.recruterchefbrico("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterchefstock("paulain", "jacquassj");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquottt", "toilette");
        EntrepotUnderTest.licencierOuvrier("cuisine");
        EntrepotUnderTest.licencierChefbrico();
        EntrepotUnderTest.payer();
        assertEquals(30,10000-EntrepotUnderTest.getTresorerie());
    }

    @ParameterizedTest()
    @CsvSource({ "ee,true", "ef,true", "eg,true","eh,false","ei,false" })
    void lotajoute_estcontenu(String arg,boolean ajout){
        EntrepotUnderTest.recruterchefbrico("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefbrico("pauli", "jacquie");
        EntrepotUnderTest.recruterchefbrico("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterouvrier("paulim", "jacquier", "salle");
        EntrepotUnderTest.ajoutlot(new LotPiece(1,"ee",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50,"ef",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100,"eg",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(101,"eh",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(0,"ei",5,1));

        boolean res=false;
        int volt=0;
        for(int i=0;i<EntrepotUnderTest.getM();i++){
            for(int j=0;j<EntrepotUnderTest.getN();j++){
                if(EntrepotUnderTest.getLigne(i).getPlace(j)!=null){
                    if(EntrepotUnderTest.getLigne(i).getPlace(j).getPiece().getNom().equals(arg)){
                        volt++;
                        res=true;
                    }
                }
            }
        }
        assertEquals(ajout,res);
    }
    @ParameterizedTest()
    @CsvSource({ "ee,1", "ef,50", "eg,100","eh,0","ei,0" })
    void lotajoute_volume(String arg,int vol){
        EntrepotUnderTest.recruterchefbrico("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefbrico("pauli", "jacquie");
        EntrepotUnderTest.recruterchefbrico("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterouvrier("paulim", "jacquier", "salle");
        EntrepotUnderTest.ajoutlot(new LotPiece(1,"ee",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50,"ef",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100,"eg",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(101,"eh",5,1));
        EntrepotUnderTest.ajoutlot(new LotPiece(0,"ei",5,1));

        boolean res=false;
        int volt=0;
        for(int i=0;i<EntrepotUnderTest.getM();i++){
            for(int j=0;j<EntrepotUnderTest.getN();j++){
                if(EntrepotUnderTest.getLigne(i).getPlace(j)!=null){
                    if(EntrepotUnderTest.getLigne(i).getPlace(j).getPiece().getNom().equals(arg)){
                        volt++;
                        res=true;
                    }
                }
            }
        }
        assertEquals(vol,volt);
    }
    @ParameterizedTest()
    @CsvSource({ "ee,true", "ef,true", "eg,true","ew,true","e,true" })
    void retirerlot_estretirer(String arg,boolean retir) {
        EntrepotUnderTest.recruterchefbrico("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefbrico("pauli", "jacquie");
        EntrepotUnderTest.recruterchefbrico("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterouvrier("paulim", "jacquier", "salle");
        EntrepotUnderTest.ajoutlot(new LotPiece(1, "ee", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "ef", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100, "eg", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(101, "eh", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(0, "ei", 5, 1));
        System.out.println(EntrepotUnderTest.compteactif());
        int tes=EntrepotUnderTest.retirerlot(arg);
        boolean res=true;
        if(tes==-1){res=false;}
        System.out.println(EntrepotUnderTest.compteactif());
        for(int i=0;i<EntrepotUnderTest.getM();i++) {
            for (int j = 0; j < EntrepotUnderTest.getN(); j++) {
                if(EntrepotUnderTest.getLigne(i).getPlace(j)!=null) {
                    if (EntrepotUnderTest.getLigne(i).getPlace(j).getPiece().getNom().equals(arg)) {
                        res=false;
                    }
                }
            }
        }

        assertEquals(retir,res);
    }

    @ParameterizedTest()
    @CsvSource({ "ee,5", "ef,5", "eg,5","ew,4","e,4" })
    void retirerlot_activite(String arg,int actif) {
        EntrepotUnderTest.recruterchefbrico("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefbrico("pauli", "jacquie");
        EntrepotUnderTest.recruterchefbrico("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterouvrier("paulim", "jacquier", "salle");
        EntrepotUnderTest.ajoutlot(new LotPiece(1, "ee", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "ef", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100, "eg", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(101, "eh", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(0, "ei", 5, 1));
        EntrepotUnderTest.retirerlot(arg);
        int res=EntrepotUnderTest.compteactif();


        assertEquals(actif,res);
    }

    @Test
    void deplacerlot_riendeperdu() {
        EntrepotUnderTest.recruterchefbrico("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefbrico("pauli", "jacquie");
        EntrepotUnderTest.recruterchefbrico("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterouvrier("paulie", "jacquiez", "cuisine");
        EntrepotUnderTest.recruterouvrier("pauler", "jacquese", "salledebain");
        EntrepotUnderTest.recruterouvrier("pauloj", "jacquott", "toilette");
        EntrepotUnderTest.recruterouvrier("paulak", "jacquassd", "salleamanger");
        EntrepotUnderTest.recruterouvrier("paulim", "jacquier", "salle");
        EntrepotUnderTest.ajoutlot(new LotPiece(1, "ee", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "ef", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eg", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(49, "eh", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100, "eg", 5, 1));
        EntrepotUnderTest.retirerlot("ee");
        EntrepotUnderTest.deplacerlot(0,0,2);
        EntrepotUnderTest.deplacerlot(0,1,3);
        EntrepotUnderTest.deplacerlot(0,1,4);
        EntrepotUnderTest.deplacerlot(0,1,5);
        int volrest=0;
        for(int i=0;i<EntrepotUnderTest.getM();i++) {
            for (int j = 0; j < EntrepotUnderTest.getN(); j++) {
                if (EntrepotUnderTest.getLigne(i).getPlace(j) != null) {
                    volrest++;
                }
            }
        }
        assertEquals(249,volrest);
    }
    @Test
    void deplacerlot_activite() {
        EntrepotUnderTest.recruterchefstock("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefstock("pauli", "jacquie");
        EntrepotUnderTest.recruterchefstock("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterchefstock("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefstock("pauli", "jacquie");
        EntrepotUnderTest.recruterchefstock("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.ajoutlot(new LotPiece(1, "ee", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "ef", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eg", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eh", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100, "eg", 5, 1));
        EntrepotUnderTest.retirerlot(1);
        EntrepotUnderTest.deplacerlot(0,0,2);
        EntrepotUnderTest.deplacerlot(1,0,3);
        EntrepotUnderTest.deplacerlot(2,0,2);
        EntrepotUnderTest.deplacerlot(2,0,5);
        EntrepotUnderTest.deplacerlot(1,1,4);
        int res=EntrepotUnderTest.compteactif();
        assertEquals(9,res);
    }
    @Test
    void deplacerlot_biendep() {
        EntrepotUnderTest.recruterchefstock("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefstock("pauli", "jacquie");
        EntrepotUnderTest.recruterchefstock("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterchefstock("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefstock("pauli", "jacquie");
        EntrepotUnderTest.recruterchefstock("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.ajoutlot(new LotPiece(1, "ee", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "ef", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eg", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eh", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100, "eg", 5, 1));
        EntrepotUnderTest.retirerlot(1);
        EntrepotUnderTest.deplacerlot(0,0,2);
        EntrepotUnderTest.deplacerlot(1,0,3);
        EntrepotUnderTest.deplacerlot(2,0,2);
        EntrepotUnderTest.deplacerlot(2,0,5);
        EntrepotUnderTest.deplacerlot(1,1,4);

        int volrest=0;

        for (int j = 0; j < EntrepotUnderTest.getN(); j++) {
            if (EntrepotUnderTest.getLigne(0).getPlace(j) != null) {
                volrest++;
            }
        }
        assertEquals(100,volrest);
    }

    @ParameterizedTest
    @CsvSource({ "ee,true", "e,false" })
    void montermeuble_complet(String piece,boolean expected){
        EntrepotUnderTest.recruterchefbrico("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefstock("pauli", "jacquie");
        EntrepotUnderTest.recruterchefstock("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.recruterchefstock("paul", "jacques");
        EntrepotUnderTest.recruterchefstock("paulo", "jacquot");
        EntrepotUnderTest.recruterchefstock("paula", "jacquass");
        EntrepotUnderTest.recruterchefstock("pauli", "jacquie");
        EntrepotUnderTest.recruterchefstock("pauly", "jacquesi");
        EntrepotUnderTest.recruterchefstock("paulou", "jacquotu");
        EntrepotUnderTest.recruterchefstock("paulai", "jacquassj");
        EntrepotUnderTest.ajoutlot(new LotPiece(1, piece, 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "ef", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eg", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(50, "eh", 5, 1));
        EntrepotUnderTest.ajoutlot(new LotPiece(100, "ei", 5, 1));
        Meuble a= new Meuble("lit","chambre",5);
        a.addcompo(new Paire(1,"ee"));
        a.addcompo(new Paire(50,"ef"));
        a.addcompo(new Paire(50,"eg"));
        a.addcompo(new Paire(50,"eh"));
        a.addcompo(new Paire(100,"ei"));
        EntrepotUnderTest.montermeuble(a);
        int volrest=0;
        for(int i=0;i<EntrepotUnderTest.getM();i++) {
            for (int j = 0; j < EntrepotUnderTest.getN(); j++) {
                if (EntrepotUnderTest.getLigne(i).getPlace(j) != null) {
                    volrest++;
                }
            }
        }
        boolean act=false;
        System.out.println(EntrepotUnderTest.getTresorerie());
        if(volrest==0 && EntrepotUnderTest.getTresorerie()==10251){
            act=true;
        }
        assertEquals(expected,act);
    }
}
