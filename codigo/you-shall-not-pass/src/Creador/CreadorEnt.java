package Creador;

import Logica.Juego;
import Personajes.Ent;

public class CreadorEnt extends CreadorAliado {

	public CreadorEnt(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		if(y<5)
			miJuego.colocarEnt(new Ent(),x,y);
	}

}
