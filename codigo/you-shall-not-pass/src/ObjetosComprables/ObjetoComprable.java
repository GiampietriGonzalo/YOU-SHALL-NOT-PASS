package ObjetosComprables;

import Interacciones.Visitor;
import Logica.GameObject;

public abstract class ObjetoComprable extends GameObject{
	
	protected int precio;
	
	
	public int getPrecio(){return precio;}
	
	public void accept(Visitor v) {}

	
	public void actualizar(){}
	

}


