public class Pion{
    private int valeur;
    private int position;

    public Pion(int val){
	this.valeur=val;
	this.position=0;
    }

    public int getV(){
	return this.valeur;
    }

    public int getP(){
	return this.position;
    }
    public void setP(int pos){
	this.position=pos;
    }
}
