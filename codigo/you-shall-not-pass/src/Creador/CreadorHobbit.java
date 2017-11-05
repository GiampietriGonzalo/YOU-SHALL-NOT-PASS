package Creador;

import Logica.Juego;
import Personajes.Hobbit;

public class CreadorHobbit extends CreadorAliado {

	public CreadorHobbit(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(int x, int y) {
		// TODO Auto-generated method stub
		miJuego.colocarAliado(new Hobbit(),x,y);
	}

}
