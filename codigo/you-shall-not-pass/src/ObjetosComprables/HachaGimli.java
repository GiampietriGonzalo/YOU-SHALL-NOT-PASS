package ObjetosComprables;

import Personajes.*;

public class HachaGimli extends ObjetoComprable{
	
	public HachaGimli(){
		tiempo = 8;
	}
	
	public void actualizar(){
		tiempo--;
	}
	
	public void efecto(Aliado a){
		a.setEstado(new Potenciado(a));
		a.getEstado().potenciar((Enano) a);
	}


	public void efecto() {}
}