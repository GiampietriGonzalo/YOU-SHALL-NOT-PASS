package Creador;

import Logica.Juego;
import Personajes.Elfo;

public class CreadorElfo extends CreadorAliado {

	public CreadorElfo(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(int x, int y) {
		// TODO Auto-generated method stub
		miJuego.colocarAliado(new Elfo(), x, y);
	}
	
}
