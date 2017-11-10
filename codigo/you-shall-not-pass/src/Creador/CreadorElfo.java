package Creador;

import Logica.Juego;
import Personajes.Elfo;

public class CreadorElfo extends CreadorAliado {

	public CreadorElfo(Juego j) {
		super(j);
	}
	
	public void crear(int x, int y) {
		juego.colocarAliado(new Elfo(juego.getMapa()), x, y);
	}
	
}
