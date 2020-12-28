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

public class testEntrepot {
 private static Entrepot EntrepotUnderTest;
 @BeforeEach
 public void setUpTests(){
  EntrepotUnderTest=new Entrepot(100,100,10000);

 }
 @AfterEach
 public void restorAfterTests(){
  EntrepotUnderTest=null;
  LotPiece.i=1;
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
   for(int i=0;i<EntrepotUnderTest.m;i++){
    for(int j=0;j<EntrepotUnderTest.n;j++){
        if(EntrepotUnderTest.ligne[i].place[j]!=null){
         if(EntrepotUnderTest.ligne[i].place[j].piece.nom.equals(arg)){
          volt++;
          res=true;
         }
        }
    }
   }
  assertEquals(res,ajout);
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
  for(int i=0;i<EntrepotUnderTest.m;i++){
   for(int j=0;j<EntrepotUnderTest.n;j++){
    if(EntrepotUnderTest.ligne[i].place[j]!=null){
     if(EntrepotUnderTest.ligne[i].place[j].piece.nom.equals(arg)){
      volt++;
      res=true;
     }
    }
   }
  }
  assertEquals(volt,vol);
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
        for(int i=0;i<EntrepotUnderTest.m;i++) {
            for (int j = 0; j < EntrepotUnderTest.n; j++) {
                if(EntrepotUnderTest.ligne[i].place[j]!=null) {
                    if (EntrepotUnderTest.ligne[i].place[j].piece.nom.equals(arg)) {
                        res=false;
                    }
                }
            }
        }

        assertEquals(res,retir);
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


        assertEquals(res,actif);
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
        for(int i=0;i<EntrepotUnderTest.m;i++) {
            for (int j = 0; j < EntrepotUnderTest.n; j++) {
                if (EntrepotUnderTest.ligne[i].place[j] != null) {
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

            for (int j = 0; j < EntrepotUnderTest.n; j++) {
                if (EntrepotUnderTest.ligne[0].place[j] != null) {
                    volrest++;
                }
            }
        assertEquals(100,volrest);
    }
}
