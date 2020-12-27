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
 void lotajoute_estcontenu2(String arg,int vol){
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

}
