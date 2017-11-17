package ObjetosComprables;

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


}



