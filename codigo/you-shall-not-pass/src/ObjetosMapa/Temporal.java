package ObjetosMapa;

import Logica.Juego;

public abstract class Temporal extends ObjetoMapa{
	
	protected int tiempoDeVida;
	
	public Temporal(Juego j) {
		super(j);
	}
	public int getTiempoDeVida(){return tiempoDeVida;}

}
