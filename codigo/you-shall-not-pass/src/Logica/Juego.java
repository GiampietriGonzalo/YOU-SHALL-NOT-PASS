package Logica;

import Personajes.Aliado;
import Personajes.Enemigo;

public class Juego {
	
	private int vidaJugador;
	private int puntosJuego;
	private int monedasJuego;
	private Enemigo enemigos[];
	private Aliado aliados[];
	
	public Juego() {
		// TODO Auto-generated constructor stub
	}
	
	public int getVida(){
		return vidaJugador;
	}
	public int getPuntos(){
		return puntosJuego;
	}
	public int getMonedas(){
		return monedasJuego;
	}
	
	/*  puse sumar y restar en vez de sets
	*	de poner sets habria que llamarlos de la forma setVida(jugador.getVida-V);
	*	puntos y monedas al constructor de toke
	*/
	public void sumarPuntos(int p){
		puntosJuego+=p;
	}
	
	public void sumarMonedas(int m){
		monedasJuego+=m;
	}
	
	public void restarMonedas(int m){
		monedasJuego-=m;
	}
	
	public void restarVida(int v){
		vidaJugador-=v;
	}
}