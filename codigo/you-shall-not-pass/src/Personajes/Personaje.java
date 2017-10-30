package Personajes;

import Interacciones.Visitor;
import Logica.GameObject;

public abstract class Personaje extends GameObject {
	
	protected int vida;
	protected int rango;
	protected int damage;
	protected Visitor miVisitor;
	
	public int getVida(){
		return vida;
	}
	
	public int getRango(){
		return rango;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void colisionar(GameObject p){
		p.accept(miVisitor);
	}
	
	public void recibirDamage(int d){
		
		vida-=d;
		if(vida<=0) morir();
	}
	
}
