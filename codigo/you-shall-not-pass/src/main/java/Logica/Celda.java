package Logica;

/**
 * Contenedor que complementa al mapa. Almacena cualquier tipo de objeto correspondiente al juego (Personaje, premio, etc).
 * */

public class Celda {
	protected GameObject element;
	
	public Celda(){
		element=null;
	}
	public void setElement(GameObject e){
		element=e;
	}
	public GameObject getElement(){
		return element;
	}
}
