package Niveles;

import java.util.Stack;

import Logica.Juego;
import Personajes.Enemigo;

/**
 * Clase repesentante a los niveles del juego.
 * */

public abstract class Nivel {
	protected Juego juego;
	
	public Nivel(Juego j){
		juego=j;
	}
	
	/**
	 * Crea y retorna una nueva oleada de enemigos
	 * */	
	public abstract Stack<Enemigo> crearHorda();
}
