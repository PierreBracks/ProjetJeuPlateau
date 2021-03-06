import java.util.*;

public class JeuNumeriV2 extends JeuNumeri{
    
    public JeuNumeriV2(int nbJ){
	super(nbJ);
    }

    public void jouerTourJoueur(JoueurNumeri J){
	int de=Joueur.lancerDes();

	LinkedList<Pion> pions= choisirPion(de,J);
	ListIterator<Pion> it=pions.listIterator();
	while(it.hasNext()){
	    Pion p=it.next();
	    ((PlateauNumeri) plateau).deplacement(J,p);
	}

	if(!plateau.getCase(36).estVide() && !plateau.getCase(37).estVide() && !plateau.getCase(38).estVide())
	    jeuFini=true;

	if(troisEnLigne(J))
	    J.pourraRejouer();
	else
	    J.nePourraPasRejouer();
	if(J.peutRejouer() && !this.estFini())
	    jouerTourJoueur(J);
    }

    public boolean troisEnLigne(JoueurNumeri J){
	for(int i=0;i<6;i++){
	    boolean droite=false;
	    boolean gauche=false;
	    for(int j=0;j<6;j++){
		if(J.getPion(j).getP()==J.getPion(i).getP()-1 && J.getPion(j).getP()>0)
		    gauche=true;
		if(J.getPion(j).getP()==J.getPion(i).getP()+1)
		    droite=true;
	    }
	    if(droite && gauche)
		return true;
	}
	return false;
    }
}
