package ObjetosMapa;

public abstract class ConVida extends ObjetoMapa{

	protected int vidaObjeto;
	
	public int getVida(){
		return vidaObjeto;
	
	}
	abstract public void recibirDamage();
	
}
