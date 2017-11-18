package Logica;

/**
 * Mapa del juego representada mediante una grilla
 * */

public class Mapa {
	protected Celda[][] grilla;
	
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
	
	
	/**
	 * Agrega un objeto pasado por paramétro en la posición (x,y).
	 * */
	public void agregarObjeto(GameObject j,int x, int y){
		grilla[x][y].setElement(j);
	}
	
	
	/**
	 * Elimina objeto pasado por paramétro que se encuentra en la posición (x,y).
	 * */
	public void eliminarObjeto(GameObject j,int x, int y){
		if(x<grilla.length && y<grilla[0].length) grilla[x][y].setElement(null);
	}
	
	/**
	 * Retorna un objeto que se encuentra en la posición (x,y).
	 * */
	public GameObject getObject(int x, int y){
		if(x<grilla.length && y<grilla[0].length) return grilla[x][y].getElement();
		else return null;
	}
}
