package Creador;

import Logica.Juego;
import Personajes.Mago;

public class CreadorMago extends CreadorAliado {

	public CreadorMago(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		miJuego.colocarAliado(new Mago(), x, y);
	}

}
