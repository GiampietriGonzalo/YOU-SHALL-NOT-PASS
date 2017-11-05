package Creador;

import Logica.Juego;
import Personajes.Humano;

public class CreadorHumano extends CreadorAliado{

	public CreadorHumano(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(int x, int y) {
		// TODO Auto-generated method stub
		miJuego.colocarAliado(new Humano(), x, y);
	}

}
