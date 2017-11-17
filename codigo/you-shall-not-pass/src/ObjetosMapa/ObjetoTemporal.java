package ObjetosMapa;

import Interacciones.Visitor;

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
