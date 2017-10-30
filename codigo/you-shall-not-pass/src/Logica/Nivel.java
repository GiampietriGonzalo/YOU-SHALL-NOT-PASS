package Logica;

import java.util.Stack;

import Personajes.Enemigo;

public abstract class Nivel {
	protected Juego juego;
	
	public Nivel(Juego j){
		juego=j;
	}
	
	abstract Stack<Enemigo> crearPrimeraHorda();
	abstract Stack<Enemigo> crearSegundaHorda();
	abstract Stack<Enemigo> crearTerceraHorda();
	abstract Enemigo crearBoss();
}
