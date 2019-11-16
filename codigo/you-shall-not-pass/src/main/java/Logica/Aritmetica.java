package Logica;

/**
 * Clase respoonsable de administrar los puntos y monedas del Juego.
 * */

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
	

	
}
