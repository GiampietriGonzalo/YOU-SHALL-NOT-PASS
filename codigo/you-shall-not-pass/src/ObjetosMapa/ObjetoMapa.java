package ObjetosMapa;

import Interacciones.Visitor;
import Logica.GameObject;

public abstract class ObjetoMapa extends GameObject{

	public void efecto() {
		//Que tal señores, nada de nada
	}
	
	public ObjetoMapa(){
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
