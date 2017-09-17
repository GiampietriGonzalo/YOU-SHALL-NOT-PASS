package Personajes;

import Logica.gameObject;

public abstract class Personaje extends gameObject {

	protected int vida;
	protected int rango;
	protected int da�o;
	
	public int getVida(){
		return vida;
	}
	
	public int getRango(){
		return rango;
	}
	
	public int getDa�o(){
		return da�o;
	}
	
	public void atacar(){
		//rellenar cuando se me ocurra algo
	}
	
	public void recibirDa�o(int d){
		vida-=d;
	}
	
}
