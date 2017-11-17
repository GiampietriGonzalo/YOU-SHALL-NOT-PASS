package Entidad;

import Logica.Juego;


public abstract class MagiaTemporal extends Premio{
	
	protected int duracion;
	
	public MagiaTemporal(Juego j) {
		super(j);
	}
	
	public int getDuracion(){return duracion;}

}
