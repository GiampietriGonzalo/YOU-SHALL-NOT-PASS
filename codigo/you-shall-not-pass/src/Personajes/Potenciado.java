package Personajes;

public class Potenciado extends EstadoAliado{
	
	public Potenciado(Aliado a) {
		super(a);
		a.setSprite("/Imagenes/"+a.getClass().getSimpleName()+"Potenciado.gif");
		a.setDamage((a.getDamage()+(a.getDamage()/2)));
	}
}
