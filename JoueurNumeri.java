public class JoueurNumeri extends Joueur{

    private final Pion[] pion;
    private boolean peutRejouer;

    public JoueurNumeri(int numJ){
	super(numJ);
	this.pion=new Pion[6];
	for(int i=0;i<6;i++){
	    Pion p=new Pion(i+1);
	    this.pion[i]=p;
	}
	this.peutRejouer=false;
    }

    public Pion getPion(int val){
	return this.pion[val];
    }

    public void pourraRejouer(){
	this.peutRejouer=true;
    }
    public void nePourraPasRejouer(){
	this.peutRejouer=false;
    }
    public boolean peutRejouer(){
	return peutRejouer;
    }
}
