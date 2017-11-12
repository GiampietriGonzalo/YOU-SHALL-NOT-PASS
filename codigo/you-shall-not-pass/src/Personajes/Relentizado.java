package Personajes;

public class Relentizado extends EstadoEnemigo{

	public Relentizado(Enemigo e) {
		super(e);
		miEnemigo.setVelocidad(miEnemigo.getVelocidad()/2);
	}
	
	public void relentizar(){/*No vuelve a relentizar*/}

	@Override
	public void proteccion() {
		// TODO Auto-generated method stub
		
	}
}
