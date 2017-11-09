package Personajes;

public abstract class EstadoEnemigo {
	protected Enemigo miEnemigo;
	
	public EstadoEnemigo(Enemigo e){
		miEnemigo=e;
	}
	public abstract void relentizar();
}
