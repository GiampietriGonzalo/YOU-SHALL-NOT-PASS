package Mapa;

import Logica.GameObject;

public class Celda {
	private GameObject element;
	
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
