import java.util.*;

public class Joueur{
    
    private final int numJ;
    private final String nom;
 

    public Joueur(int numJ){
	this.numJ=numJ;
        this.nom="Joueur "+numJ;

    }

    public int getNumJ(){
	return this.numJ;
    }/*a faire pour les autre*/

    public String getNomJ(){
	return this.nom;
    }

    public String toString(){
	return getNomJ();
    }
    
    public static int lancerDes(){
	Random generateur= new Random();
	int de=1+generateur.nextInt(5);
	return de;
    }

    public static int lancerDes7faces(){
	Random generateur= new Random();
	int de=generateur.nextInt(6);
	return de;
    }

 

}
