package Entidad;

import Interacciones.*;
import Logica.GameObject;
import Logica.Juego;


abstract public class Premio extends GameObject{
	
	protected Juego j;
	
	public Premio(Juego j){
		this.j=j;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}

	public void actualizar(){
		tiempo--;
		if(tiempo==0) morir();
	}
}
