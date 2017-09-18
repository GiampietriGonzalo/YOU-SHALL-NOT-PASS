package Logica;

import java.awt.Point;

import GUI.GUI;
import Mapa.Mapa;
import Personajes.Aliado;
import Personajes.Enemigo;
import Personajes.Personaje;

public class Juego {
	
	private int vidaJugador;
	private int puntosJuego;
	private int monedasJuego;
	private Enemigo enemigos[];
	private Aliado aliados[];
	private Mapa mapa;
	private int nivel;
	private GUI gui;
	
	public Juego() {
		mapa=new Mapa(10,6);
		nivel=1;
		puntosJuego=0;
		monedasJuego=50;
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
	
	public Mapa getMapa(){
		return mapa;
	}
	
	public void colocarPersonaje(Personaje j,int x, int y){
		mapa.agregarPersonaje(j,x,y);
		
	}
}