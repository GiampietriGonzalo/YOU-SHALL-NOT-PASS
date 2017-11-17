package Logica;

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
