package Personajes;

public class Ralentizado extends EstadoEnemigo{

	public Ralentizado(Enemigo e) {
		super(e);
		miEnemigo.setVida(miEnemigo.vida);
		miEnemigo.setVelocidad(miEnemigo.getVelocidad()/2);
	}

	public void proteccion() {
	
	}


	public void ralentizar() {
		//No vuelve a relentizar
	}
	
	public void recibirDamage(int d, Personaje p){
		miEnemigo.setVida(miEnemigo.getVida()-d);
		if(miEnemigo.getVida() <= 0){ 
			miEnemigo.setSprite("/Imagenes/sangre.gif");
			miEnemigo.morir();
			if (p!= null)
			p.setSprite("/Imagenes/"+p.getClass().getSimpleName()+".gif");
		}
	}

}
