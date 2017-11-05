package Creador;

import Logica.Juego;
import Personajes.Ent;

public class CreadorEnt extends CreadorAliado {

	public CreadorEnt(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(int x, int y) {
		// TODO Auto-generated method stub
		miJuego.colocarEnt(new Ent(),x,y);
	}

}
