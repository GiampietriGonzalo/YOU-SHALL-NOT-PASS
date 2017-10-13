package Personajes;

import Interacciones.*;
import Logica.Juego;

public abstract class Aliado extends Personaje {
	protected int precioAliado;
	protected VisitorAliado miVisitor;
	
	//Constructor
	public Aliado(Juego j) {
		super(j);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getPrecioAliado(){
		return precioAliado;
	}
}
