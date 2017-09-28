package Personajes;

import Logica.Juego;

public abstract class Enemigo extends Personaje {
	
	public Enemigo(Juego j) {
		super(j);
	}
	
	protected int velocidad;
	protected int monedas;
	protected int puntos;
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public int getMonedas(){
		return monedas;
	}
	
	public int puntos(){
		return puntos;
	}
	public void mover(){
		posX+=velocidad;
		x=posX/64;
		this.grafico.setBounds(posX,posY, 64, 64);
		if(x==7) morir();
	}
}
