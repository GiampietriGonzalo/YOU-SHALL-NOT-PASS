package Personajes;

public class Protegido extends EstadoEnemigo{

	public Protegido(Enemigo e) {
		super(e);
		miEnemigo.setVida(500000);
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+"Protegido.gif");
	}

	@Override
	public void relentizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void proteccion() {
		// TODO Auto-generated method stub
		
	} 

}
