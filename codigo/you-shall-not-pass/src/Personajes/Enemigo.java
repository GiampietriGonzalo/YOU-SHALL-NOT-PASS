package Personajes;

public abstract class Enemigo extends Personaje {
	
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
	
	
}
