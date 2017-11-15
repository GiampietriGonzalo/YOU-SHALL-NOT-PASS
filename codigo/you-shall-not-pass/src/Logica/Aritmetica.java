package Logica;

public class Aritmetica {

	protected int puntosJuego;
	protected int monedasJuego;
	
	public Aritmetica(int p, int m){
		puntosJuego=p;
		monedasJuego=m;
	}
	
	public int getPuntos(){
		return puntosJuego;
	}
	
	public int getMonedas(){
		return monedasJuego;
	}
	
	public void sumarPuntos(int p){
		puntosJuego+=p;
	}
	
	public void sumarMonedas(int m){
		monedasJuego+=m;
	}
	
	public void restarMonedas(int m){
		monedasJuego-=m;
	}
	
}
