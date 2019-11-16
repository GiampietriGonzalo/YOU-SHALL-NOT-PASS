package Personajes;

/**
 * Clase que representa al estado normal de un aliado.
 * */

public class AliadoNormal extends EstadoAliado{
	
	public AliadoNormal(Aliado a) {
		super(a);
		miAliado.setVida(a.getVidaOriginal());
		miAliado.setDamage(a.getDamageOriginal());
		miAliado.setRango(a.getRangoOriginal());
		miAliado.setSprite("/Imagenes/"+a.getClass().getSimpleName()+".gif");

	}
}
