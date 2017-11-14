package Personajes;

public class Normal extends EstadoEnemigo{
	
	public Normal(Enemigo e) {
		super(e);
		miEnemigo.setProteccion(false);
		miEnemigo.setVida(e.getVidaOriginal());
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+".gif");
	}


	public void proteccion() {
		
	}

	public void relentizar() {
		
	}
}
