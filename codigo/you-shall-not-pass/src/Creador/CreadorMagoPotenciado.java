package Creador;

import Logica.Juego;
import Personajes.Mago;
import Personajes.Potenciado;

public class CreadorMagoPotenciado extends CreadorAliado {

	public CreadorMagoPotenciado(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		Mago e = new Mago(juego.getMapa());
		e.setEstado(new Potenciado(e));
		juego.getManipulador().colocarAliado(e,x,y);
	}

}