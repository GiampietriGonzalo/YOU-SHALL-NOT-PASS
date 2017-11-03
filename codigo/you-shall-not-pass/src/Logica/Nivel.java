package Logica;

import java.util.Stack;

import Personajes.Enemigo;

public abstract class Nivel {
	protected Juego juego;
	
	public Nivel(Juego j){
		juego=j;
	}
	abstract Enemigo crearBoss();

	abstract Stack<Enemigo> crearHorda();
}
