package Personajes;

import Interacciones.*;
import Logica.GameObject;

public abstract class Aliado extends Personaje {
	protected int precioAliado;
	
	public Aliado(){
		miVisitor=new VisitorAliado(damage);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	
	
}
