package ObjetosMapa;

import Interacciones.Visitor;

/**
 * Clase representante de los objetos obstruyan el paso de los enemigos durante 30 segundos.
 * */

public abstract class ObjetoTemporal extends ObjetoMapa{

	public ObjetoTemporal(){
		tiempo=30;
	}
	
	public void actualizar(){
		tiempo--;
		if(tiempo==0) 
			morir();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
