package Creador;

import Logica.Juego;
/**
 * Abstract Factory para la cración de Aliados. 
 * */
abstract public class CreadorAliado {
	
	protected Juego juego;
	
	public CreadorAliado(Juego j){
		juego=j;
	}
	
	/**
	 * Crea y coloca la ALiado en la posición xy del mapa.
	 * */
	abstract public void crear(int x, int y);
	
}
