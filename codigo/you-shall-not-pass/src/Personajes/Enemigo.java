package Personajes;

import Interacciones.*;
import Logica.GameObject;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int monedas;
	protected int puntos;
	
	public Enemigo(){
		miVisitor=new VisitorEnemigo(damage);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public int getMonedas(){
		return monedas;
	}
	
	
	public int getPuntos(){
		return puntos;
	}
	
}
