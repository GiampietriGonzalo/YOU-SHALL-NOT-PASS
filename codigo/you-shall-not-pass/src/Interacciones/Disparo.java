package Interacciones;

import Logica.GameObject;
import Logica.Juego;

abstract public class Disparo extends GameObject implements Runnable {
	
	protected static final int velocidad=25;
	protected Juego juego;
	
	public Disparo(Juego j,int x, int y) {
		juego=j;
		this.x=x;
		this.y=y;
	}
	
	public void efecto(){}
	abstract public void avanzar();
	
	abstract public void accept(Visitor v);
	
	public void actualizar(){
	}
	
}
