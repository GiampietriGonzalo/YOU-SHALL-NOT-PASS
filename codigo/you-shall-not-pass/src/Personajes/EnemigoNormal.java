package Personajes;

public class EnemigoNormal extends EstadoEnemigo{
	
	public EnemigoNormal(Enemigo e) {
		super(e);
		miEnemigo.setVida(e.getVidaOriginal());
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+".gif");
	}

	public void proteccion() {}

	public void relentizar() {}
	
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
