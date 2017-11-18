package Creador;

import Logica.Juego;
/**
 * Abstract Factory para la craci�n de Aliados. 
 * */
abstract public class CreadorAliado {
	
	protected Juego juego;
	
	public CreadorAliado(Juego j){
		juego=j;
	}
	
	/**
	 * Crea y coloca la ALiado en la posici�n xy del mapa.
	 * */
	abstract public void crear(int x, int y);
	
}
