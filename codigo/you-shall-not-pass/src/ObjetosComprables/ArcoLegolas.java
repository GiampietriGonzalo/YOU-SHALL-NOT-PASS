package ObjetosComprables;


import Logica.Juego;
import Personajes.*;

public class ArcoLegolas extends ComprableTemporal{
	
	public ArcoLegolas(Juego j){
		super(j);
		tiempo = 15;
		precio=20;
	}



	public void efecto() {
		//Aumenta el rango de cada Aliado en un 50%
		for(Aliado a:juego.getAliados())
			a.setRango(a.getRango()+(a.getRango()/2));	
	}

}

