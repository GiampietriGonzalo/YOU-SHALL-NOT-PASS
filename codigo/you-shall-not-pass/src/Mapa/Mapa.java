package Mapa;

import java.awt.Point;

import Personajes.Personaje;

public class Mapa {
	private Celda[][] grilla;
	
	public Mapa(int x, int y){
		grilla=new Celda[x][y];
	}
	
	public int getAlt(){
		return grilla[0].length; 
	}
	
	public int getAnch(){
		return grilla.length;
	}
	
	public void agregarPersonaje(Personaje j,int x, int y){
		grilla[x][y].setElement(j);
	}
}
