package Creador;

import Logica.Juego;
import Personajes.Enano;
import Personajes.Potenciado;

public class CreadorEnanoPotenciado extends CreadorAliado {

	public CreadorEnanoPotenciado(Juego j) {
		super(j);
	}


	public void crear(int x, int y) {
		Enano e = new Enano(juego.getMapa());
		e.setEstado(new Potenciado(e));
		juego.getManipulador().colocarAliado(e,x,y);
	}

}