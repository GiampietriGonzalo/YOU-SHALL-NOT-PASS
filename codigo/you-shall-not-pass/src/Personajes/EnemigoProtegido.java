package Personajes;

import java.applet.Applet;
import java.applet.AudioClip;
/**
 * Clase que representa al estado protegeido de un enemigo.
 * */
public class EnemigoProtegido extends EstadoEnemigo{
	
	protected AudioClip proteccion = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/proteccion.wav"));
	
	public EnemigoProtegido(Enemigo e) {
		super(e);
		miEnemigo.setVida(500000);
		miEnemigo.setSprite("/Imagenes/"+e.getClass().getSimpleName()+"Protegido.gif");
	}


	public void proteccion() {
		
	}

	public void ralentizar() {
		
	}
	
	public void recibirDamage(int d, Personaje p){
			proteccion.play();
			if (p!=null){
				p.morir();
				p.eliminar();
		}
			miEnemigo.setEstado(new EnemigoNormal(miEnemigo));
	}
}