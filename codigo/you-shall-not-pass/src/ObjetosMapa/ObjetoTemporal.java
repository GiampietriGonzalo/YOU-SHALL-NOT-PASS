package ObjetosMapa;

import Interacciones.Visitor;
import Logica.GameObject;

public abstract class ObjetoTemporal extends ObjetoMapa{

	public void efecto() {
		//Que tal señores, nada de nada
	}
	
	public ObjetoTemporal(){
		tiempo=30;
	}
	
	public void actualizar(){
		tiempo--;
		if(tiempo==0) morir();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
