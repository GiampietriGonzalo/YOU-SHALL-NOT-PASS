package Personajes;

public class AliadoProtegido extends EstadoAliado {

	public AliadoProtegido(Aliado a) {
		super(a);
		miAliado.setVida(500000);
		miAliado.setSprite("/Imagenes/"+a.getClass().getSimpleName()+"Potenciado.gif");
	}

}
