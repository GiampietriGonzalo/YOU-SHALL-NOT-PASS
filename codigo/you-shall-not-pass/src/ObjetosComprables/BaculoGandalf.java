package ObjetosComprables;

import Personajes.*;

public class BaculoGandalf extends ObjetoComprable{
	
	public BaculoGandalf(){
		tiempo = 5;
	}
	
	public void actualizar(){
		tiempo--;
	}

	
	public void efecto(Aliado a){
		a.setEstado(new Potenciado(a));
		a.getEstado().potenciar((Mago) a);
	}

}
