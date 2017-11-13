package ObjetosMapa;

import Interacciones.Visitor;
import Logica.GameObject;

public abstract class ObjetoMapa extends GameObject{

	public void efecto() {/*redefinir*/}
	
	public void actualizar(){
		tiempo--;
		if(tiempo==0) morir();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
