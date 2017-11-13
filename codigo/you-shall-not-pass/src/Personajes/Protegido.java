package Personajes;

public class Protegido extends EstadoEnemigo{

	public Protegido(Enemigo e) {
		super(e);
		miEnemigo.setVida(500000);
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+"Protegido.gif");
	}


	public void proteccion() {
		
	}

	public void relentizar() {
		
	}
}
