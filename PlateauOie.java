public class PlateauOie extends Plateau{

    public PlateauOie(int nbJ){
	super.plateau= new Case[63];
	super.joueurs=new JoueurOie[nbJ];
	super.longueur=63;
	for (int i=0;i<63;i++){
	    Case c=new Case(i+1);
	    super.plateau[i]=c;
	    
	}
	for(int i=0;i<nbJ;i++){
	    JoueurOie j= new JoueurOie(i+1);
	    super.joueurs[i]=j;
	}
    }

    public void deplacement(Joueur j, int depart, int arrive){
	JoueurOie jo=(JoueurOie)j;
	if(depart!=0)
	    this.viderCase(depart-1,jo);
	//	System.out.println("test");
	if(arrive<63){
	    //System.out.println(""+arrive);
	    if(arrive>0)
		this.remplirCase(arrive-1,jo);
	    jo.getPion().setP(arrive);
	}
	else{
	    this.remplirCase(62,jo);
	    jo.getPion().setP(63);
	}
    }

}
