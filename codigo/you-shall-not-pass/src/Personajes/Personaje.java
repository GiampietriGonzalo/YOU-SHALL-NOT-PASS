package Personajes;

import Interacciones.Visitor;
import Logica.GameObject;

public abstract class Personaje extends GameObject {
	
	protected int vida;
	protected int rango;
	protected int damage;
	protected Visitor miVisitor;
	
	public Personaje(int damage,int vida){
		this.damage=damage;
		this.vida=vida;
	}
	
	public int getVida(){
		return vida;
	}
	
	public void setVida(int v){
		vida=v;
	}
	
	public abstract int getVidaOriginal();
	
	public int getRango(){
		return rango;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void colisionar(GameObject p){
		p.accept(miVisitor);
	}
	
	public void recibirDamage(int d){}
	public void efecto(){}
	
}
