package Interacciones;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.GameObject;
import Logica.Juego;

abstract public class Disparo extends GameObject implements Runnable {
	protected static final int velocidad=25;
	
	public Disparo(Juego j,int x, int y) {
		super(j);
		this.x=x;
		this.y=y;
	}
	
	public void mover(){

	}
	
	abstract public void accept(Visitor v);
	
	
}
