package Personajes;

import Interacciones.*;

public abstract class Aliado extends Personaje {
	protected int precioAliado;
	protected VisitorAliado miVisitor;
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getPrecioAliado(){
		return precioAliado;
	}
}
