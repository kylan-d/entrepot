package projet;
import java.util.ArrayList;

public class LotPiece{
	Piece piece;
	int id;
    int volume;
    int prix;
    static int i = 1;

    public LotPiece(int volume,String nom,double poids,double prix){
        this.volume = volume; 
        this.id=i;
        i++;
        addPiece(nom,poids,prix);
    }
    // si dans le fichier texte ou les commandes, on recoit qu'un seul poids/prix comme dans l'exemple on creera la meme piece le nom de fois necessaire
    public void addPiece(String nom, double poids, double prix) {

    	piece = new Piece(nom, poids, prix);
    	//piece.nom = nom;
    	//piece.poids = poids;
    	//piece.prix = prix;
    }
     
    public String toString() {
    	String informations = "";
    		informations += "{type:"+piece.nom + "} \n" ;
        informations += "{poids:"+piece.poids + "} \n" ;
        informations += "{prix:"+piece.prix + "} \n" ;
    	return " { ID du lot : "+ this.id +" | Volume : " + this.volume + " } \n" + " pièce : \n"+ informations;
    }
    
    
    
    public class Piece{
         String nom;
        double poids;
        double prix;
        
        public Piece(String nom, double poids, double prix){
            this.nom = nom;
            this.poids = poids; 
            this.prix = prix; 
        }
	    public String toString() {
	    	return "Informations [ Nom : " + this.nom +
	    			" | Poids : " + this.poids + " | Prix : " + this.prix + " ]";
	    }
    }

}
