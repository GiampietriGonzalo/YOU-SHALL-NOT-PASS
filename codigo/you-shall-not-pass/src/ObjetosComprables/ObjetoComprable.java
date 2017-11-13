package ObjetosComprables;
import Interacciones.Visitor;
import Logica.GameObject;

public abstract class ObjetoComprable extends GameObject{
	
	protected int precio;
	
	public int getPrecio(){return precio;}
	
	public void actualizar(){

	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
