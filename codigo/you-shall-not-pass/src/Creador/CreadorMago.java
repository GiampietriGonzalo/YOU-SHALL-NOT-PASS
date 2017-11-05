package Creador;

import Logica.Juego;
import Personajes.Mago;

public class CreadorMago extends CreadorAliado {

	public CreadorMago(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(int x, int y) {
		// TODO Auto-generated method stub
		miJuego.colocarAliado(new Mago(), x, y);
	}

}
