package Personajes;

import Logica.GameObject;
import Logica.Juego;

public abstract class Personaje extends GameObject {
	
	protected int vida;
	protected int rango;
	protected int damage;
	
	public Personaje(Juego j){
		super(j);
	}
	
	public int getVida(){
		return vida;
	}
	
	public int getRango(){
		return rango;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void atacar(){
		//rellenar cuando se me ocurra algo
	}
	
	public void recibirDamage(int d){
		vida-=d;
		if(vida<=0) morir();
	}
	
}
