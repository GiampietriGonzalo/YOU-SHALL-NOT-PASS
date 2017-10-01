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
	
	public int getPuntos(){
		return puntos;
	}
	
	public void morir(){
		super.morir();
		juego.sumarMonedas(monedas);
		juego.sumarPuntos(puntos);
	}
	
	public void mover(){
		juego.getMapa().eliminarPersonaje(this,x, y);
		posX+=velocidad;
		x=posX/64;
		juego.getMapa().agregarPersonaje(this, x, y);
		this.grafico.setBounds(posX,posY, 64, 64);
		if(x==7) morir();
	}
}
