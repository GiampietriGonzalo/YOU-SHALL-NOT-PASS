package Creador;

import Logica.Juego;

abstract public class CreadorAliado {
	
	protected Juego miJuego;
	
	public CreadorAliado(Juego j){
		miJuego=j;
	}
	
	abstract public void crear(int x, int y);
	
}
