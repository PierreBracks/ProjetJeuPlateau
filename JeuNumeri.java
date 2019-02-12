import java.util.*;

public class JeuNumeri extends Jeu{

    public JeuNumeri(int nbJ){
	plateau= new PlateauNumeri(nbJ);
	jeuFini=false;
    }
    public void jouerTour(){
	for(Joueur J : plateau.getJoueurs())
	    if(!jeuFini)
		jouerTourJoueur((JoueurNumeri)J);
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

	if(J.peutRejouer())
	    jouerTourJoueur(J);
    }


    public LinkedList<Pion> choisirPion(int de, JoueurNumeri J){
	System.out.println("valeur du de: "+de);
	int tot=0;
	LinkedList<Pion> pion=new LinkedList<Pion>();
	while(tot<de){
	    System.out.print(J+", quel pion prenez vous ?(total actuel: "+tot+")");
	    Scanner sc= new Scanner(System.in);
	    String rep=sc.nextLine();
	    if(rep.equals("exit"))
		System.exit(0);
	    if(isParsable(rep)){
		int i=Integer.parseInt(rep);
		if(i+tot<=de && i>0){
		    if(!pion.contains(J.getPion(i-1)));{
			pion.add(J.getPion(i-1));
			tot+=i;
		    }
		}
	    }
	}
	return pion;
    }
    
    public void afficherJeu(){
	System.out.println("jeu fini: "+jeuFini);
	for(Joueur J: plateau.getJoueurs()){
	    String s=((JoueurNumeri)J).toString()+" :";
	    for(int i=0;i<6;i++){
		s+= "pion"+(i+1)+": "+ ((JoueurNumeri)J).getPion(i).getP()+", ";
	    }
	    System.out.println(s);
	}
        System.out.println("");
    }


    public static boolean isParsable(String input){
	boolean parsable = true;
	try{
	    Integer.parseInt(input);
	}catch(NumberFormatException e){
	    parsable = false;
	}
	return parsable;
    }
}
