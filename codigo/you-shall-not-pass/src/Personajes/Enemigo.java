package Personajes;

import Interacciones.*;
import Logica.Juego;

public abstract class Enemigo extends Personaje {
	
	public Enemigo(Juego j) {
		super(j);
	}
	
	protected int velocidad;
	protected int monedas;
	protected int puntos;
	protected VisitorEnemigo miVisitor;
	
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
	
	public void mover(){
		
		if(juego.getMapa().getObject(x+1, y)==null){
			juego.getMapa().eliminarPersonaje(this,x, y);
			posX+=velocidad;
			x=posX/64;
			juego.getMapa().agregarPersonaje(this, x, y);
			this.grafico.setBounds(posX,posY, 64, 64);
			if(x==8) morir();
		}
		else
			this.atacar();
	}
}
