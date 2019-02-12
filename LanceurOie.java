import java.util.*;

public class LanceurOie{


    public static boolean isParsable(String input){
    boolean parsable = true;
    try{
        Integer.parseInt(input);
    }catch(NumberFormatException e){
        parsable = false;
    }
    return parsable;
}
    public static void lancerOie(){

	System.out.println("Bienvenue dans le jeu de l'Oie.\nTapez 'exit' a tout moment pour quitter\nCombien de joueurs souhaiter vous ?");

	Scanner sc=new Scanner(System.in);
	String rep=sc.nextLine();
	if(rep.equals("exit")){
	    System.out.println("jeu de l'Oie fermé");
	    return;
	}
	while(!isParsable(rep)){
	    System.out.println("Error:Combien de joueurs souhaiter vous ?");
	    sc= new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("exit")){
		System.out.println("jeu de l'Oie fermé");
		return;
	    }
	}
	int nbj=Integer.parseInt(rep);

	System.out.println("Quelle version voulez vous ? (1,2,3)");
	sc=new Scanner(System.in);
	rep=sc.nextLine();
	if(rep.equals("exit")){
	    System.out.println("jeu de l'Oie fermé");
	    return;
	}
	while(!isParsable(rep)){
	    System.out.println("Error :Quelle version voulez vous ? (1,2,3)");
	    sc= new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("exit")){
		System.out.println("jeu de l'Oie fermé");
		return;
	    }
	}
	int v=Integer.parseInt(rep);

	JeuOie jeu;
	if(v==1)
	    jeu=new JeuOie(nbj);
	else if(v==2)
	    jeu= new JeuOieV2(nbj);
	else if(v==3)
	    jeu= new JeuOieV3(nbj);
	else{
	    System.out.println("jeu de l'Oie fermé");
	    return;
	}

	
	jeu.afficherJeu();


        while(!jeu.estFini()){
	    
	    System.out.println("Afficher plateau ?");
	    sc= new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("oui"))
		jeu.plateau.afficherPlateau();
	    else if(rep.equals("exit"))
		break;
	    System.out.println("jouer un tour ?");
	    sc= new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("oui")){
		jeu.jouerTour();
		jeu.afficherJeu();
	    }
	    else if(rep.equals("exit"))
		break;
	    
	}
	System.out.println("jeu de l'Oie fermé");
    }
}
