package Entidad;

import Logica.Juego;

public abstract class Magia extends Premio{
	
	protected int duracion;
	
	public Magia(Juego j) {
		super(j);
	}
	
	public int getDuracion(){return duracion;}

}
