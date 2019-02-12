import java.util.*;

public class LanceurNumeri{

    public static boolean isParsable(String input){
	boolean parsable = true;
	try{
	    Integer.parseInt(input);
	}catch(NumberFormatException e){
	    parsable = false;
	}
	return parsable;
    }

    
    public static void lancerNumeri(){
	
	System.out.println("Bienvenue dans le jeu Numeri.\nTapez 'exit' a tout moment pour quitter\nCombien de joueurs souhaiter vous ?");
	
	Scanner sc=new Scanner(System.in);
	String rep=sc.nextLine();
	if(rep.equals("exit"))
	    return;
	while(!isParsable(rep)){
	    System.out.println("Error:Combien de joueurs souhaiter vous ?");
	    sc= new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("exit"))
		return;
	}
	int nbj=Integer.parseInt(rep);

		System.out.println("Quelle version voulez vous ? (1,2,3)");
	sc=new Scanner(System.in);
	rep=sc.nextLine();
	if(rep.equals("exit")){
	    System.out.println("jeu Numeri fermé");
	    return;
	}
	while(!isParsable(rep)){
	    System.out.println("Error :Quelle version voulez vous ? (1,2,3)");
	    sc= new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("exit")){
		System.out.println("jeu Numeri fermé");
		return;
	    }
	}
	int v=Integer.parseInt(rep);

	JeuNumeri jeu;

	if(v==1)
	    jeu=new JeuNumeri(nbj);
	else if(v==2)
	    jeu= new JeuNumeriV2(nbj);
	else if(v==3)
	    jeu= new JeuNumeriV3(nbj);
	else{
	    System.out.println("jeu Numeri fermé");
	    return;
	}

	jeu.afficherJeu();

	while(!jeu.estFini()){
	    jeu.jouerTour();
	    jeu.afficherJeu();
	    ((PlateauNumeri) (jeu.plateau)).afficherScore();
	}
    }
}
		
