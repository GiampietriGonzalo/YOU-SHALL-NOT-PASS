package ObjetosComprables;

import Logica.Juego;
import Personajes.*;

public class CoronaReyAragorn extends ComprableTemporal{
	
	public CoronaReyAragorn(Juego j){
		super(j);
		tiempo = 10;
		precio=20;
	}
	
	public void efecto() {
		System.out.println("Da�o aumentado");
		//Aumenta el danio de los Aliados en un 30%
		for(Aliado a:juego.getAliados())
			a.setDamage(a.getDamage()+(a.getDamage()/3));	
	}


}
