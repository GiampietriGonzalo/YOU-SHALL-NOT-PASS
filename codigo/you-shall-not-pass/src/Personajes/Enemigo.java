package Personajes;

import Logica.Juego;

public abstract class Enemigo extends Personaje {
	
	public Enemigo(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
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
		x+=32;
		if(x<500){
			this.grafico.setBounds(x,y, 64, 64);
		}
		else morir();
	}
}
