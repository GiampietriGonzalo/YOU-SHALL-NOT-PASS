package ObjetosComprables;

import Interacciones.Visitor;
import Personajes.*;

public class HachaGimli extends ComprableConVida{
	
	public HachaGimli(int v){
		super(v);
	}
	
	public void actualizar(){
	
	}
	
	public void efecto(Aliado a){
		a.setEstado(new Potenciado(a));
		a.getEstado().potenciar((Enano) a);
	}



	public void efecto() {}

	public void accept(Visitor v){
		v.visit(this);}
}



