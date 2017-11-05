package Creador;

import Logica.Juego;
import Personajes.Enano;

public class CreadorEnano extends CreadorAliado {

	public CreadorEnano(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(int x, int y) {
		// TODO Auto-generated method stub
		miJuego.colocarAliado(new Enano(), x, y);
	}

}
