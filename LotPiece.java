package projet;
import java.util.ArrayList;

public class LotPiece{
	 ArrayList<Piece> liste = new ArrayList<>();
	int id;
    int volume;
    int prix;
    static int i = 1;

    public LotPiece(int volume){
        this.volume = volume; 
        this.id=i;
        i++;
    }
    
    public void addPiece(String nom, double poids, double prix) {
        if(liste.size()>=volume){return;}
    	Piece p = new Piece(nom, poids, prix);
    	p.nom = nom;
    	p.poids = poids; 
    	p.prix = prix;
    	if(liste.size()==0 || liste.get(0).nom==nom) {
            liste.add(p);
        }
    }
     
    public String toString() {
    	String informations = "";
    	for(int i = 0; i<liste.size(); i++) {
    		informations += "{ "+ liste.get(i).toString() + "} \n" ;
    	}
    	return " { ID du lot : "+ this.id +" | Volume : " + this.volume + " } \n" + " Liste des pièces : \n"+ informations;
    }
    
    
    
    public class Piece{
         String nom;
        private double poids;
        private double prix;
        
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
