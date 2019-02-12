public class JoueurOie extends Joueur{

    private final Pion pion;
    private boolean peutJouer;

    public JoueurOie(int numJ){
	super(numJ);
	this.peutJouer=true;
	this.pion = new Pion(1);
    }

    public Pion getPion(){
	return this.pion;
    }

    public boolean peutJouer(){
	return this.peutJouer;
    }

    public void pourraJouer(){
	this.peutJouer=true;
    }

    public void nePourraPasJouer(){
	this.peutJouer=false;
    }


}
