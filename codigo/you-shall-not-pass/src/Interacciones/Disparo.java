package Interacciones;
import Logica.GameObject;
import Logica.Juego;

abstract public class Disparo extends GameObject implements Runnable {
	
	public Disparo(Juego j) {
		super(j);
	}
	
	abstract public void accept(Visitor v);
}
