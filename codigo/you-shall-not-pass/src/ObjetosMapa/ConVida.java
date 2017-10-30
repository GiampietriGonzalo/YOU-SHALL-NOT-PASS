package ObjetosMapa;

import Logica.Juego;

public abstract class ConVida extends ObjetoMapa{

	protected int vidaObjeto;
	
	public ConVida(Juego j) {
		super(j);
	}
	
	public int getVida(){
		return vidaObjeto;
	
	}
	abstract public void recibirDamage();
	
}
