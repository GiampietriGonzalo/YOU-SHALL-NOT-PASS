package Entidad;

import Interacciones.*;
import Logica.GameObject;
import Logica.Juego;

abstract public class Premio extends GameObject{
	
	protected VisitorPremio miVisitor;
	
	public Premio(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
}
