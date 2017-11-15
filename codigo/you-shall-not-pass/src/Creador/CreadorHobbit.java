package Creador;

import Logica.Juego;
import Personajes.Hobbit;

public class CreadorHobbit extends CreadorAliado {

	public CreadorHobbit(Juego j) {
		super(j);
	}


	public void crear(int x, int y) {
		juego.getManipulador().colocarAliado(new Hobbit(juego.getMapa()),x,y);
	}

}
