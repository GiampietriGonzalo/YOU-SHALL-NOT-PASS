package Personajes;

public class Relentizado extends EstadoEnemigo{

	public Relentizado(Enemigo e) {
		super(e);
		miEnemigo.setVelocidad(miEnemigo.getVelocidad()/2);
	}
}
