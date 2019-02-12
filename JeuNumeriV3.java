import java.util.*;

public class JeuNumeriV3 extends JeuNumeri{

    public JeuNumeriV3(int nbJ){
	super(nbJ);
    }

    public void jouerTourJoueur(JoueurNumeri J){
	int de=Joueur.lancerDes7faces();
	if (de==0){
	    System.out.println("valeur du de: 0");
	    reculerUnPion();
	    J.pourraRejouer();
	}
	else{
	    J.nePourraPasRejouer();
	    LinkedList<Pion> pions= choisirPion(de,J);
	    ListIterator<Pion> it=pions.listIterator();
	    while(it.hasNext()){
		Pion p=it.next();
		((PlateauNumeri) plateau).deplacement(J,p);
	    }

	    if(!plateau.getCase(36).estVide() && !plateau.getCase(37).estVide() && !plateau.getCase(38).estVide())
		jeuFini=true;
	}

	if(J.peutRejouer() && !this.estFini())
	    jouerTourJoueur(J);
    }

    public void reculerUnPion(){
	int n;
	while(true){
	    System.out.print("Quel pion voulez vous faire reculer ? (donner numero de case ou ecrire impossible si il n'y a pas de pion sur le plateau) ");
	    Scanner sc= new Scanner(System.in);
	    String rep=sc.nextLine();
	    if(rep.equals("exit")){
		System.out.println("Vous avez quitté Numeri.");
		System.exit(0);
	    }
	    if(rep.equals("impossible"))
		return;
	    if(isParsable(rep) ){
		n=Integer.parseInt(rep);
		if(n>0)
		    if(!this.plateau.getCase(n-1).estVide())
			break;
	    }
	}
	Joueur j=this.plateau.getCase(n-1).getFirstJoueur();
	JoueurNumeri jn=(JoueurNumeri) j;
	int idx=0;
	for(int i=0;i<6;i++)
	    if(jn.getPion(i).getP()==n)
		idx =i;
	
	int depart=jn.getPion(idx).getP();
	int arrive=jn.getPion(idx).getP()-1;
	while(!this.plateau.getCase(arrive-1).estVide()){
	    arrive--;
	    if(arrive==0)
		break;
	}
	plateau.deplacement(j,depart,arrive);
	jn.getPion(idx).setP(arrive);
    }
		
}
