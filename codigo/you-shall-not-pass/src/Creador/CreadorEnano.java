package Creador;

import Logica.Juego;
import Personajes.Enano;

public class CreadorEnano extends CreadorAliado {

	public CreadorEnano(Juego j) {
		super(j);
	}


	public void crear(int x, int y) {
		juego.getManipulador().colocarAliado(new Enano(juego.getMapa()), x, y);
	}

}
