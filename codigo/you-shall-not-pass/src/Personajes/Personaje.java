package Personajes;

import Logica.GameObject;

public abstract class Personaje extends GameObject {

	protected int vida;
	protected int rango;
	protected int daño;
	
	public Personaje(int x, int y){
		super(x,y);
	}
	
	public int getVida(){
		return vida;
	}
	
	public int getRango(){
		return rango;
	}
	
	public int getDaño(){
		return daño;
	}
	
	public void atacar(){
		//rellenar cuando se me ocurra algo
	}
	
	public void recibirDaño(int d){
		vida-=d;
		if(vida==0) morir();
	}
	
}
