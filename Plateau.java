public abstract class Plateau{
    
    protected Case[] plateau;
    protected Joueur[] joueurs;
    protected int longueur;

    
    public void viderCase(int i,Joueur J){
	this.plateau[i].viderCase(J);
    }

    public void remplirCase(int i,Joueur J){
	this.plateau[i].remplirCase(J);
    }

    public Case getCase(int i){
	return this.plateau[i];
    }

    public Joueur[] getJoueurs(){
	return this.joueurs;
    }

    public abstract void deplacement(Joueur j,int depart,int arrive);
	
    
    
    public void afficherPlateau(){
	for(int i=0;i<63;i++){
	    System.out.println(this.plateau[i].toString());
	}
	System.out.println("");
    }

}
