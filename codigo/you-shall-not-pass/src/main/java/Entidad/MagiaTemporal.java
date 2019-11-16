package Entidad;

import Logica.Juego;

/**
 * Clase abstracta para el patr�n Strategy implementando el m�todo efecto().
 * */

public abstract class MagiaTemporal extends Premio{
	
	protected int duracion;
	
	public MagiaTemporal(Juego j) {
		super(j);
	}
	
	public int getDuracion(){
		return duracion;
	}

}
