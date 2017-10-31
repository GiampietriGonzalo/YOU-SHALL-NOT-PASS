package Personajes;

import Interacciones.*;
import Logica.GameObject;

public abstract class Aliado extends Personaje {
	
	protected int precioAliado;
	
	public Aliado(int damage,int vida){
		super(damage,vida);
		miVisitor=new VisitorAliado(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	
	public void recibirDamage(int d){
		System.out.println("Soy aliado me pegaron con da�o "+d);
		vida-=d;
		if(vida<0) morir();
	}
}
