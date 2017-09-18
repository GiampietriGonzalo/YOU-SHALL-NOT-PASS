package Personajes;

import java.awt.Color;

public abstract class Aliado extends Personaje {
	
	public Aliado(int x, int y) {
		super(x, y);
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
