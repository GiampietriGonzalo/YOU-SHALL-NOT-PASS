package Mapa;

import Logica.GameObject;

public class Celda {
	private GameObject element;
	private int x;
	private int y;
	
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
