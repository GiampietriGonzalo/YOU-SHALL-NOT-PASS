package Niveles;

import java.util.Stack;

import Logica.Juego;
import Personajes.Enemigo;

public abstract class Nivel {
	protected Juego juego;
	
	public Nivel(Juego j){
		juego=j;
	}
	abstract Enemigo crearBoss();

	public abstract Stack<Enemigo> crearHorda();
}
