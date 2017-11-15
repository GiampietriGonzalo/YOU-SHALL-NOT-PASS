package ObjetosComprables;

import Personajes.*;
public class CoronaReyAragorn extends ObjetoComprable{
	
	public CoronaReyAragorn(){
		tiempo = 10;
	}

	public void actualizar(){
		tiempo--;
	}
	
	public void efecto(Aliado a){
		a.setEstado(new Potenciado(a));
		a.getEstado().potenciar((Humano) a);
	}
	
}
