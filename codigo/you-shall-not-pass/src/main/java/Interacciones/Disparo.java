package Interacciones;

import Logica.GameObject;
import Logica.Juego;

abstract public class Disparo extends GameObject implements Runnable {
	
	protected static final int velocidad=20;
	protected Juego j;
	protected volatile boolean execute=true;
	protected Visitor miVisitor;
	
	public Disparo(Juego j,int x, int y) {
		this.j=j;
		this.x=x;
		this.y=y;
	}
	
	public void efecto(){}
	abstract public void avanzar();
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void actualizar(){
	}
	
	public void terminate(){
		execute=false;
	}
	
}