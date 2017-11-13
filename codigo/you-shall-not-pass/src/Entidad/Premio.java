package Entidad;

import Interacciones.*;
import Logica.GameObject;
import Logica.Juego;

abstract public class Premio extends GameObject{
	
	protected Juego miJuego;
	
	public Premio(Juego j){
		miJuego=j;
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}

	public void actualizar(){
		tiempo++;
		if(tiempo==10) morir();
	}
}
