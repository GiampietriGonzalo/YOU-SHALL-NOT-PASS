package Personajes;

import java.awt.Color;

import Logica.Juego;

public abstract class Aliado extends Personaje {
	
	public Aliado(int x,int y,Juego j) {
		super(j);
		this.x=x;
		this.y=y;
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
