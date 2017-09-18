package Personajes;

import java.awt.Color;

public abstract class Aliado extends Personaje {
	
	protected int precioAliado;
	protected Color color;
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	public Color getColor(){
		return color;
	}
}
