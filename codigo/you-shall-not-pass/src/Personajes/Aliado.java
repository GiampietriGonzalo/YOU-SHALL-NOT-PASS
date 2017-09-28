package Personajes;

import java.awt.Color;

import Logica.Juego;

public abstract class Aliado extends Personaje {
	
	public Aliado(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}
	protected int precioAliado;
	protected Color color;
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	public Color getColor(){
		return color;
	}
}
