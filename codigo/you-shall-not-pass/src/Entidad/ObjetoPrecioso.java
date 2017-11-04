package Entidad;

import Logica.Juego;

public abstract class ObjetoPrecioso extends Premio{
	
	public ObjetoPrecioso(Juego j) {
		super(j);
	}

	protected int tiempoDuracion;
	
	public int getDuracion() {return tiempoDuracion;}
	
}
