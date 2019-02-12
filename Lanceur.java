import java.util.*;

public class Lanceur{
    public static void main(String[] args){
	System.out.println("Bienvenue, a quel jeu shoutaitez vous jouer ? (numeri ou oie)");
	String rep;
	while(true){
	    Scanner sc=new Scanner(System.in);
	    rep=sc.nextLine();
	    if(rep.equals("numeri") || rep.equals("oie")|| rep.equals("exit"))
		break;
	    System.out.println("a quel jeu shoutaitez vous jouer ? (numeri ou oie)");
	}
	if (rep.equals("numeri"))
	    LanceurNumeri.lancerNumeri();
	else if (rep.equals("oie"))
	    LanceurOie.lancerOie();
	else{
	    System.out.println("vous avez quitté le programme.");
	    System.exit(0);
	}

    }
}
