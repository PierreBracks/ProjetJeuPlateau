public abstract class Jeu{
    protected Plateau plateau;
    protected boolean jeuFini;

    public abstract void jouerTour();


    public boolean estFini(){
	return this.jeuFini;
    }

    public abstract void afficherJeu();
}
