package Entidad;

import Logica.Juego;

/**
 * Clase abstracta para el patrón Strategy implementando el método efecto().
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
