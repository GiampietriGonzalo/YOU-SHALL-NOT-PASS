package Personajes;

public abstract class EstadoEnemigo {
	
	protected Enemigo miEnemigo;
	
	public EstadoEnemigo(Enemigo e){
		miEnemigo=e;
	}
	
	public abstract void proteccion();
	
	public abstract void ralentizar();

	public abstract void recibirDamage(int d, Personaje p);

}
