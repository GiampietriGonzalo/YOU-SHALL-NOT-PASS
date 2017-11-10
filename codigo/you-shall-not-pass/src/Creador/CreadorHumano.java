package Creador;

import Logica.Juego;
import Personajes.Humano;

public class CreadorHumano extends CreadorAliado{

	public CreadorHumano(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		juego.colocarAliado(new Humano(juego.getMapa()), x, y);
	}

}
