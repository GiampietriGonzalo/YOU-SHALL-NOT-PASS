package Creador;

import Logica.Juego;

abstract public class CreadorAliado {
	
	protected Juego juego;
	
	public CreadorAliado(Juego j){
		juego=j;
	}
	
	abstract public void crear(int x, int y);
	
}
