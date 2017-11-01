package Entidad;

import Interacciones.*;
import Logica.GameObject;
import Logica.Juego;

abstract public class Premio extends GameObject{
	
	protected VisitorPremio miVisitor;
	protected Juego miJuego;
	
	public Premio(Juego j){
		miJuego=j;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
}
