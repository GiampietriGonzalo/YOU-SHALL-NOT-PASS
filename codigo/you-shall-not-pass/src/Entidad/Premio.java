package Entidad;

import Interacciones.*;
import Logica.GameObject;

abstract public class Premio extends GameObject{
	
	protected VisitorPremio miVisitor;
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
}
