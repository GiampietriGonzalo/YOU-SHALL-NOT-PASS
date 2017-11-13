package Personajes;

public class Relentizado extends EstadoEnemigo{

	public Relentizado(Enemigo e) {
		super(e);
		miEnemigo.setVelocidad(miEnemigo.getVelocidad()/2);
	}

	public void proteccion() {
	}


	public void relentizar() {
		//No vuelve a relentizar
	}

}
