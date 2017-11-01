package Entidad;

import Logica.GameObject;
import Logica.Juego;

public abstract class ObjetoPrecioso extends Premio{
	
	public ObjetoPrecioso(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	protected int tiempoDuracion;
	
	public int getDuracion() {return tiempoDuracion;}
	
}
