import java.util.*;

public class JeuOie extends Jeu{

    public JeuOie(int nbJ){
	super.plateau= new PlateauOie(nbJ);
	super.jeuFini=false;
    }

    public void jouerTour(){
	for(Joueur J : super.plateau.getJoueurs())
	    if(!this.jeuFini)
		jouerTourJoueur((JoueurOie)J);
    }

    public void jouerTourJoueur(JoueurOie J){
	if(J.peutJouer()){
	    int de=Joueur.lancerDes();
	    int de2=Joueur.lancerDes();
	    de+=de2;
	    int posArrive=0;

	    if(J.getPion().getP()==0 && de==9){
		if(de2==4 || de2==5)
		    posArrive=53;
		if(de2==3 || de2==6)
		    posArrive=26;
	    }
	    else{
		posArrive=J.getPion().getP()+de;


	    if(posArrive%9==0 && posArrive!=63)
		posArrive+=de;
	    
	    if(posArrive==6)
		posArrive=12;
	    else if(posArrive==19 || posArrive==31 || posArrive==52){
		J.nePourraPasJouer();
		if (!(this.plateau.getCase(30).estVide()) && posArrive==31){
		    ListIterator<Joueur> it=this.plateau.getCase(30).joueur.listIterator();
		    while(it.hasNext()){
			JoueurOie Jo=(JoueurOie)(it.next());
			Jo.pourraJouer();
		    }
		}
		if (!(this.plateau.getCase(51).estVide()) && posArrive==52){
		    ListIterator<Joueur> it=this.plateau.getCase(51).joueur.listIterator();
		    while(it.hasNext()){
			JoueurOie Jo=(JoueurOie)(it.next());
			Jo.pourraJouer();
		    }
		}
	    }
	    else if(posArrive==42)
		posArrive=37;
	    else if(posArrive==58)
		posArrive=0;
	    }
	    this.plateau.deplacement(J,J.getPion().getP(),posArrive);
	    if(J.getPion().getP()==63)
		this.jeuFini=true;
	}
	else if(J.getPion().getP()==19)
	    J.pourraJouer();
	
    }

    public void afficherJeu(){
	System.out.println("jeu fini: "+this.jeuFini);
	for(Joueur J : super.plateau.getJoueurs()){
	    String s= ( (JoueurOie)J).toString();
	    s= s+ " : " + ((JoueurOie)J).getPion().getP();
	    System.out.println(s);
	}
	System.out.println("");
    }

}
