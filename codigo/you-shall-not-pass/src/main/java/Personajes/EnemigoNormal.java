package Personajes;

/**
 * Clase que representa al estado normal de un enemigo.
 * */

public class EnemigoNormal extends EstadoEnemigo{
	
	public EnemigoNormal(Enemigo e) {
		super(e);
		miEnemigo.setVida(e.getVidaOriginal());
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+".gif");
	}

	public void proteccion() {}

	public void ralentizar() {
		
		miEnemigo.setEstado(new Ralentizado(miEnemigo));
		
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
