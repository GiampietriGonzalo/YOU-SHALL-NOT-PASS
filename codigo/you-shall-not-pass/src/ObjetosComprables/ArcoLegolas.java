package ObjetosComprables;

import Personajes.*;

public class ArcoLegolas extends ObjetoComprable{
	
	public ArcoLegolas(){
		tiempo = 8;
	}

	public void actualizar(){
		tiempo--;
	}
	
	public void efecto(Aliado a){
		a.setEstado(new Potenciado(a));
		a.getEstado().potenciar((Elfo) a);
	}
}
