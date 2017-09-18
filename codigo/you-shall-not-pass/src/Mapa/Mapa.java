package Mapa;

import java.awt.Point;

import Personajes.Personaje;

public class Mapa {
	private Celda[][] grilla;
	
	public Mapa(int x, int y){
		grilla=new Celda[x][y];
		for(int i=0;i<grilla.length;i++){
			for(int j=0;j<grilla[0].length;j++){
				grilla[i][j]=new Celda();
			}
		}
	}
	
	public int getAlt(){
		return grilla[0].length; 
	}
	
	public int getAnch(){
		return grilla.length;
	}
	
	public void agregarPersonaje(Personaje j,int x, int y){
		grilla[x][y].setElement(j,x,y);
	}
}
