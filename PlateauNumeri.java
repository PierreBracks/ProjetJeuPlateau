public class PlateauNumeri extends Plateau{

    public PlateauNumeri(int nbJ){
	plateau=new Case[39];
	joueurs= new JoueurNumeri[nbJ];
	longueur=39;
	for(int i=0;i<longueur;i++){
	    Case c=new Case(0);
	    plateau[i]=c;
	}
	
	plateau[0]=new Case(-3);
	plateau[1]=new Case(-3);
	plateau[2]=new Case(-3);
	plateau[3]=new Case(-2);
	plateau[4]=new Case(-2);
	plateau[5]=new Case(-1);
	plateau[6]=new Case(-1);
	plateau[9]=new Case(1);
	plateau[12]=new Case(2);
	plateau[14]=new Case(3);
	plateau[16]=new Case(4);
	plateau[18]=new Case(5);
	plateau[19]=new Case(6);
	plateau[22]=new Case(7);
	plateau[25]=new Case(8);
	plateau[27]=new Case(9);
	plateau[28]=new Case(10);
	plateau[30]=new Case(11);
	plateau[31]=new Case(12);
	plateau[33]=new Case(13);
	plateau[34]=new Case(15);
	plateau[36]=new Case(20);
	plateau[37]=new Case(25);
	plateau[38]=new Case(30);
	
	for(int i=0;i<nbJ;i++){
	    JoueurNumeri j= new JoueurNumeri(i+1);
	    joueurs[i]=j;
	}
    }


    
    
    public void deplacement(Joueur j, int depart, int arrive){
	JoueurNumeri jn=(JoueurNumeri)j;
	if(depart!=0)
	    this.viderCase(depart-1,jn);
	if(arrive>0)
	    this.remplirCase(arrive-1,jn);
    }

    public void deplacement(JoueurNumeri j,Pion p){
	int depart=p.getP();
	int arrive=p.getP()+1;
	while(!this.getCase(arrive-1).estVide())
	    arrive++;
	p.setP(arrive);
	this.deplacement(j,depart,arrive);
    }


    public void afficherScore(){
	String s="";
	for(Joueur J: joueurs){
	    JoueurNumeri j=(JoueurNumeri)J;
	    int tot=0;
	    for(int i=0;i<6;i++)
		if(j.getPion(i).getP()!=0)
		    tot+=(this.getCase(j.getPion(i).getP()-1).getVal())*(i+1);
	    s+=j.toString()+" a "+tot+" point(s).\n";
	}
	System.out.print(s);
	
    }
}
	
