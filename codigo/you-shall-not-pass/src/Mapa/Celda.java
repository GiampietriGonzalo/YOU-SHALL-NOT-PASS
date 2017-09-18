package Mapa;

import Logica.GameObject;
import Personajes.Personaje;
import Logica.GameObject;

public class Celda {
	private Personaje element;
	private int x;
	private int y;
	
	public Celda(){
		element=null;
	}
	public void setElement(Personaje e,int y,int x){
		element=e;
		this.x=x;
		this.y=y;
	}
	
}
